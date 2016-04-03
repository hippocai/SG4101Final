/*
 * 
 * FileName: StoreKeeperServiceTest.java
 * Version:  $Revision$
 * Modify record:
 * NO. |     Date       |    Name           |      Content
 * 1   | 2016年3月31日        |    caiyicheng     | original version
 */
package unitTest;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.junit.Before;
import org.junit.Test;

import com.ft9.bean.StoreKeeperBean;
import com.ft9.common.Key;
import com.ft9.dao.DAOer;
import com.ft9.service.IStoreKeeperService;
import com.ft9.service.ServiceManager;
import com.ft9.service.impl.StoreKeeperService;
import com.ft9.util.QEncodeUtil;

/**
 * class name:StoreKeeperServiceTest <BR>
 * class description: please write your description <BR>
 * Remark: <BR>
 * @version 1.00 2016年3月31日
 * @author caiyicheng
 */
public class StoreKeeperServiceTest {

	/**
	 * Method name: setUp <BR>
	 * Description: setUp <BR>
	 * Remark: <BR>
	 * @throws java.lang.Exception  void<BR>
	 */
	IStoreKeeperService storeKeeperService;
	@Before
	public void setUp() throws Exception {
		DAOer.initDao();
		ServiceManager.init();
		storeKeeperService=(StoreKeeperService)ServiceManager.getService("StoreKeeper");
	}

	@Test
	public void test() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		String userName="TestNewUser";
		String password="TestPassword";
		assertFalse(storeKeeperService.isUserNameExisted(userName));
		assertTrue(storeKeeperService.addStoreKeeper(userName, password));
		assertTrue(storeKeeperService.isUserNameExisted(userName));
		assertTrue(storeKeeperService.userLogin(userName, password));
		String newPassword="NewTestPassword";
		assertTrue(storeKeeperService.updatePassword(userName, password, newPassword));
		assertTrue(storeKeeperService.userLogin(userName, newPassword));
		Map<String,String>map=new HashMap<String,String>();
		map.put("name", userName);
		List<StoreKeeperBean>selectedStoreKeeperList=storeKeeperService.getStoreKeeperByMap(map);
		assertTrue(selectedStoreKeeperList.size()==1);
		String encryptedPwd=selectedStoreKeeperList.get(0).getPassword();
		assertEquals(newPassword, QEncodeUtil.decrypt(encryptedPwd, Key.DECODE_KEY));
		assertTrue(storeKeeperService.deleteUserByName(userName));
		
		
	}

}
