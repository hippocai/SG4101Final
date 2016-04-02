package com.ft9.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ft9.bean.DiscountBean;
import com.ft9.bean.MemberBean;
import com.ft9.bean.ProductBean;
import com.ft9.bean.TransactionBean;
import com.ft9.service.IDiscountService;
import com.ft9.service.IMemberService;
import com.ft9.service.IPaymentService;
import com.ft9.service.IProductService;
import com.ft9.service.ITransactionService;
import com.ft9.service.ServiceManager;
import com.ft9.service.ServiceNotFoundException;
import com.ft9.util.TimeUtil;

/**
 * class name:PaymentService <BR>
 * class description: please write your description <BR>
 * Remark: <BR>
 * @version 1.00 2016Äê4ÔÂ2ÈÕ
 * @author caiyicheng
 */
public class PaymentService implements IPaymentService {

	private static PaymentService paymentService=null;
	private IDiscountService discountService;
	private ITransactionService transService;
	private IProductService productService;
	private IMemberService memberService;
	public static MemberBean nonMember=new MemberBean();
	/**
	 * Method name: getInstance <BR>
	 * Description: Get The Instance Of PaymentService <BR>
	 * Remark: <BR>
	 * @return
	 * @throws ServiceNotFoundException  PaymentService<BR>
	 */
	public static PaymentService getInstance() throws ServiceNotFoundException{
		if(paymentService==null){
			paymentService=new PaymentService();
		}
		return paymentService;
	}
	
	/**
	 * Method name: PaymentService<BR>
	 * Description: Constructor of PaymentService<BR>
	 * Remark: <BR>
	 * @throws ServiceNotFoundException <BR>
	 */
	private PaymentService() throws ServiceNotFoundException{
		discountService=(DiscountService)ServiceManager.getService("Discount");
		transService=(TransactionService)ServiceManager.getService("Transaction");
		memberService=(MemberService)ServiceManager.getService("Member");
		productService=(ProductService)ServiceManager.getService("Product");
		nonMember.setId("PUBLIC");
		nonMember.setName("N/A");
		nonMember.setLoyaltyPoint("0");
	}
	/**
	 * @Override
	 * @see com.ft9.service.IPaymentService#isMember(java.lang.String) <BR>
	 * Method name: isMember <BR>
	 * Description: Check is member by user id <BR>
	 * Remark: <BR>
	 * @param id
	 * @return  <BR>
	*/
	@Override
	public boolean isMember(String id) {
		return getMemberById(id)!=null;
	}

	/**
	 * @Override
	 * @see com.ft9.service.IPaymentService#isNewMember(java.lang.String) <BR>
	 * Method name: isNewMember <BR>
	 * Description: Check is new member by user id <BR>
	 * Remark: <BR>
	 * @param id
	 * @return  <BR>
	*/
	@Override
	public boolean isNewMember(String id) {
		return isMember(id)&&getMemberById(id).getLoyaltyPoint().equals("-1");
	}

	/**
	 * @Override
	 * @see com.ft9.service.IPaymentService#getMemberById(java.lang.String) <BR>
	 * Method name: getMemberById <BR>
	 * Description: Get the member by member id <BR>
	 * Remark: <BR>
	 * @param id
	 * @return  <BR>
	*/
	@Override
	public MemberBean getMemberById(String id) {
		Map<String,String>map=new HashMap<String,String>();
		map.put("id", id);
		List<MemberBean>memberList=memberService.getMemberByMap(map);
		if(memberList==null||memberList.size()==0){
			return null;
		}
		return memberList.get(0);
	}

