package com.ft9.service;

import java.util.List;
import java.util.Map;

import com.ft9.bean.DiscountBean;

public interface IDiscountService {
	public List<DiscountBean>getDiscountByMap(Map<String,String>map);
	public List<DiscountBean>getAllDiscountInfo();
	public List<DiscountBean>searchDiscountByKey(String key,String valueLike);
	public int deleteDiscountByMap(Map<String,String>map);
	public boolean deleteDiscountByCode(String code);
	public boolean isCodeExist(String code);
	public boolean addNewDiscount(DiscountBean discountBean);
	public boolean updateDiscount(DiscountBean discountBean);
	
}
