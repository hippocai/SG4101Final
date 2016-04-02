package com.ft9.dao.impl;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.ft9.bean.ProductBean;
import com.ft9.common.FileConst;
import com.ft9.dao.DaoException;
import com.ft9.dao.intl.IProductDao;


/**
 * class name:ProductDao <BR>
 * class description: The implement of productdao <BR>
 * Remark: <BR>
 * @version 1.00 2016Äê4ÔÂ2ÈÕ
 * @author caiyicheng
 */
public class ProductDao extends BaseDao implements IProductDao{

	private static ProductDao productDao=null;
	/**
	 * Method name: ProductDao<BR>
	 * Description: The constructor of productdao<BR>
	 * Remark: <BR>
	 * @throws FileNotFoundException
	 * @throws IOException <BR>
	 */
	private ProductDao() throws FileNotFoundException, IOException{
		super(FileConst.getFileNameByBeanName("Product"));
	}
	
	/**
	 * Method name: getInstance <BR>
	 * Description: Get the instance of product dao <BR>
	 * Remark: <BR>
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException  ProductDao<BR>
	 */
	public static ProductDao getInstance() throws FileNotFoundException, IOException{
		if(productDao==null){
			productDao=new ProductDao();
		}
		return productDao;
	}
	/**
	 * @Override
	 * @see com.ft9.dao.intl.IProductDao#getProductsByMap(java.util.Map) <BR>
	 * Method name: getProductsByMap <BR>
	 * Description:Get product by search map<BR>
	 * Remark: <BR>
	 * @param map
	 * @return  <BR>
	*/
	public List<ProductBean>getProductsByMap(Map<String,String>map){
		try {
			return super.<ProductBean>transferObjectList2BeanList(super.getBeanByMap(map));
		} catch (DaoException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @Override
	 * @see com.ft9.dao.intl.IProductDao#insertProductByBean(com.ft9.bean.ProductBean) <BR>
	 * Method name: insertProductByBean <BR>
	 * Description: Insert Product Record by bean <BR>
	 * Remark: <BR>
	 * @param productBean
	 * @return  <BR>
	*/
	public boolean insertProductByBean(ProductBean productBean){
		return super.addBean(productBean);
	}
	
	/**
	 * @Override
	 * @see com.ft9.dao.intl.IProductDao#deleteProductByMap(java.util.Map) <BR>
	 * Method name: deleteProductByMap <BR>
	 * Description: Delete product record by map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  <BR>
	*/
	public int deleteProductByMap(Map<String,String>map){
		return super.deleteBeanByMap(map);
	}
	
	/**
	 * @Override
	 * @see com.ft9.dao.intl.IProductDao#updateProduct(com.ft9.bean.ProductBean, java.util.Map) <BR>
	 * Method name: updateProduct <BR>
	 * Description: Update product record by bean and search map <BR>
	 * Remark: <BR>
	 * @param productBean
	 * @param map
	 * @return  <BR>
	*/
	public int updateProduct(ProductBean productBean,Map<String,String>map){
		return super.updateBeanByMap(productBean, map);
	}

}
