package com.ft9.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ft9.bean.DiscountBean;
import com.ft9.dao.DAOer;
import com.ft9.dao.DaoNotExistException;
import com.ft9.dao.impl.DiscountDao;
import com.ft9.dao.intl.IDiscountDao;
import com.ft9.service.IDiscountService;
import com.ft9.util.BeanUtil;

/**
 * class name:DiscountService <BR>
 * class description: Implements Of The Functions In IDiscountService <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Guo Qi
 */
public class DiscountService implements IDiscountService {

	private IDiscountDao discountDao=null;
	private static DiscountService discountService=null;
	private DiscountService() throws DaoNotExistException{
		discountDao=(DiscountDao)DAOer.getDao("Discount");
	}
	
	/**
	 * Method name: getInstance <BR>
	 * Description: Get An Instance Of DiscountService <BR>
	 * Remark: <BR>
	 * @return discountService
	 * @throws DaoNotExistException  DiscountService<BR>
	 */
	public static DiscountService getInstance() throws DaoNotExistException{
		if(discountService==null){
			discountService=new DiscountService();
		}
		return discountService;
	}
	/**
	 * @Override
	 * @see com.ft9.service.IDiscountService#getDiscountByMap(java.util.Map) <BR>
	 * Method name: getDiscountByMap <BR>
	 * Description: Get Discount By Map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return List <BR>
	*/
	@Override
	public List<DiscountBean> getDiscountByMap(Map<String, String> map) {
		// TODO 自动生成的方法存根
		if(map!=null){
			return discountDao.getDiscountsByMap(map);
		}
		return null;
	}

	/**
	 * @Override
	 * @see com.ft9.service.IDiscountService#getAllDiscountInfo() <BR>
	 * Method name: getAllDiscountInfo <BR>
	 * Description: Get All Discount Information <BR>
	 * Remark: <BR>
	 * @return List <BR>
	*/
	@Override
	public List<DiscountBean> getAllDiscountInfo() {
		// TODO 自动生成的方法存根
		return this.getDiscountByMap(new HashMap<String,String>());
	}

	/**
	 * @Override
	 * @see com.ft9.service.IDiscountService#searchDiscountByKey(java.lang.String, java.lang.String) <BR>
	 * Method name: searchDiscountByKey <BR>
	 * Description: Search Discount By Key <BR>
	 * Remark: <BR>
	 * @param key
	 * @param valueLike
	 * @return List <BR>
	*/
	@Override
	public List<DiscountBean> searchDiscountByKey(String key, String valueLike) {
		// TODO 自动生成的方法存根
		List<DiscountBean>discountList=this.getAllDiscountInfo();
		if(valueLike==null||valueLike.equals("")){
			return discountList;
		}
		List<DiscountBean>searchResult=new ArrayList<DiscountBean>();
		for(DiscountBean discountBean:discountList){
			Map<String,String>discountMap=BeanUtil.transBean2Map(discountBean);
			if(discountMap.containsKey(key)){
				if(discountMap.get(key).contains(valueLike)){
					searchResult.add(discountBean);
				}
			}
		}
		return searchResult;
	}

	/**
	 * @Override
	 * @see com.ft9.service.IDiscountService#deleteDiscountByMap(java.util.Map) <BR>
	 * Method name: deleteDiscountByMap <BR>
	 * Description: Delete Discount By Map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return int <BR>
	*/
	@Override
	public int deleteDiscountByMap(Map<String, String> map) {
		// TODO 自动生成的方法存根
		if(map==null){
			return -1;
		}
		return discountDao.deleteDiscountByMap(map);
	}

	/**
	 * @Override
	 * @see com.ft9.service.IDiscountService#deleteDiscountByCode(java.lang.String) <BR>
	 * Method name: deleteDiscountByCode <BR>
	 * Description: Delete Discount By Code <BR>
	 * Remark: <BR>
	 * @param code
	 * @return boolean <BR>
	*/
	@Override
	public boolean deleteDiscountByCode(String code) {
		// TODO 自动生成的方法存根
		Map<String,String>map=new HashMap<String,String>();
		map.put("code", code);
		return this.deleteDiscountByMap(map)>0;
	}

	/**
	 * @Override
	 * @see com.ft9.service.IDiscountService#isCodeExist(java.lang.String) <BR>
	 * Method name: isCodeExist <BR>
	 * Description: Check If Discount Code Existed <BR>
	 * Remark: <BR>
	 * @param code
	 * @return boolean <BR>
	*/
	@Override
	public boolean isCodeExist(String code) {
		// TODO 自动生成的方法存根
		Map<String,String>map=new HashMap<String,String>();
		map.put("code", code);
		return this.getDiscountByMap(map).size()>0;
	}

	/**
	 * @Override
	 * @see com.ft9.service.IDiscountService#addNewDiscount(com.ft9.bean.DiscountBean) <BR>
	 * Method name: addNewDiscount <BR>
	 * Description: Add New Discount <BR>
	 * Remark: <BR>
	 * @param discountBean
	 * @return boolean <BR>
	*/
	@Override
	public boolean addNewDiscount(DiscountBean discountBean) {
		// TODO 自动生成的方法存根
		if(discountBean==null){
			return false;
		}
		return discountDao.insertDiscountByBean(discountBean);
	}

	/**
	 * @Override
	 * @see com.ft9.service.IDiscountService#updateDiscount(com.ft9.bean.DiscountBean) <BR>
	 * Method name: updateDiscount <BR>
	 * Description: Modify Discount <BR>
	 * Remark: <BR>
	 * @param discountBean
	 * @return boolean <BR>
	*/
	@Override
	public boolean updateDiscount(DiscountBean discountBean) {
		// TODO 自动生成的方法存根
		Map<String,String>map=new HashMap<String,String>();
		map.put("code", discountBean.getCode());
		
		return discountDao.updateDiscount(discountBean, map)>0;
	}

}
