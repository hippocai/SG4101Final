package unitTest;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ft9.bean.VendorBean;
import com.ft9.dao.DAOer;
import com.ft9.service.IVendorService;
import com.ft9.service.ServiceManager;
import com.ft9.service.impl.VendorService;

/**
 * class name:VendorServiceTest <BR>
 * class description: Test the functions of VendorService <BR>
 * Remark: <BR>
 * @version 1.00 
 * @author Guo Qi
 */
public class VendorServiceTest {

	IVendorService vendorService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		DAOer.initDao();
		ServiceManager.init();
		vendorService=(VendorService) ServiceManager.getService("Vendor");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		/*
		VendorBean vendorBean=new VendorBean();
		vendorBean.setDescription("test123456");
		vendorBean.setName("testName");
		//add a new vendor
		vendorService.addNewVendor(vendorBean);
		Map<String,String>map=new HashMap<String,String>();
		map.put("name", "testName");
		List<VendorBean> testBeanList=vendorService.getVendorByMap(map);
		//after the new vendor is added
		//test if the new record is successfully added
		assertTrue(vendorService.isCodeExist("testName"));
		assertNotNull(testBeanList);
		assertTrue(testBeanList.size()==1);
		assertEquals("test123456", testBeanList.get(0).getDescription());
		//modify the new record
		vendorBean.setDescription("testModified");
		vendorService.updateVendor(vendorBean);
		testBeanList=vendorService.getVendorByMap(map);
		//test if the record is successfully modified
		assertEquals("testModified", testBeanList.get(0).getDescription());
		//delete the record
		vendorService.deleteVendorByMap(map);
		testBeanList=vendorService.getVendorByMap(map);
		//test if the record is successfully deleted
		assertTrue(testBeanList.size()==0);
		*/
	}

}
