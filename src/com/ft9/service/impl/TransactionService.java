package com.ft9.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ft9.bean.TransactionBean;
import com.ft9.dao.DAOer;
import com.ft9.dao.DaoNotExistException;
import com.ft9.dao.impl.TransactionDao;
import com.ft9.dao.intl.ITransactionDao;
import com.ft9.service.ITransactionService;
import com.ft9.util.TimeUtil;

/**
 * class name:TransactionService <BR>
 * class description: Implements Of The Functions In TransactionService <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Guo Qi
 */
public class TransactionService implements ITransactionService {

	private static TransactionService transactionService=null;
	public static TransactionService getInstance() throws DaoNotExistException{
		if(transactionService==null){
			transactionService=new TransactionService();
		}
		return transactionService;
	}
	private ITransactionDao transDao=null;
	private TransactionService() throws DaoNotExistException{
		transDao=(TransactionDao)DAOer.getDao("Transaction");
	}
	
	/**
	 * @Override
	 * @see com.ft9.service.ITransactionService#getTransactionByMap(java.util.Map) <BR>
	 * Method name: getTransactionByMap <BR>
	 * Description: Get Transactions By Map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return List <BR>
	*/
	@Override
	public List<TransactionBean> getTransactionByMap(Map<String, String> map) {
		if(map==null){
			return null;
		}
		return transDao.getTransactionsByMap(map);
	}

	/**
	 * @Override
	 * @see com.ft9.service.ITransactionService#getAllTransactions() <BR>
	 * Method name: getAllTransactions <BR>
	 * Description: Get All Transaction Information <BR>
	 * Remark: <BR>
	 * @return List <BR>
	*/
	@Override
	public List<TransactionBean> getAllTransactions() {
		return this.getTransactionByMap(new HashMap<String,String>());
	}

	/**
	 * @Override
	 * @see com.ft9.service.ITransactionService#getTransactionsByTimePeriod(java.lang.String, java.lang.String) <BR>
	 * Method name: getTransactionsByTimePeriod <BR>
	 * Description: Get Transaction By Time Period Selected By User <BR>
	 * Remark: <BR>
	 * @param startDate
	 * @param endDate
	 * @return List <BR>
	*/
	@Override
	public List<TransactionBean> getTransactionsByTimePeriod(String startDate,String endDate) {
		List<TransactionBean>selectedBeanList=new ArrayList<TransactionBean>();
		List<TransactionBean>allBeanList=this.getAllTransactions();
		if((startDate==null||startDate.equals(""))&&(endDate==null||endDate.equals(""))){
			return allBeanList;
		}
		for(TransactionBean transactionBean:allBeanList){
			String checkDate=transactionBean.getDate();
			if(startDate==null||startDate.equals("")){
				if(TimeUtil.checkDateBefore(endDate, checkDate)){
					selectedBeanList.add(transactionBean);
				}else{
					//DoNoting
				}
			}else if(endDate==null||endDate.equals("")){
				if(TimeUtil.checkDateAfter(startDate, checkDate)){
					selectedBeanList.add(transactionBean);
				}else{
					//DoNothing
				}
			}else{
				if(TimeUtil.checkDateInPeriod(startDate, endDate, checkDate)){
					selectedBeanList.add(transactionBean);
				}
			}
		}
		
		return selectedBeanList;
	}

	/**
	 * @Override
	 * @see com.ft9.service.ITransactionService#addTransaction(com.ft9.bean.TransactionBean) <BR>
	 * Method name: addTransaction <BR>
	 * Description: Add New Transaction <BR>
	 * Remark: <BR>
	 * @param transactionBean
	 * @return boolean <BR>
	*/
	@Override
	public boolean addTransaction(TransactionBean transactionBean) {
		return transDao.insertTransactionByBean(transactionBean);
	}

	/**
	 * @Override
	 * @see com.ft9.service.ITransactionService#addTransactionByBeanList(java.util.List) <BR>
	 * Method name: addTransactionByBeanList <BR>
	 * Description: Add Transaction By BeanList <BR>
	 * Remark: <BR>
	 * @param transactionBeanList
	 * @return int <BR>
	*/
	@Override
	public int addTransactionByBeanList(List<TransactionBean> transactionBeanList) {
		if(transactionBeanList==null){
			return 0;
		}
		for(TransactionBean transactionBean : transactionBeanList){
			this.addTransaction(transactionBean);
		}
		return transactionBeanList.size();
	}

	/**
	 * @Override
	 * @see com.ft9.service.ITransactionService#getMaxTransactionID() <BR>
	 * Method name: getMaxTransactionID <BR>
	 * Description: Get Auto-Increased TransactionID <BR>
	 * Remark: <BR>
	 * @return int <BR>
	*/
	@Override
	public int getMaxTransactionID() {
		List<TransactionBean>transList=this.getAllTransactions();
		int maxId=-1;
		for(TransactionBean transBean:transList){
			if(Integer.parseInt(transBean.getId())>maxId){
				maxId=Integer.parseInt(transBean.getId());
			}
		}
		return maxId+1;
	}

}
