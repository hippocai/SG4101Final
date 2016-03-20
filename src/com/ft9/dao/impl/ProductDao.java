package com.ft9.dao.impl;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.ft9.bean.ProductBean;
import com.ft9.common.FileConst;
import com.ft9.dao.DaoException;
import com.ft9.dao.intl.IProductDao;


public class ProductDao extends BaseDao implements IProductDao{

	private ProductDao() throws FileNotFoundException, IOException{
		super(FileConst.getFileNameByBeanName("Product"));
	}
	
	private static ProductDao productDao=null;
	public static ProductDao getInstance() throws FileNotFoundException, IOException{
		if(productDao==null){
			productDao=new ProductDao();
		}
		return productDao;
	}
	public List<ProductBean>getProductsByMap(Map<String,String>map){
		try {
			return super.<ProductBean>transferObjectList2BeanList(super.getBeanByMap(map));
		} catch (DaoException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean insertProductByBean(ProductBean productBean){
		return super.addBean(productBean);
	}
	
	public int deleteProductByMap(Map<String,String>map){
		return super.deleteBeanByMap(map);
	}
	
	public int updateProduct(ProductBean productBean,Map<String,String>map){
		return super.updateBeanByMap(productBean, map);
	}
	
/*	  public static void main(String[] s)  {
	    	//FileUtil fileUtil=new FileUtil("Products.dat");
	    	
	    	try {
	    		//fileUtil.creatFile();
	    		ProductDao productDao=new ProductDao();
	    		productDao.getProductsByMap(new HashMap<String,String>());
	    		ProductBean productBean=new ProductBean();
	    		productBean.setBarCode("1001001001");
	    		productBean.setDescription("THIS IS DESCRIPTION");
	    		productBean.setId("ID24");
	    		productBean.setName("THIS IS NAMEsdasdasd");
	    		productBean.setOrderQuantity("123456");
	    		productBean.setPrice("123456");
	    		productBean.setQuantityAvailable("qwdaf");
	    		productBean.setReorderQuantity("asdasds");
	    		productDao.addBean(productBean);
	    		Map<String,String>map=new HashMap<String,String>();
	    		map.put("id", "ID");
	    		map.put("barCode", "1001001001");
	    		List<ProductBean>beans=productDao.getProductsByMap(map);
	    		
	    		for(ProductBean bean:beans){
	    			
	    			System.out.println(BeanUtil.outputBean(bean));
	    		}
	    		System.out.println(productDao.updateProduct(productBean, map));
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}

	    }*/

}
