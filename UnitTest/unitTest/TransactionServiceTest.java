/*
 * 
 * FileName: TransactionServiceTest.java
 * Version:  $Revision$
 * Modify record:
 * NO. |     Date       |    Name           |      Content
 * 1   | 2016年3月31日        |    caiyicheng     | original version
 */
package unitTest;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.ft9.bean.TransactionBean;
import com.ft9.dao.DAOer;
import com.ft9.dao.impl.TransactionDao;
import com.ft9.dao.intl.ITransactionDao;
import com.ft9.service.ITransactionService;
import com.ft9.service.ServiceManager;
import com.ft9.service.impl.TransactionService;
import com.ft9.util.TimeUtil;

/**
 * class name:TransactionServiceTest <BR>
 * class description: please write your description <BR>
 * Remark: <BR>
 * @version 1.00 2016年3月31日
 * @author caiyicheng
 */
public class TransactionServiceTest {

	/**
	 * Method name: setUp <BR>
	 * Description: setUp <BR>
	 * Remark: <BR>
	 * @throws java.lang.Exception  void<BR>
	 */
	ITransactionService transService;
	ITransactionDao transDao;
	@Before
	public void setUp() throws Exception {
		DAOer.initDao();
		ServiceManager.init();
		transService=(TransactionService)ServiceManager.getService("Transaction");
		transDao=(TransactionDao)DAOer.getDao("Transaction");
	}

	@Test
	public void test() {
		List<TransactionBean>transList=transService.getAllTransactions();
		int maxId=-1;
		for(TransactionBean transBean:transList){
			if(Integer.parseInt(transBean.getId())>maxId){
				maxId=Integer.parseInt(transBean.getId());
			}
		}
		++maxId;
		assertTrue(maxId==transService.getMaxTransactionID());
		TransactionBean transBean=new TransactionBean();
		transBean.setId(transService.getMaxTransactionID()+"");
		transBean.setDate(TimeUtil.GetCurrentTime().toString("Y-M-D"));
		transBean.setMemberId("testMemberId");
		transBean.setProductId("testProductId");
		transBean.setQuantityPurchased("100");
		transService.addTransaction(transBean);
		List<TransactionBean>selectedTransList=transService.getTransactionsByTimePeriod(TimeUtil.GetCurrentTime().toString("Y-M-D"),TimeUtil.GetCurrentTime().toString("Y-M-D"));
		for(TransactionBean transBeanItem:selectedTransList){
			assertTrue(transBeanItem.getDate().equals(TimeUtil.GetCurrentTime().toString("Y-M-D")));
		}
		Map<String,String>map=new HashMap<String,String>();
		map.put("id", transBean.getId()+"");
		transDao.deleteTransactionByMap(map);
	}

}
