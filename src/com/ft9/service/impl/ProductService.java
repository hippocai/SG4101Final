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
 * class description: Implements Of Functions In ProductService <BR>
 * Remark: <BR>
 * @version 1.00
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
	/**
	 * @Override
	 * @see com.ft9.service.IProductService#getProductByMap(java.util.Map) <BR>
	 * Method name: getProductByMap <BR>
	 * Description: Get Product By Map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return List <BR>
	*/
	@Override
	public List<ProductBean> getProductByMap(Map<String, String> map) {
		// TODO
		if(map==null){
			return null;
		}
		return productDao.getProductsByMap(map);
	}

	/**
	 * @Override
	 * @see com.ft9.service.IProductService#getAllProducts() <BR>
	 * Method name: getAllProducts <BR>
	 * Description: Get All Products Information <BR>
	 * Remark: <BR>
	 * @return List <BR>
	*/
	@Override
	public List<ProductBean> getAllProducts() {
		return this.getProductByMap(new HashMap<String,String>());
	}

	/**
	 * @Override
	 * @see com.ft9.service.IProductService#searchProductByKey(java.lang.String, java.lang.String) <BR>
	 * Method name: searchProductByKey <BR>
	 * Description: Search Product By Key <BR>
	 * Remark: <BR>
	 * @param key
	 * @param valueLike
	 * @return List <BR>
	*/
	@Override
	public List<ProductBean> searchProductByKey(String key, String valueLike) {
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

	/**
	 * @Override
	 * @see com.ft9.service.IProductService#getProductByKey(java.lang.String, java.lang.String) <BR>
	 * Method name: getProductByKey <BR>
	 * Description: Get Product By Key <BR>
	 * Remark: <BR>
	 * @param key
	 * @param value
	 * @return List <BR>
	*/
	@Override
	public List<ProductBean> getProductByKey(String key, String value) {
		Map<String,String>map=new HashMap<String,String>();
		map.put(key, value);
		return this.getProductByMap(map);
	}

	/**
	 * @Override
	 * @see com.ft9.service.IProductService#getMaxProductNumerOfCategory(java.lang.String) <BR>
	 * Method name: getMaxProductNumerOfCategory <BR>
	 * Description: Get Auto-Generated Product Number Of Category <BR>
	 * Remark: <BR>
	 * @param categoryCode
	 * @return int <BR>
	*/
	@Override
	public int getMaxProductNumerOfCategory(String categoryCode) {
		List<ProductBean>productBeanList=this.getAllProducts();
		int maxNum=1;
		for(ProductBean productBean:productBeanList){
			String id=productBean.getId();
			String categoryCodeOfProduct=id.substring(0,id.indexOf("/"));
			String numStr=id.substring(id.indexOf("/")+1);
			if(categoryCodeOfProduct.equals(categoryCode)){
				if(Integer.parseInt(numStr)>maxNum){
					maxNum=Integer.parseInt(numStr);
				}
			}
		}
		return maxNum+1;
	}

	/**
	 * @Override
	 * @see com.ft9.service.IProductService#deleteProductByMap(java.util.Map) <BR>
	 * Method name: deleteProductByMap <BR>
	 * Description: Delete Product By Map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return boolean <BR>
	*/
	@Override
	public boolean deleteProductByMap(Map<String, String> map) {
		if(map==null){
			return false;
		}
		return productDao.deleteProductByMap(map)>0;
	}

	/**
	 * @Override
	 * @see com.ft9.service.IProductService#addProductByBean(com.ft9.bean.ProductBean) <BR>
	 * Method name: addProductByBean <BR>
	 * Description: Add Product By Bean <BR>
	 * Remark: <BR>
	 * @param productBean
	 * @return boolean <BR>
	*/
	@Override
	public boolean addProductByBean(ProductBean productBean) {
		if(productBean==null){
			return false;
		}
		return productDao.insertProductByBean(productBean);
	}

	/**
	 * @Override
	 * @see com.ft9.service.IProductService#updateProductByBean(com.ft9.bean.ProductBean) <BR>
	 * Method name: updateProductByBean <BR>
	 * Description: Update Product By Bean <BR>
	 * Remark: <BR>
	 * @param productBean
	 * @return boolean <BR>
	*/
	@Override
	public boolean updateProductByBean(ProductBean productBean) {
		if(productBean==null){
			return false;
		}
		Map<String,String>map=new HashMap<String,String>();
		map.put("id", productBean.getId());
		return productDao.updateProduct(productBean, map)>0;
		
	}
	/**
	 * @Override
	 * @see com.ft9.service.IProductService#getAllCategory() <BR>
	 * Method name: getAllCategory <BR>
	 * Description: Get All Category <BR>
	 * Remark: <BR>
	 * @return String[] <BR>
	*/
	@Override
	public String[] getAllCategory() {
		List<CategoryBean>categoryList=categoryDao.getCategorysByMap(new HashMap<String,String>());
		List<String>categoryIdList=new ArrayList<String>();
		for(CategoryBean categoryBean:categoryList){
			categoryIdList.add(categoryBean.getCode());
		}
		String[] stringArr=new String[categoryIdList.size()];
		return categoryIdList.toArray(stringArr);
	}
	/**
	 * @Override
	 * @see com.ft9.service.IProductService#getProductsBelowThreshold() <BR>
	 * Method name: getProductsBelowThreshold <BR>
	 * Description: Get Product Below Threshold <BR>
	 * Remark: <BR>
	 * @return List <BR>
	*/
	@Override
	public List<ProductBean> getProductsBelowThreshold() {
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
