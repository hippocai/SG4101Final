package unitTest;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.ft9.bean.MemberBean;
import com.ft9.dao.DAOer;
import com.ft9.service.IMemberService;
import com.ft9.service.ServiceManager;
import com.ft9.service.impl.MemberService;

public class MemberServiceTest {

	IMemberService memberService;
	@Before
	public void setUp() throws Exception {
		DAOer.initDao();
		ServiceManager.init();
		memberService = (MemberService) ServiceManager.getService("Member");
	}

	@Test
	public void test() {
		MemberBean memberBean = new MemberBean();
		memberBean.setId("E123456");
		memberBean.setLoyaltyPoint("100");
		memberBean.setName("Gary");
		memberService.addNewMember(memberBean);
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "E123456");
		List<MemberBean> testBeanList = memberService.getMemberByMap(map);
		assertTrue(memberService.isCodeExist("E123456"));
		assertNotNull(testBeanList);
		assertTrue(testBeanList.size() == 1);
		assertEquals("100", testBeanList.get(0).getLoyaltyPoint());
		assertEquals("Gary", testBeanList.get(0).getName());
		memberBean.setName("Guoqi");
		memberService.updateMember(memberBean);
		testBeanList = memberService.getMemberByMap(map);
		assertEquals("Guoqi", testBeanList.get(0).getName());
		memberService.deleteMemberByMap(map);
		testBeanList = memberService.getMemberByMap(map);
		assertTrue(testBeanList.size() == 0);

	
	}

}
