/**
 * 
 */
package com.ft9.dao.intl;


import java.util.List;
import java.util.Map;
import com.ft9.bean.TransactionBean;

/**
 * @author hippo
 *
 */
public interface ITransactionDao {
	public List<TransactionBean>getTransactionsByMap(Map<String,String>map);
	public boolean insertTransactionByBean(TransactionBean transactionBean);
	public int deleteTransactionByMap(Map<String,String>map);
	public int updateTransaction(TransactionBean transactionBean,Map<String,String>map);
}
