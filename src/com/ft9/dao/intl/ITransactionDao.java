/**
 * 
 */
package com.ft9.dao.intl;


import java.util.List;
import java.util.Map;
import com.ft9.bean.TransactionBean;

/**
 * class name:ITransactionDao <BR>
 * class description: The interface of transaction dao <BR>
 * Remark: <BR>
 * @version 1.00 2016Äê4ÔÂ2ÈÕ
 * @author caiyicheng
 */
public interface ITransactionDao {
	/**
	 * Method name: getTransactionsByMap <BR>
	 * Description: Get the transaction by search map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  List<TransactionBean><BR>
	 */
	public List<TransactionBean>getTransactionsByMap(Map<String,String>map);
	/**
	 * Method name: insertTransactionByBean <BR>
	 * Description: Insert transaction by bean <BR>
	 * Remark: <BR>
	 * @param transactionBean
	 * @return  boolean<BR>
	 */
	public boolean insertTransactionByBean(TransactionBean transactionBean);
	/**
	 * Method name: deleteTransactionByMap <BR>
	 * Description: Delete transaction by search map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  int<BR>
	 */
	public int deleteTransactionByMap(Map<String,String>map);
	/**
	 * Method name: updateTransaction <BR>
	 * Description: Update transaction by new bean and search map <BR>
	 * Remark: <BR>
	 * @param transactionBean
	 * @param map
	 * @return  int<BR>
	 */
	public int updateTransaction(TransactionBean transactionBean,Map<String,String>map);
}
