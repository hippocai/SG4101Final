package unitTest;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.ft9.bean.CategoryBean;
import com.ft9.dao.DAOer;
import com.ft9.service.ICategoryService;
import com.ft9.service.ServiceManager;
import com.ft9.service.impl.CategoryService;

/**
 * class name:CategoryServiceTest <BR>
 * class description: Test the functions in CategoryService <BR>
 * Remark: <BR>
 * @version 1.00 
 * @author Guo Qi
 */
public class CategoryServiceTest {

	ICategoryService categoryService;
	@Before
	public void setUp() throws Exception {
		DAOer.initDao();
		ServiceManager.init();
		categoryService = (CategoryService) ServiceManager.getService("Category");
	}

	@Test
	public void test() {
		CategoryBean categoryBean = new CategoryBean();
		categoryBean.setCode("COO");
		categoryBean.setName("Cookies");
		//add a new category
		categoryService.addCategoryByBean(categoryBean);
		Map<String, String>map = new HashMap<String, String>();
		map.put("code", "COO");
		List<CategoryBean> categoryBeanList = categoryService.getCategoryByMap(map);
		//after the new record is added
		//test if the record is successfully added
		assertFalse(categoryService.checkIfCategoryCodeExisted("COO"));
		assertNotNull(categoryBeanList);
		assertTrue(categoryBeanList.size() == 1);
		assertEquals("Cookies", categoryBeanList.get(0).getName());
		//delete the record
		categoryService.deleteCategoryByMap(map);
		categoryBeanList = categoryService.getCategoryByMap(map);
		//test if the record is successfully deleted
		assertTrue(categoryBeanList.size() == 0);
		
	
	}

}
