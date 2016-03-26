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

public class PaymentService implements IPaymentService {

	private static PaymentService paymentService=null;
	private IDiscountService discountService;
	private ITransactionService transService;
	private IProductService productService;
	private IMemberService memberService;
	public static MemberBean nonMember=new MemberBean();
	public static PaymentService getInstance() throws ServiceNotFoundException{
		if(paymentService==null){
			paymentService=new PaymentService();
		}
		return paymentService;
	}
	
	private PaymentService() throws ServiceNotFoundException{
		discountService=(DiscountService)ServiceManager.getService("Discount");
		transService=(TransactionService)ServiceManager.getService("Transaction");
		memberService=(MemberService)ServiceManager.getService("Member");
		productService=(ProductService)ServiceManager.getService("Product");
		nonMember.setId("PUBLIC");
		nonMember.setName("N/A");
		nonMember.setLoyaltyPoint("0");
	}
	@Override
	public boolean isMember(String id) {
		// TODO 自动生成的方法存根
		return getMemberById(id)!=null;
	}

	@Override
	public boolean isNewMember(String id) {
		// TODO 自动生成的方法存根
		
		return isMember(id)&&getMemberById(id).getLoyaltyPoint().equals("-1");
	}

	@Override
	public MemberBean getMemberById(String id) {
		// TODO 自动生成的方法存根
		Map<String,String>map=new HashMap<String,String>();
		map.put("id", id);
		List<MemberBean>memberList=memberService.getMemberByMap(map);
		if(memberList==null||memberList.size()==0){
			return null;
		}
		return memberList.get(0);
	}

	@Override
	public DiscountBean getBestDiscountByMemberBean(MemberBean memberBean) {
		// TODO 自动生成的方法存根
		if(memberBean==null){
			memberBean=nonMember;
		}
		Map<String,String>discountSearchMap=new HashMap<String,String>();
		if(memberBean.getId().equals("PUBLIC")){
			discountSearchMap.put("memberApplicable", "A");
		}else{
		}
		
		List<DiscountBean>availableDiscountList=discountService.getDiscountByMap(discountSearchMap);
		
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
			else if(TimeUtil.isCurrentTimeOutOfLimit(TimeUtil.getTimeUtilByStandardDateFormat(startTime), period+"D")){
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

	@Override
	public ProductBean getProductBeanByBarcode(String barcode) {
		// TODO 自动生成的方法存根
		List<ProductBean>productList=productService.getProductByKey("barCode", barcode);
		if(productList==null||productList.size()==0){
			return null;
		}
		return productList.get(0);
	}

	@Override
	public boolean updateMemberInfo(MemberBean memberBean) {
		// TODO 自动生成的方法存根
		
		return memberService.updateMember(memberBean);
	}

	@Override
	public int addTransactionInfo(List<TransactionBean> transactionInfoBeanList) {
		// TODO 自动生成的方法存根
		
		return transService.addTransactionByBeanList(transactionInfoBeanList);
	}

	@Override
	public int getMaxTransId() {
		// TODO 自动生成的方法存根
		return transService.getMaxTransactionID();
	}

	@Override
	public ProductBean getProductBeanById(String id) {
		// TODO 自动生成的方法存根
		List<ProductBean>productList=productService.getProductByKey("id", id);
		if(productList==null||productList.size()==0){
			return null;
		}
		return productList.get(0);
	}

	@Override
	public boolean updateProduct(ProductBean productBean) {
		// TODO 自动生成的方法存根
		return productService.updateProductByBean(productBean);
	}

}
