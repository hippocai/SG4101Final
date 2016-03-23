package com.ft9.service;

import java.util.List;
import java.util.Map;

import com.ft9.bean.ProductBean;

public interface IProductService {
	public List<ProductBean>getProductByMap(Map<String,String>map);
	public List<ProductBean>getAllProducts();
	public List<ProductBean>searchProductByKey(String key,String valueLike);
	public List<ProductBean>getProductByKey(String key,String value);
	public List<ProductBean>getProductsBelowThreshold();
	public int getMaxProductNumerOfCategory(String categoryName);
	public boolean deleteProductByMap(Map<String,String>map);
	public boolean addProductByByBean(ProductBean productBean);
	public boolean updateProductByBean(ProductBean productBean);
	public String[]getAllCategory();
}
