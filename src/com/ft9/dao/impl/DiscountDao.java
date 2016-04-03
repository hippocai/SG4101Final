package com.ft9.dao.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.ft9.bean.DiscountBean;
import com.ft9.common.FileConst;
import com.ft9.dao.DaoException;
import com.ft9.dao.intl.IDiscountDao;

/**
 * class name:DiscountDao <BR>
 * class description: The implement of the IDiscountDao <BR>
 * Remark: <BR>
 * @version 1.00
 * @author caiyicheng
 */
public class DiscountDao extends BaseDao implements IDiscountDao {
	private static DiscountDao discountDao=null;
	/**
	 * Method name: DiscountDao<BR>
	 * Description: The constructor of Discount dao<BR>
	 * Remark: <BR>
	 * @throws FileNotFoundException
	 * @throws IOException <BR>
	 */
	private DiscountDao() throws FileNotFoundException, IOException{
		super(FileConst.getFileNameByBeanName("Discount"));
	}
	

	/**
	 * Method name: getInstance <BR>
	 * Description: Get the discount dao instance <BR>
	 * Remark: <BR>
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException  DiscountDao<BR>
	 */
	public static DiscountDao getInstance() throws FileNotFoundException, IOException{
		if(discountDao==null){
			discountDao=new DiscountDao();
		}
		return discountDao;
	}
	
	/**
	 * @Override
	 * @see com.ft9.dao.intl.IDiscountDao#getDiscountsByMap(java.util.Map) <BR>
	 * Method name: getDiscountsByMap <BR>
	 * Description: Get discount by search map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  <BR>
	*/
	public List<DiscountBean>getDiscountsByMap(Map<String,String>map){
		try {
			return super.<DiscountBean>transferObjectList2BeanList(super.getBeanByMap(map));
		} catch (DaoException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @Override
	 * @see com.ft9.dao.intl.IDiscountDao#insertDiscountByBean(com.ft9.bean.DiscountBean) <BR>
	 * Method name: insertDiscountByBean <BR>
	 * Description: Insert discount record by bean <BR>
	 * Remark: <BR>
	 * @param discountBean
	 * @return  <BR>
	*/
	public boolean insertDiscountByBean(DiscountBean discountBean){
		return super.addBean(discountBean);
	}
	
	/**
	 * @Override
	 * @see com.ft9.dao.intl.IDiscountDao#deleteDiscountByMap(java.util.Map) <BR>
	 * Method name: deleteDiscountByMap <BR>
	 * Description: Delete discount record by search map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  <BR>
	*/
	public int deleteDiscountByMap(Map<String,String>map){
		return super.deleteBeanByMap(map);
	}
	
	/**
	 * @Override
	 * @see com.ft9.dao.intl.IDiscountDao#updateDiscount(com.ft9.bean.DiscountBean, java.util.Map) <BR>
	 * Method name: updateDiscount <BR>
	 * Description: Update discount record by search map and new  bean <BR>
	 * Remark: <BR>
	 * @param discountBean
	 * @param map
	 * @return  <BR>
	*/
	public int updateDiscount(DiscountBean discountBean,Map<String,String>map){
		return super.updateBeanByMap(discountBean, map);
	}
}
