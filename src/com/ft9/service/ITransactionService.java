package com.ft9.service;

import java.util.List;
import java.util.Map;

import com.ft9.bean.TransactionBean;

public interface ITransactionService {

	public List<TransactionBean>getTransactionByMap(Map<String,String>map);
	public List<TransactionBean>getAllTransactions();
	public List<TransactionBean>getTransactionsByTimePeriod(String startDate,String endDate);
	public int getMaxTransactionID();
	public boolean addTransaction(TransactionBean transactionBean);
	public int addTransactionByBeanList(List<TransactionBean>transactionBeanList);
	
}
