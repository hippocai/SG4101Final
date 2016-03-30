package unitTest;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.ft9.bean.ProductBean;
import com.ft9.dao.DAOer;
import com.ft9.service.IProductService;
import com.ft9.service.ServiceManager;
import com.ft9.service.impl.ProductService;

public class ProductServiceTest {
	IProductService productService;
	@Before
	public void setUp() throws Exception {
		DAOer.initDao();
		ServiceManager.init();
		productService = (ProductService) ServiceManager.getService("Product");
	}

	@Test
	public void test() {
		ProductBean productBean = new ProductBean();
		productBean.setBarCode("123456");
		productBean.setDescription("A Really Nice Notebook");
		productBean.setId("STA/3");
		productBean.setName("NUS Notebook");
		productBean.setOrderQuantity("20");
		productBean.setPrice("5");
		productBean.setQuantityAvailable("100");
		productBean.setReorderQuantity("50");
		productService.addProductByByBean(productBean);
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "STA/3");
		List<ProductBean> productBeanList = productService.getProductByMap(map);
		assertTrue(productBeanList.size() == 1);
		assertNotNull(productBeanList);
		assertTrue(productService.getMaxProductNumerOfCategory("STA") == 4);
		assertEquals("123456", productBeanList.get(0).getBarCode());
		productBean.setName("Chinese Notebook");
		productService.updateProductByBean(productBean);
		productBeanList = productService.getProductByMap(map);
		assertEquals("Chinese Notebook", productBeanList.get(0).getName());
		productService.deleteProductByMap(map);
		productBeanList = productService.getProductByMap(map);
		assertTrue(productBeanList.size() == 0);
		
		
	}

}
