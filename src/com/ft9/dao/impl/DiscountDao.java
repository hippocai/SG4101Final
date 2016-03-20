package com.ft9.dao.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.ft9.bean.DiscountBean;
import com.ft9.common.FileConst;
import com.ft9.dao.DaoException;
import com.ft9.dao.intl.IDiscountDao;

public class DiscountDao extends BaseDao implements IDiscountDao {
	private DiscountDao() throws FileNotFoundException, IOException{
		super(FileConst.getFileNameByBeanName("Discount"));
	}
	
	private static DiscountDao discountDao=null;
	public static DiscountDao getInstance() throws FileNotFoundException, IOException{
		if(discountDao==null){
			discountDao=new DiscountDao();
		}
		return discountDao;
	}
	
	public List<DiscountBean>getDiscountsByMap(Map<String,String>map){
		try {
			return super.<DiscountBean>transferObjectList2BeanList(super.getBeanByMap(map));
		} catch (DaoException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean insertDiscountByBean(DiscountBean discountBean){
		return super.addBean(discountBean);
	}
	
	public int deleteDiscountByMap(Map<String,String>map){
		return super.deleteBeanByMap(map);
	}
	
	public int updateDiscount(DiscountBean discountBean,Map<String,String>map){
		return super.updateBeanByMap(discountBean, map);
	}
}
