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
	
	@Override
	public List<TransactionBean> getTransactionByMap(Map<String, String> map) {
		// TODO 自动生成的方法存根
		if(map==null){
			return null;
		}
		return transDao.getTransactionsByMap(map);
	}

	@Override
	public List<TransactionBean> getAllTransactions() {
		// TODO 自动生成的方法存根
		return this.getTransactionByMap(new HashMap<String,String>());
	}

	@Override
	public List<TransactionBean> getTransactionsByTimePeriod(String startDate,String endDate) {
		// TODO 自动生成的方法存根
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

	@Override
	public boolean addTransaction(TransactionBean transactionBean) {
		// TODO 自动生成的方法存根
		return transDao.insertTransactionByBean(transactionBean);
	}

	@Override
	public int addTransactionByBeanList(List<TransactionBean> transactionBeanList) {
		// TODO 自动生成的方法存根
		if(transactionBeanList==null){
			return 0;
		}
		for(TransactionBean transactionBean : transactionBeanList){
			this.addTransaction(transactionBean);
		}
		return transactionBeanList.size();
	}

}
