package com.ft9.dao.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.ft9.bean.TransactionBean;
import com.ft9.common.FileConst;
import com.ft9.dao.DaoException;
import com.ft9.dao.intl.ITransactionDao;

/**
 * class name:TransactionDao <BR>
 * class description: The implement of the ITransactionDao <BR>
 * Remark: <BR>
 * @version 1.00
 * @author caiyicheng
 */
public class TransactionDao extends BaseDao implements ITransactionDao{
	private static TransactionDao transactionDao=null;
	/**
	 * Method name: TransactionDao<BR>
	 * Description: The Constructor of transaction dao<BR>
	 * Remark: <BR>
	 * @throws FileNotFoundException
	 * @throws IOException <BR>
	 */
	private TransactionDao() throws FileNotFoundException, IOException{
		super(FileConst.getFileNameByBeanName("Transaction"));
	}
	
	/**
	 * Method name: getInstance <BR>
	 * Description: Get the instance of the Transaction service <BR>
	 * Remark: <BR>
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException  TransactionDao<BR>
	 */
	public static TransactionDao getInstance() throws FileNotFoundException, IOException{
		if(transactionDao==null){
			transactionDao=new TransactionDao();
		}
		return transactionDao;
	}
	/**
	 * @Override
	 * @see com.ft9.dao.intl.ITransactionDao#getTransactionsByMap(java.util.Map) <BR>
	 * Method name: getTransactionsByMap <BR>
	 * Description: Get the transaction by search map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  <BR>
	*/
	public List<TransactionBean>getTransactionsByMap(Map<String,String>map){
		try {
			return super.<TransactionBean>transferObjectList2BeanList(super.getBeanByMap(map));
		} catch (DaoException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @Override
	 * @see com.ft9.dao.intl.ITransactionDao#insertTransactionByBean(com.ft9.bean.TransactionBean) <BR>
	 * Method name: insertTransactionByBean <BR>
	 * Description: Insert the transaction record by bean <BR>
	 * Remark: <BR>
	 * @param transactionBean
	 * @return  <BR>
	*/
	public boolean insertTransactionByBean(TransactionBean transactionBean){
		return super.addBean(transactionBean);
	}
	
	/**
	 * @Override
	 * @see com.ft9.dao.intl.ITransactionDao#deleteTransactionByMap(java.util.Map) <BR>
	 * Method name: deleteTransactionByMap <BR>
	 * Description: Delete transaction record by search map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  <BR>
	*/
	public int deleteTransactionByMap(Map<String,String>map){
		return super.deleteBeanByMap(map);
	}
	
	/**
	 * @Override
	 * @see com.ft9.dao.intl.ITransactionDao#updateTransaction(com.ft9.bean.TransactionBean, java.util.Map) <BR>
	 * Method name: updateTransaction <BR>
	 * Description: Update transaction record by new bean and search map <BR>
	 * Remark: <BR>
	 * @param transactionBean
	 * @param map
	 * @return  <BR>
	*/
	public int updateTransaction(TransactionBean transactionBean,Map<String,String>map){
		return super.updateBeanByMap(transactionBean, map);
	}
}
