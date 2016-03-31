package unitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.ft9.bean.MemberBean;
import com.ft9.bean.ProductBean;
import com.ft9.bean.TransactionBean;
import com.ft9.dao.DAOer;
import com.ft9.service.IDiscountService;
import com.ft9.service.IMemberService;
import com.ft9.service.IPaymentService;
import com.ft9.service.IProductService;
import com.ft9.service.ITransactionService;
import com.ft9.service.ServiceManager;
import com.ft9.service.impl.DiscountService;
import com.ft9.service.impl.MemberService;
import com.ft9.service.impl.PaymentService;
import com.ft9.service.impl.ProductService;
import com.ft9.service.impl.TransactionService;

public class PaymentServiceTest {

	IPaymentService paymentService;
	IMemberService memberService;
	IProductService productService;
	ITransactionService transService;
	IDiscountService discountService;
	@Before
	public void setUp() throws Exception {
		DAOer.initDao();
		ServiceManager.init();
		paymentService=(PaymentService)ServiceManager.getService("Payment");
		memberService=(MemberService)ServiceManager.getService("Member");
		productService=(ProductService)ServiceManager.getService("Product");
		transService=(TransactionService)ServiceManager.getService("Transaction");
		discountService=(DiscountService)ServiceManager.getService("Discount");
	}

	@Test
	public void test() {
		MemberBean memberBean=new MemberBean();
		String newMemberId="E0000000";
		String newMemberName="Eason"; 
		assertTrue(memberService.isCodeExist(newMemberId)==paymentService.isMember(newMemberId));
		memberBean.setId(newMemberId);
		memberBean.setLoyaltyPoint("-1");
		memberBean.setName(newMemberName);
		memberService.addNewMember(memberBean);
		assertTrue(paymentService.isNewMember(newMemberId));
		assertTrue(paymentService.isMember(newMemberId));
		assertEquals("MEMBER_FIRST", paymentService.getBestDiscountByMemberBean(memberBean).getCode());
		assertEquals(newMemberName, paymentService.getMemberById(newMemberId).getName());
		memberBean.setLoyaltyPoint("10");
		assertTrue(paymentService.updateMemberInfo(memberBean));
		assertEquals("10",paymentService.getMemberById(newMemberId).getLoyaltyPoint());
		memberService.deleteMemberByCode(newMemberId);
		ProductBean productBean=new ProductBean();
		productBean.setId("testProductId");
		productBean.setBarCode("testBarCode");
		productBean.setDescription("TestDesc");
		productBean.setName("testName");
		productBean.setOrderQuantity("100");
		productService.addProductByBean(productBean);
		assertEquals(productBean.getName(), paymentService.getProductBeanById(productBean.getId()).getName());
		assertEquals(productBean.getName(), paymentService.getProductBeanByBarcode(productBean.getBarCode()).getName());
		productBean.setDescription("TestDesc2");
		assertTrue(paymentService.updateProduct(productBean));
		assertEquals(productBean.getDescription(), paymentService.getProductBeanByBarcode(productBean.getBarCode()).getDescription());
		Map<String,String>map=new HashMap<String,String>();
		map.put("name", productBean.getName());
		productService.deleteProductByMap(map);
		int maxTransactionId=transService.getMaxTransactionID();
		assertTrue(maxTransactionId==paymentService.getMaxTransId());
		
		
		
		
		
	}

}
