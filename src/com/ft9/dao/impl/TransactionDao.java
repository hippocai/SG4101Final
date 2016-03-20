package com.ft9.dao.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.ft9.bean.TransactionBean;
import com.ft9.common.FileConst;
import com.ft9.dao.DaoException;
import com.ft9.dao.intl.ITransactionDao;

public class TransactionDao extends BaseDao implements ITransactionDao{
	private TransactionDao() throws FileNotFoundException, IOException{
		super(FileConst.getFileNameByBeanName("Transaction"));
	}
	
	private static TransactionDao transactionDao=null;
	public static TransactionDao getInstance() throws FileNotFoundException, IOException{
		if(transactionDao==null){
			transactionDao=new TransactionDao();
		}
		return transactionDao;
	}
	public List<TransactionBean>getTransactionsByMap(Map<String,String>map){
		try {
			return super.<TransactionBean>transferObjectList2BeanList(super.getBeanByMap(map));
		} catch (DaoException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean insertTransactionByBean(TransactionBean transactionBean){
		return super.addBean(transactionBean);
	}
	
	public int deleteTransactionByMap(Map<String,String>map){
		return super.deleteBeanByMap(map);
	}
	
	public int updateTransaction(TransactionBean transactionBean,Map<String,String>map){
		return super.updateBeanByMap(transactionBean, map);
	}
}
