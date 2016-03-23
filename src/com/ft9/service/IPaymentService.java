package com.ft9.service;

import java.util.List;

import com.ft9.bean.DiscountBean;
import com.ft9.bean.MemberBean;
import com.ft9.bean.ProductBean;
import com.ft9.bean.TransactionBean;

public interface IPaymentService {
	public boolean isMember(String id);
	public boolean isNewMember(String id);
	public MemberBean getMemberById(String id);
	public DiscountBean getBestDiscountByMemberBean(MemberBean memberBean);
	public ProductBean getProductBeanByBarcode(String barcode);
	public boolean updateMemberInfo(MemberBean memberBean);
	public int addTransactionInfo(List<TransactionBean>transactionInfoBeanList);
}
