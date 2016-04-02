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
 * class name:BaseDao <BR>
 * class description: Provide the implementation of all necessary methods for each specific Dao<BR>
 * Remark: <BR>
 * @version 1.00 2016Äê3ÔÂ30ÈÕ
 * @author caiyicheng
 */
public abstract class BaseDao {
	private static Logger log = Logger.getLogger(BaseDao.class);
	//Manage the file
	private FileUtil fileUtil=null;

	/**
	 * Method name: getBeanByMap <BR>
	 * Description: Get the bean by search map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  List<Object><BR>
	 */
	protected List<Object> getBeanByMap(Map<String,String>map){
		log.info("(DAO)Get Bean By Map:"+StringUtil.transferStringmap2String(map));
		
		List<Object>selectedBeanList=new ArrayList<Object>();
		try {
			List<Object>savedBeans=this.getAllTheBeansFromFile();
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
			e.printStackTrace();
		}
		return selectedBeanList;
	}
	
	/**
	 * Method name: addBean <BR>
	 * Description: Add a new bean into file <BR>
	 * Remark: <BR>
	 * @param bean
	 * @return  boolean<BR>
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
			//this.savedBeans=this.getAllTheBeansFromFile();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	/**
	 * Method name: deleteBeanByMap <BR>
	 * Description: Delete the bean by the search map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  int<BR>
	 */
	protected int deleteBeanByMap(Map<String,String>map){
		try{
			log.info("(DAO)Delete Bean By Map:"+StringUtil.transferStringmap2String(map));
			List<Object> savedBeans=this.getAllTheBeansFromFile();
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
	 * Method name: updateBeanByMap <BR>
	 * Description: Update the Record by the new bean and search map <BR>
	 * Remark: <BR>
	 * @param newBean
	 * @param map
	 * @return  int<BR>
	 */
	protected int updateBeanByMap(Object newBean,Map<String,String> map){
		try{
			log.info("(DAO)Update Bean,New Bean"+StringUtil.transferStringmap2String(BeanUtil.transBean2Map(newBean))
					+" Select Map:"+StringUtil.transferStringmap2String(map));
			@SuppressWarnings("unused")
			List<Object>savedBeans=this.getAllTheBeansFromFile();
			List<Object>selectedBeanList=this.getBeanByMap(map);
			for(Object bean:selectedBeanList){
				if(BeanUtil.getBeanName(bean)==null||!BeanUtil.getBeanName(bean).equals(this.getSubClassName())){
					throw new Exception("Bean Type is not equal to the dao");
				}
				String oldRecord=this.transBeanToStringRecord(bean);
				fileUtil.replaceRowByStr(oldRecord, this.transBeanToStringRecord(newBean));
				
			}
			
			log.info("(DAO) "+selectedBeanList.size()+"Rows Affected");
			return selectedBeanList.size();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	/**
	 * Method name: getAllTheBeansFromFile <BR>
	 * Description: Get all the record from the file <BR>
	 * Remark: <BR>
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException  List<Object><BR>
	 */
	protected List<Object>getAllTheBeansFromFile() throws FileNotFoundException, IOException{
		List<String> recordList=fileUtil.readWholeFileSplitToList();
		recordList.remove("");
		List<Object>beanList=new ArrayList<Object>();
		for(String record:recordList){
			beanList.add(this.transferStringRecoderToBean(record));
		}
		return beanList;
		
	}
	/**
	 * Method name: BaseDao<BR>
	 * Description: The constructor of the base dao<BR>
	 * Remark: The file path can be get from the FileConst<BR>
	 * @param filePath
	 * @throws FileNotFoundException
	 * @throws IOException <BR>
	 */
	public BaseDao(String filePath) throws FileNotFoundException, IOException{
		this.fileUtil=new FileUtil(filePath);
		@SuppressWarnings("unused")
		List<Object>savedBeans=this.getAllTheBeansFromFile();
	}
	/**
	 * Method name: getFileUtil <BR>
	 * Description: Get the file util <BR>
	 * Remark: <BR>
	 * @return  FileUtil<BR>
	 */
	protected FileUtil getFileUtil(){
		return fileUtil;
	}
	/**
	 * Method name: transferBean2Map <BR>
	 * Description: Transfer the bean to HashMap <BR>
	 * Remark: <BR>
	 * @param bean
	 * @return  Map<String,String><BR>
	 */
	protected Map<String,String>transferBean2Map(Object bean){
		
		return BeanUtil.transBean2Map(bean);
	}
	
	/**
	 * Method name: getSubClassName <BR>
	 * Description: Get the current dao class name which is derived from the base dao<BR>
	 * Remark: <BR>
	 * @return  String<BR>
	 */
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
	
	/**
	 * Method name: mapAIsSubsetOfMapB <BR>
	 * Description: Check if the map A is a subset of the map B<BR>
	 * Remark: <BR>
	 * @param A
	 * @param B
	 * @return
	 * @throws KeyNotExistException  boolean<BR>
	 */
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
	
	/**
	 * Method name: getFileContent <BR>
	 * Description: Get all the content from the file,and put each line into a list <BR>
	 * Remark: <BR>
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException  List<String><BR>
	 */
	protected List<String>getFileContent() throws FileNotFoundException, IOException{
		return fileUtil.readWholeFileSplitToList();
	}
	
	/**
	 * Method name: transBeanToStringRecord <BR>
	 * Description: Transfer each bean to a String with specific format <BR>
	 * Remark: <BR>
	 * @param bean
	 * @return  String<BR>
	 */
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
	
	/**
	 * Method name: transferStringRecoderToBean <BR>
	 * Description: Transfer String record to the bean,with the specific format <BR>
	 * Remark: <BR>
	 * @param recorder
	 * @return  Object<BR>
	 */
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
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	/**
	 * Method name: transferObj2Bean <BR>
	 * Description: Transfer an object to a specific bean <BR>
	 * Remark: <BR>
	 * @param obj
	 * @return
	 * @throws DaoException  T<BR>
	 */
	@SuppressWarnings("unchecked")
	protected <T>T transferObj2Bean(Object obj)throws DaoException{
		Object testObj=(T)new Object();
		if(testObj.getClass().getName().equals(obj.getClass().getName())){
			throw new DaoException("Type Not Same:1."+testObj.getClass().getName()+"  2."+obj.getClass().getName());
		}
		return (T)obj;
	}
	/**
	 * Method name: transferObjectList2BeanList <BR>
	 * Description: Transfer an object list to a specific bean list <BR>
	 * Remark: <BR>
	 * @param objList
	 * @return
	 * @throws DaoException  List<T><BR>
	 */
	protected <T>List<T>transferObjectList2BeanList(List<Object>objList) throws DaoException{
		List<T> beanList=new ArrayList<T>();
		for(Object beanObj:objList){
			beanList.add(this.<T>transferObj2Bean(beanObj));
		}
		return beanList;
	}
}
