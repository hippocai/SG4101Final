package com.ft9.dao.intl;

import java.util.List;
import java.util.Map;

import com.ft9.bean.ProductBean;

public interface IProductDao {
	public List<ProductBean>getProductsByMap(Map<String,String>map);
	public boolean insertProductByBean(ProductBean productBean);
	
	public int deleteProductByMap(Map<String,String>map);
	
	public int updateProduct(ProductBean productBean,Map<String,String>map);
}
