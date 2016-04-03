package unitTest;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
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
 * @author CaiYicheng
 */
public class VendorServiceTest {

	IVendorService vendorService;
	ICategoryService categoryService;

	@Before
	public void setUp() throws Exception {
		DAOer.initDao();
		ServiceManager.init();
		vendorService=(VendorService) ServiceManager.getService("Vendor");
		categoryService=(CategoryService)ServiceManager.getService("Category");
	}


	@Test
	public void test() {
		VendorBean vendorBean=new VendorBean();
		vendorBean.setDescription("A Company");
		vendorBean.setName("Test Vendor");
		List<CategoryBean>allCategoryList=categoryService.getAllCategorys();
		//if the number of category is insufficient,add some;
		if(allCategoryList.size()==0){
			CategoryBean categoryBean=new CategoryBean();
			categoryBean.setCode("TST");
			categoryBean.setName("Test Category");
			categoryService.addCategoryByBean(categoryBean);
		}
		if(allCategoryList.size()==1){
			CategoryBean categoryBean=new CategoryBean();
			categoryBean.setCode("TST2");
			categoryBean.setName("Test Category2");
			categoryService.addCategoryByBean(categoryBean);
		}
		//the new vendor shouldn't be existed
		assertFalse(vendorService.isNameExisted(vendorBean.getName()));
		
		assertTrue(vendorService.addNewVendorInCategoryBeanList(vendorBean, allCategoryList));
		//add all the categories in to the vendor
		List<CategoryBean>selectedCategoryList=vendorService.getAllCategoriesByVendorName(vendorBean.getName());
		assertTrue(allCategoryList.size()==selectedCategoryList.size());
		//check the search function
		VendorBean searchedVendor=vendorService.searchVendorByKey("name", "est Vend").get(0);
		assertEquals(vendorBean.getName(),searchedVendor.getName());
		
		CategoryBean deletedCategoryBean=selectedCategoryList.get(0);
		selectedCategoryList.remove(0);
		//check the update function
		assertTrue(vendorService.updateVendorByCategoryList(vendorBean,selectedCategoryList));
		assertTrue(vendorService.getAllCategoriesByVendorName(vendorBean.getName()).size()==allCategoryList.size()-1);
		
		List<VendorBean>newVendorList=vendorService.getVendorByCategory(deletedCategoryBean.getCode());
		for(VendorBean vendorBeanInList:newVendorList){
			//check the vendor have already been updated
			assertFalse(vendorBeanInList.getName().equals(vendorBean.getName()));
		}
		//check the vendor delete function
		for(CategoryBean categoryBean:selectedCategoryList){
			assertTrue(vendorService.deleteVendorByNameInCategory(vendorBean.getName(), categoryBean.getCode()));
		}
		//check the vendor have already been deleted
		Map<String,String>map=new HashMap<String,String>();
		map.put("name", vendorBean.getName());
		assertFalse(vendorService.deleteVendorByMap(map));
	}

}
