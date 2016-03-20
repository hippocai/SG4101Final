package com.ft9.dao.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;






import org.apache.log4j.Logger;

import com.ft9.common.FileConst;
import com.ft9.common.StructConst;
import com.ft9.dao.DaoException;
import com.ft9.dao.KeyNotExistException;
import com.ft9.util.BeanUtil;
import com.ft9.util.FileUtil;
import com.ft9.util.StringUtil;
/**
 * @author CaiYicheng
 */
public abstract class BaseDao {
	private static Logger log = Logger.getLogger(BaseDao.class);
	private FileUtil fileUtil=null;
	List<Object>savedBeans;
	/**
	 * @param map
	 * @return
	 */
	protected List<Object> getBeanByMap(Map<String,String>map){
		log.info("(DAO)Get Bean By Map:"+StringUtil.transferStringmap2String(map));
		List<Object>selectedBeanList=new ArrayList<Object>();
		try {
			List<Object>beansList=savedBeans;
			
			if(map==null||map.isEmpty()){
				return beansList;
			}
			for(int i=0;i<beansList.size();++i){
				Map<String,String> beanMap=this.transferBean2Map(beansList.get(i));
				
				if(mapAIsSubsetOfMapB(map, beanMap)){
					selectedBeanList.add(beansList.get(i));
				}
			}
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return selectedBeanList;
	}
	/**
	 * @param bean
	 * @return
	 */
	protected boolean addBean(Object bean){
		try {
			log.info("(DAO)Add Bean:"+StringUtil.transferStringmap2String(BeanUtil.transBean2Map(bean)));
		//	System.out.println(BeanUtil.getBeanName(bean));
			if(BeanUtil.getBeanName(bean)==null||!BeanUtil.getBeanName(bean).equals(this.getSubClassName())){
				throw new Exception("Bean Type is not equal to the dao");
			}
			String record=this.transBeanToStringRecord(bean);
			fileUtil.writeToFile(record, FileUtil.APPEND);
			this.savedBeans=this.getAllTheBeansFromFile();
			return true;
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * @param map
	 * @return
	 */
	protected int deleteBeanByMap(Map<String,String>map){
		try{
			log.info("(DAO)Delete Bean By Map:"+StringUtil.transferStringmap2String(map));
			List<Object>selectedBeanList=this.getBeanByMap(map);
			for(Object bean:selectedBeanList){
				if(BeanUtil.getBeanName(bean)==null||!BeanUtil.getBeanName(bean).equals(this.getSubClassName())){
					throw new Exception("Bean Type is not equal to the dao");
				}
				String record=this.transBeanToStringRecord(bean);
				fileUtil.deleteRow(record);
			}
			savedBeans=this.getAllTheBeansFromFile();
			log.info("(DAO) "+selectedBeanList.size()+"Rows Affected");
			return selectedBeanList.size();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	/**
	 * @param newBean
	 * @param map
	 * @return
	 */
	protected int updateBeanByMap(Object newBean,Map<String,String> map){
		try{
			log.info("(DAO)Update Bean,New Bean"+StringUtil.transferStringmap2String(BeanUtil.transBean2Map(newBean))
					+" Select Map:"+StringUtil.transferStringmap2String(map));
			
			List<Object>selectedBeanList=this.getBeanByMap(map);
			for(Object bean:selectedBeanList){
				if(BeanUtil.getBeanName(bean)==null||!BeanUtil.getBeanName(bean).equals(this.getSubClassName())){
					throw new Exception("Bean Type is not equal to the dao");
				}
				String oldRecord=this.transBeanToStringRecord(bean);
				fileUtil.replaceRowByStr(oldRecord, this.transBeanToStringRecord(newBean));
				
			}
			savedBeans=this.getAllTheBeansFromFile();
			log.info("(DAO) "+selectedBeanList.size()+"Rows Affected");
			return selectedBeanList.size();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	protected List<Object>getAllTheBeansFromFile() throws FileNotFoundException, IOException{
		List<String> recordList=fileUtil.readWholeFileSplitToList();
		recordList.remove("");
		List<Object>beanList=new ArrayList<Object>();
		for(String record:recordList){
			beanList.add(this.transferStringRecoderToBean(record));
		}
		return beanList;
		
	}
	public BaseDao(String filePath) throws FileNotFoundException, IOException{
		this.fileUtil=new FileUtil(filePath);
		savedBeans=this.getAllTheBeansFromFile();
	}
	protected FileUtil getFileUtil(){
		return fileUtil;
	}
	protected Map<String,String>transferBean2Map(Object bean){
		
		return BeanUtil.transBean2Map(bean);
	}
	
	private String getSubClassName(){
		String classFullName=this.getClass().getName();
		String className=null;
		if(classFullName.endsWith("Dao")){
			className=classFullName.substring(classFullName.lastIndexOf(".")+1,classFullName.length()-3);
		}else{
			className=classFullName.substring(classFullName.lastIndexOf(".")+1);
		}
		return className;
	}
	
	
	
	private boolean mapAIsSubsetOfMapB(Map<String,String> A,Map<String,String> B)throws KeyNotExistException{
		boolean meetTheSelectRequirement=true;
		for(String key:A.keySet()){
			String value=A.get(key);
			
			if(!B.containsKey(key)){
				throw new KeyNotExistException(key);
			}else if(B.get(key)==null&&value==null){
				continue;
			}else if(!B.get(key).equals(value)){
				meetTheSelectRequirement=false;
				break;
			}
		}
		return meetTheSelectRequirement;
	}
	
	protected List<String>getFileContent() throws FileNotFoundException, IOException{
		return fileUtil.readWholeFileSplitToList();
	}
	
	private String transBeanToStringRecord(Object bean){
		List<String>formatList=FileConst.getRecordFormatList(BeanUtil.getBeanName(bean));
		Map<String,String>beanMap=BeanUtil.transBean2Map(bean);
		String record="";
		for(String formatUnit:formatList){
			if(!record.equals("")){
				record+=",";
			}
			record+=beanMap.get(formatUnit);
		}
		return record;
	}
	
	private Object transferStringRecoderToBean(String recorder){
		try {
			List<String>formatList=FileConst.getRecordFormatList(this.getSubClassName());
			String []recordParam=recorder.split(",");
			Map<String,String>beanMap=new HashMap<String,String>();
			for(int i=0;i<formatList.size();++i){
				beanMap.put(formatList.get(i), recordParam[i]);
			}
			Object bean=Class.forName(StructConst.BeanPackage+"."+this.getSubClassName()+"Bean").newInstance();
			BeanUtil.transMap2Bean(beanMap,bean);
			return bean;
		} catch (InstantiationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	protected <T>T transferObj2Bean(Object obj)throws DaoException{
		Object testObj=(T)new Object();
		if(testObj.getClass().getName().equals(obj.getClass().getName())){
			throw new DaoException("Type Not Same:1."+testObj.getClass().getName()+"  2."+obj.getClass().getName());
		}
		return (T)obj;
	}
	protected <T>List<T>transferObjectList2BeanList(List<Object>objList) throws DaoException{
		List<T> beanList=new ArrayList<T>();
		for(Object beanObj:objList){
			beanList.add(this.<T>transferObj2Bean(beanObj));
		}
		return beanList;
	}
}
