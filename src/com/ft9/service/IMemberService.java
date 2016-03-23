package com.ft9.service;

import java.util.List;
import java.util.Map;

import com.ft9.bean.MemberBean;

public interface IMemberService {
	public List<MemberBean> getMemberByMap(Map<String,String> map);
	public List<MemberBean> getAllMemberInfo();
	public List<MemberBean> searchMemberByKey(String key,String valuelike);
	public int deleteMemberByMap(Map<String,String> map);
	public boolean deleteMemberByCode(String code);
	public boolean isCodeExist(String code);
	public boolean addNewMember(MemberBean memberBean);
	public boolean updateMember(MemberBean memberBean);
}
