package com.ft9.service;

import java.util.List;
import java.util.Map;

import com.ft9.bean.MemberBean;

/**
 * class name:IMemberService <BR>
 * class description: The Interfaces of MemberService <BR>
 * Remark: <BR>
 * @version 1.00 
 * @author Guo Qi
 */
public interface IMemberService {
	/**
	 * Method name: getMemberByMap <BR>
	 * Description: Get Member By Map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  List<MemberBean><BR>
	 */
	public List<MemberBean> getMemberByMap(Map<String,String> map);
	/**
	 * Method name: getAllMemberInfo <BR>
	 * Description: Get All Member Information <BR>
	 * Remark: <BR>
	 * @return  List<MemberBean><BR>
	 */
	public List<MemberBean> getAllMemberInfo();
	/**
	 * Method name: searchMemberByKey <BR>
	 * Description: Search Member By Key <BR>
	 * Remark: <BR>
	 * @param key
	 * @param valuelike
	 * @return  List<MemberBean><BR>
	 */
	public List<MemberBean> searchMemberByKey(String key,String valuelike);
	/**
	 * Method name: deleteMemberByMap <BR>
	 * Description: Delete Member By Map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  int<BR>
	 */
	public int deleteMemberByMap(Map<String,String> map);
	/**
	 * Method name: deleteMemberByCode <BR>
	 * Description: Delete Member By Code <BR>
	 * Remark: <BR>
	 * @param code
	 * @return  boolean<BR>
	 */
	public boolean deleteMemberByCode(String code);
	/**
	 * Method name: isCodeExist <BR>
	 * Description: Check if member id exist <BR>
	 * Remark: <BR>
	 * @param code
	 * @return  boolean<BR>
	 */
	public boolean isCodeExist(String code);
	/**
	 * Method name: addNewMember <BR>
	 * Description: Add New Member <BR>
	 * Remark: <BR>
	 * @param memberBean
	 * @return  boolean<BR>
	 */
	public boolean addNewMember(MemberBean memberBean);
	/**
	 * Method name: updateMember <BR>
	 * Description: Update Member <BR>
	 * Remark: <BR>
	 * @param memberBean
	 * @return  boolean<BR>
	 */
	public boolean updateMember(MemberBean memberBean);
}
