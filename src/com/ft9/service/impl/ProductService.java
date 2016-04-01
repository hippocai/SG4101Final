package com.ft9.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ft9.bean.CategoryBean;
import com.ft9.bean.ProductBean;
import com.ft9.dao.DAOer;
import com.ft9.dao.DaoNotExistException;
import com.ft9.dao.impl.CategoryDao;
import com.ft9.dao.impl.ProductDao;
import com.ft9.dao.intl.ICategoryDao;
import com.ft9.dao.intl.IProductDao;
import com.ft9.service.IProductService;
import com.ft9.util.BeanUtil;

/**
 * class name:ProductService <BR>
 * class description: please write your description <BR>
 * Remark: <BR>
 * @version 1.00 2016年4月1日
 * @author Guo Qi
 */
public class ProductService implements IProductService {

	private static ProductService productService=null;
	public static ProductService getInstance() throws DaoNotExistException{
		if(productService==null){
			productService=new ProductService();
		}
		return productService;
	}
	
	private IProductDao productDao;
	private ICategoryDao categoryDao;
	private ProductService() throws DaoNotExistException{
		productDao=(ProductDao)DAOer.getDao("Product");
		categoryDao=(CategoryDao)DAOer.getDao("Category");
	}
	@Override
	public List<ProductBean> getProductByMap(Map<String, String> map) {
		// TODO 自动生成的方法存根
		if(map==null){
			return null;
		}
		return productDao.getProductsByMap(map);
	}

	@Override
	public List<ProductBean> getAllProducts() {
		// TODO 自动生成的方法存根
		return this.getProductByMap(new HashMap<String,String>());
	}

	@Override
	public List<ProductBean> searchProductByKey(String key, String valueLike) {
		// TODO 自动生成的方法存根
		List<ProductBean>productList=this.getAllProducts();
		if(valueLike==null||valueLike.equals("")){
			return productList;
		}
		List<ProductBean>searchResult=new ArrayList<ProductBean>();
		for(ProductBean productBean:productList){
			Map<String,String>productMap=BeanUtil.transBean2Map(productBean);
			if(productMap.containsKey(key)){
				if(productMap.get(key).contains(valueLike)){
					searchResult.add(productBean);
				}
			}
		}
		return searchResult;
	}

	@Override
	public List<ProductBean> getProductByKey(String key, String value) {
		// TODO 自动生成的方法存根
		Map<String,String>map=new HashMap<String,String>();
		map.put(key, value);
		return this.getProductByMap(map);
	}

	@Override
	public int getMaxProductNumerOfCategory(String categoryCode) {
		// TODO 自动生成的方法存根
		List<ProductBean>productBeanList=this.getAllProducts();
		int maxNum=1;
		for(ProductBean productBean:productBeanList){
			String id=productBean.getId();
			String categoryCodeOfProduct=id.substring(0,id.indexOf("/"));
			//System.out.println(categoryCodeOfProduct);
			String numStr=id.substring(id.indexOf("/")+1);
			if(categoryCodeOfProduct.equals(categoryCode)){
				if(Integer.parseInt(numStr)>maxNum){
					maxNum=Integer.parseInt(numStr);
				}
			}
		}
		return maxNum+1;
	}

	@Override
	public boolean deleteProductByMap(Map<String, String> map) {
		// TODO 自动生成的方法存根
		if(map==null){
			return false;
		}
		return productDao.deleteProductByMap(map)>0;
	}

	@Override
	public boolean addProductByBean(ProductBean productBean) {
		// TODO 自动生成的方法存根
		if(productBean==null){
			return false;
		}
		return productDao.insertProductByBean(productBean);
	}

	@Override
	public boolean updateProductByBean(ProductBean productBean) {
		// TODO 自动生成的方法存根
		if(productBean==null){
			return false;
		}
		Map<String,String>map=new HashMap<String,String>();
		map.put("id", productBean.getId());
		return productDao.updateProduct(productBean, map)>0;
		
	}
	@Override
	public String[] getAllCategory() {
		// TODO 自动生成的方法存根
		List<CategoryBean>categoryList=categoryDao.getCategorysByMap(new HashMap<String,String>());
		List<String>categoryIdList=new ArrayList<String>();
		for(CategoryBean categoryBean:categoryList){
			categoryIdList.add(categoryBean.getCode());
		}
		String[] stringArr=new String[categoryIdList.size()];
		return categoryIdList.toArray(stringArr);
	}
	@Override
	public List<ProductBean> getProductsBelowThreshold() {
		// TODO 自动生成的方法存根
		List<ProductBean>allBeanList=this.getAllProducts();
		List<ProductBean>selectedBeanList=new ArrayList<ProductBean>();
		for(ProductBean productBean:allBeanList){
			String quantity=productBean.getQuantityAvailable();
			String threshold=productBean.getReorderQuantity();
			if(Integer.parseInt(threshold)>Integer.parseInt(quantity)){
				selectedBeanList.add(productBean);
			}
		}
		return selectedBeanList;
	}

}
