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

import com.ft9.bean.CategoryBean;
import com.ft9.bean.VendorBean;
import com.ft9.dao.DAOer;
import com.ft9.service.ICategoryService;
import com.ft9.service.IVendorService;
import com.ft9.service.ServiceManager;
import com.ft9.service.impl.CategoryService;
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
	ICategoryService categoryService;
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
		categoryService=(CategoryService)ServiceManager.getService("Category");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		VendorBean vendorBean=new VendorBean();
		vendorBean.setDescription("A Company");
		vendorBean.setName("Test Vendor");
		List<CategoryBean>allCategoryList=categoryService.getAllCategorys();
	}

}
