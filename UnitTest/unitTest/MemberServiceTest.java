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

/**
 * class name:MemberServiceTest <BR>
 * class description: Test the functions of MemberService <BR>
 * Remark: <BR>
 * @version 1.00 
 * @author Guo Qi
 */
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
		//add a new member
		memberService.addNewMember(memberBean);
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "E123456");
		List<MemberBean> testBeanList = memberService.getMemberByMap(map);
		//after the new member is added
		//test if the new member is successfully added
		assertTrue(memberService.isCodeExist("E123456"));
		assertNotNull(testBeanList);
		assertTrue(testBeanList.size() == 1);
		assertEquals("100", testBeanList.get(0).getLoyaltyPoint());
		assertEquals("Gary", testBeanList.get(0).getName());
		//modify the member
		memberBean.setName("Guoqi");
		memberService.updateMember(memberBean);
		testBeanList = memberService.getMemberByMap(map);
		//test if the record is successfully modified
		assertEquals("Guoqi", testBeanList.get(0).getName());
		//delete the record
		memberService.deleteMemberByMap(map);
		testBeanList = memberService.getMemberByMap(map);
		//test if the record is successfully deleted
		assertTrue(testBeanList.size() == 0);

	
	}

}
