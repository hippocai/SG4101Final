package unitTest;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.ft9.bean.DiscountBean;
import com.ft9.dao.DAOer;
import com.ft9.service.IDiscountService;
import com.ft9.service.ServiceManager;
import com.ft9.service.impl.DiscountService;

/**
 * class name:DiscountServiceTest <BR>
 * class description: Test the functions in DiscountSerivice<BR>
 * Remark: <BR>
 * @version 1.00 2016Äê3ÔÂ30ÈÕ
 * @author Guo Qi
 */
public class DiscountServiceTest {
	IDiscountService discountService;
	@Before
	public void setUp() throws Exception {
		DAOer.initDao();
		ServiceManager.init();
		discountService = (DiscountService) ServiceManager.getService("Discount");
	}

	@Test
	public void test() {
		DiscountBean discountBean = new DiscountBean();
		discountBean.setCode("Christmas Discount");
		discountBean.setDescription("Merry Christmas");
		discountBean.setDiscountPercentage("20");
		discountBean.setDiscountPeriod("7");
		discountBean.setMemberApplicable("A");
		discountBean.setStartDate("2016-12-25");
		discountService.addNewDiscount(discountBean);
		Map<String, String> map = new HashMap<String, String>();
		map.put("code", "Christmas Discount");
		List<DiscountBean> discountBeanList = discountService.getDiscountByMap(map);
		assertTrue(discountService.isCodeExist("Christmas Discount"));
		assertNotNull(discountBeanList);
		assertTrue(discountBeanList.size() == 1);
		assertEquals("Merry Christmas", discountBeanList.get(0).getDescription());
		discountBean.setDescription("Christmas!");
		discountService.updateDiscount(discountBean);
		discountBeanList = discountService.getDiscountByMap(map);
		assertEquals("Christmas!", discountBeanList.get(0).getDescription());
		discountService.deleteDiscountByMap(map);
		discountBeanList = discountService.getDiscountByMap(map);
		assertTrue(discountBeanList.size() == 0);
		
	}

}
