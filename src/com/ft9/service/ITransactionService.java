package com.ft9.service;

import java.util.List;
import java.util.Map;

import com.ft9.bean.TransactionBean;

/**
 * class name:ITransactionService <BR>
 * class description: The Interfaces of TransactionService <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Guo Qi
 */
public interface ITransactionService {

	/**
	 * Method name: getTransactionByMap <BR>
	 * Description: Get Transaction By Map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  List<TransactionBean><BR>
	 */
	public List<TransactionBean>getTransactionByMap(Map<String,String>map);
	/**
	 * Method name: getAllTransactions <BR>
	 * Description: Get All Transactions <BR>
	 * Remark: <BR>
	 * @return  List<TransactionBean><BR>
	 */
	public List<TransactionBean>getAllTransactions();
	/**
	 * Method name: getTransactionsByTimePeriod <BR>
	 * Description: Get Transactions By Time Period(Selected By User) <BR>
	 * Remark: <BR>
	 * @param startDate
	 * @param endDate
	 * @return  List<TransactionBean><BR>
	 */
	public List<TransactionBean>getTransactionsByTimePeriod(String startDate,String endDate);
	/**
	 * Method name: getMaxTransactionID <BR>
	 * Description: Get The Auto-Generated ID No. <BR>
	 * Remark: <BR>
	 * @return  int<BR>
	 */
	public int getMaxTransactionID();
	/**
	 * Method name: addTransaction <BR>
	 * Description: Add Transaction <BR>
	 * Remark: <BR>
	 * @param transactionBean
	 * @return  boolean<BR>
	 */
	public boolean addTransaction(TransactionBean transactionBean);
	/**
	 * Method name: addTransactionByBeanList <BR>
	 * Description: Add Transaction By Bean Into List <BR>
	 * Remark: <BR>
	 * @param transactionBeanList
	 * @return  int<BR>
	 */
	public int addTransactionByBeanList(List<TransactionBean>transactionBeanList);
	
}
