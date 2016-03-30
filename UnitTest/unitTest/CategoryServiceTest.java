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
		categoryService.addCategoryByBean(categoryBean);
		Map<String, String>map = new HashMap<String, String>();
		map.put("code", "COO");
		List<CategoryBean> categoryBeanList = categoryService.getCategoryByMap(map);
		assertFalse(categoryService.checkIfCategoryCodeExisted("COO"));
		assertNotNull(categoryBeanList);
		assertTrue(categoryBeanList.size() == 1);
		assertEquals("Cookies", categoryBeanList.get(0).getName());
		categoryService.deleteCategoryByMap(map);
		categoryBeanList = categoryService.getCategoryByMap(map);
		assertTrue(categoryBeanList.size() == 0);
		
	
	}

}
