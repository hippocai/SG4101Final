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

public class DiscountService implements IDiscountService {

	private IDiscountDao discountDao=null;
	private static DiscountService discountService=null;
	private DiscountService() throws DaoNotExistException{
		discountDao=(DiscountDao)DAOer.getDao("Discount");
	}
	
	public static DiscountService getInstance() throws DaoNotExistException{
		if(discountService==null){
			discountService=new DiscountService();
		}
		return discountService;
	}
	@Override
	public List<DiscountBean> getDiscountByMap(Map<String, String> map) {
		// TODO 自动生成的方法存根
		if(map!=null){
			return discountDao.getDiscountsByMap(map);
		}
		return null;
	}

	@Override
	public List<DiscountBean> getAllDiscountInfo() {
		// TODO 自动生成的方法存根
		return this.getDiscountByMap(new HashMap<String,String>());
	}

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

	@Override
	public int deleteDiscountByMap(Map<String, String> map) {
		// TODO 自动生成的方法存根
		if(map==null){
			return -1;
		}
		return discountDao.deleteDiscountByMap(map);
	}

	@Override
	public boolean deleteDiscountByCode(String code) {
		// TODO 自动生成的方法存根
		Map<String,String>map=new HashMap<String,String>();
		map.put("code", code);
		return this.deleteDiscountByMap(map)>0;
	}

	@Override
	public boolean isCodeExist(String code) {
		// TODO 自动生成的方法存根
		Map<String,String>map=new HashMap<String,String>();
		map.put("code", code);
		return false;
	}

	@Override
	public boolean addNewDiscount(DiscountBean discountBean) {
		// TODO 自动生成的方法存根
		if(discountBean==null){
			return false;
		}
		return discountDao.insertDiscountByBean(discountBean);
	}

	@Override
	public boolean updateDiscount(DiscountBean discountBean) {
		// TODO 自动生成的方法存根
		Map<String,String>map=new HashMap<String,String>();
		map.put("code", discountBean.getCode());
		
		return discountDao.updateDiscount(discountBean, map)>0;
	}

}
