package com.ft9.service;

import java.util.List;

import com.ft9.bean.DiscountBean;
import com.ft9.bean.MemberBean;
import com.ft9.bean.ProductBean;
import com.ft9.bean.TransactionBean;

/**
 * class name:IPaymentService <BR>
 * class description: Interfaces of PaymentService <BR>
 * Remark: <BR>
 * @version 1.00 
 * @author Guo Qi
 */
/**
 * class name:IPaymentService <BR>
 * class description: please write your description <BR>
 * Remark: <BR>
 * @version 1.00 2016Äê3ÔÂ31ÈÕ
 * @author Guo Qi
 */
public interface IPaymentService {
	/**
	 * Method name: isMember <BR>
	 * Description: Judge if user is a member <BR>
	 * Remark: <BR>
	 * @param id
	 * @return  boolean<BR>
	 */
	public boolean isMember(String id);
	/**
	 * Method name: isNewMember <BR>
	 * Description: Judge if user is a new member <BR>
	 * Remark: <BR>
	 * @param id
	 * @return  boolean<BR>
	 */
	public boolean isNewMember(String id);
	/**
	 * Method name: getMemberById <BR>
	 * Description: Get Member By Id <BR>
	 * Remark: <BR>
	 * @param id
	 * @return  MemberBean<BR>
	 */
	public MemberBean getMemberById(String id);
	/**
	 * Method name: getBestDiscountByMemberBean <BR>
	 * Description: Get The Most Proper Discount By MemberBean <BR>
	 * Remark: <BR>
	 * @param memberBean
	 * @return  DiscountBean<BR>
	 */
	public DiscountBean getBestDiscountByMemberBean(MemberBean memberBean);
	/**
	 * Method name: getProductBeanByBarcode <BR>
	 * Description: Get ProductBean By Barcode <BR>
	 * Remark: <BR>
	 * @param barcode
	 * @return  ProductBean<BR>
	 */
	public ProductBean getProductBeanByBarcode(String barcode);
	/**
	 * Method name: getProductBeanById <BR>
	 * Description: Get ProductBean By Id <BR>
	 * Remark: <BR>
	 * @param id
	 * @return  ProductBean<BR>
	 */
	public ProductBean getProductBeanById(String id);
	/**
	 * Method name: updateMemberInfo <BR>
	 * Description: Update Member Information <BR>
	 * Remark: <BR>
	 * @param memberBean
	 * @return  boolean<BR>
	 */
	public boolean updateMemberInfo(MemberBean memberBean);
	/**
	 * Method name: addTransactionInfo <BR>
	 * Description: Add Transaction Information <BR>
	 * Remark: <BR>
	 * @param transactionInfoBeanList
	 * @return  int<BR>
	 */
	public int addTransactionInfo(List<TransactionBean>transactionInfoBeanList);
	/**
	 * Method name: getMaxTransId <BR>
	 * Description: Get The Auto-Generated Transaction ID No. <BR>
	 * Remark: <BR>
	 * @return  int<BR>
	 */
	public int getMaxTransId();
	/**
	 * Method name: updateProduct <BR>
	 * Description: Update Product <BR>
	 * Remark: <BR>
	 * @param productBean
	 * @return  boolean<BR>
	 */
	public boolean updateProduct(ProductBean productBean);
}