	/**
	 * @Override
	 * @see com.ft9.service.IPaymentService#getBestDiscountByMemberBean(com.ft9.bean.MemberBean) <BR>
	 * Method name: getBestDiscountByMemberBean <BR>
	 * Description: get the best discount by memberBean <BR>
	 * Remark: <BR>
	 * @param memberBean
	 * @return
	 * @throws NumberFormatException
	 * @throws IllegalArgumentException
	 * @throws Exception  <BR>
	*/
	@Override
	public DiscountBean getBestDiscountByMemberBean(MemberBean memberBean) throws NumberFormatException, IllegalArgumentException, Exception {
		if(memberBean==null){
			memberBean=nonMember;
		}
		Map<String,String>discountSearchMap=new HashMap<String,String>();
		//If the user is not member,find the discount which is applicable for public
		if(memberBean.getId().equals("PUBLIC")){
			discountSearchMap.put("memberApplicable", "A");
		}else{
			//Do Nothing
		}
		
		List<DiscountBean>availableDiscountList=discountService.getDiscountByMap(discountSearchMap);
		
		//if it is new member,find the MEMBER_FIRST discount
		if(!this.isNewMember(memberBean.getId())){
			for(int i=0;i<availableDiscountList.size();++i){
				if(availableDiscountList.get(i).getCode().equals("MEMBER_FIRST")){
					availableDiscountList.remove(i);
					break;
				}
			}
		}
		int maxDiscountRate=-1;
		DiscountBean selectedDiscountBean=null;
		//Find the valid discount
		for(DiscountBean discountBean:availableDiscountList){
			String startTime=discountBean.getStartDate();
			String period=discountBean.getDiscountPeriod();
			if(startTime.equals("ALWAYS")){
				if(Integer.parseInt(discountBean.getDiscountPercentage())>maxDiscountRate){
					selectedDiscountBean=discountBean;
					maxDiscountRate=Integer.parseInt(discountBean.getDiscountPercentage());
					continue;
				}else{
					//DoNothing
				}
			}
			else if(period.equals("ALWAYS")&&TimeUtil.GetCurrentTime().greatThan(TimeUtil.getTimeUtilByStandardDateFormat(discountBean.getDiscountPeriod()))){
				if(Integer.parseInt(discountBean.getDiscountPercentage())>maxDiscountRate){
					selectedDiscountBean=discountBean;
					maxDiscountRate=Integer.parseInt(discountBean.getDiscountPercentage());
					continue;
				}else{
					//DoNothing
				}
			}
			else if(TimeUtil.isCurrentTimeOutOfLimit(TimeUtil.getTimeUtilByStandardDateFormat(startTime), period+"D")||!TimeUtil.checkDateAfter(startTime, TimeUtil.GetCurrentTime().toString("Y-M-D"))){
				continue;
			}else{
				if(Integer.parseInt(discountBean.getDiscountPercentage())>maxDiscountRate){
					selectedDiscountBean=discountBean;
					maxDiscountRate=Integer.parseInt(discountBean.getDiscountPercentage());
					continue;
				}else{
					//DoNothing
				}
			}
		}
		
		return selectedDiscountBean;
	}

	/**
	 * @Override
	 * @see com.ft9.service.IPaymentService#getProductBeanByBarcode(java.lang.String) <BR>
	 * Method name: getProductBeanByBarcode <BR>
	 * Description: Get the product by the product barcode <BR>
	 * Remark: <BR>
	 * @param barcode
	 * @return  <BR>
	*/
	@Override
	public ProductBean getProductBeanByBarcode(String barcode) {
		List<ProductBean>productList=productService.getProductByKey("barCode", barcode);
		if(productList==null||productList.size()==0){
			return null;
		}
		return productList.get(0);
	}

	/**
	 * @Override
	 * @see com.ft9.service.IPaymentService#updateMemberInfo(com.ft9.bean.MemberBean) <BR>
	 * Method name: updateMemberInfo <BR>
	 * Description: update the member info <BR>
	 * Remark: <BR>
	 * @param memberBean
	 * @return  <BR>
	*/
	@Override
	public boolean updateMemberInfo(MemberBean memberBean) {
		return memberService.updateMember(memberBean);
	}

	/**
	 * @Override
	 * @see com.ft9.service.IPaymentService#addTransactionInfo(java.util.List) <BR>
	 * Method name: addTransactionInfo <BR>
	 * Description: Add the transaction info by bean list <BR>
	 * Remark: <BR>
	 * @param transactionInfoBeanList
	 * @return  <BR>
	*/
	@Override
	public int addTransactionInfo(List<TransactionBean> transactionInfoBeanList) {
		return transService.addTransactionByBeanList(transactionInfoBeanList);
	}

	/**
	 * @Override
	 * @see com.ft9.service.IPaymentService#getMaxTransId() <BR>
	 * Method name: getMaxTransId <BR>
	 * Description: To generate a new transaction id <BR>
	 * Remark: Returns the current max transaction id+1<BR>
	 * @return  <BR>
	*/
	@Override
	public int getMaxTransId() {
		return transService.getMaxTransactionID();
	}

	/**
	 * @Override
	 * @see com.ft9.service.IPaymentService#getProductBeanById(java.lang.String) <BR>
	 * Method name: getProductBeanById <BR>
	 * Description: Get the product bean by product id <BR>
	 * Remark: <BR>
	 * @param id
	 * @return  <BR>
	*/
	@Override
	public ProductBean getProductBeanById(String id) {
		List<ProductBean>productList=productService.getProductByKey("id", id);
		if(productList==null||productList.size()==0){
			return null;
		}
		return productList.get(0);
	}

	/**
	 * @Override
	 * @see com.ft9.service.IPaymentService#updateProduct(com.ft9.bean.ProductBean) <BR>
	 * Method name: updateProduct <BR>
	 * Description: update the product by product bean <BR>
	 * Remark: <BR>
	 * @param productBean
	 * @return  <BR>
	*/
	@Override
	public boolean updateProduct(ProductBean productBean) {
		return productService.updateProductByBean(productBean);
	}

}
