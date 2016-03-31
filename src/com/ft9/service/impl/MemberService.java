package com.ft9.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ft9.bean.MemberBean;
import com.ft9.dao.DAOer;
import com.ft9.dao.DaoNotExistException;
import com.ft9.dao.impl.DiscountDao;
import com.ft9.dao.impl.MemberDao;
import com.ft9.dao.intl.IDiscountDao;
import com.ft9.dao.intl.IMemberDao;
import com.ft9.service.IMemberService;
import com.ft9.util.BeanUtil;

/**
 * class name:MemberService <BR>
 * class description: Implements of the functions in IMemberService <BR>
 * Remark: <BR>
 * @version 1.00
 * @author Guo Qi
 */

public class MemberService implements IMemberService {
	private IMemberDao memberDao=null;
	private static MemberService memberService=null;
	private MemberService() throws DaoNotExistException{
		memberDao=(MemberDao)DAOer.getDao("Member");
	}
	
	/**
	 * Method name: getInstance <BR>
	 * Description: Get An Instance Of The MemberService <BR>
	 * Remark: <BR>
	 * @return
	 * @throws DaoNotExistException  MemberService<BR>
	 */
	public static MemberService getInstance() throws DaoNotExistException{
		if(memberService == null){
			memberService = new MemberService();
		}
		return memberService;
	}
	@Override
	public List<MemberBean> getMemberByMap(Map<String, String> map){
		if(map != null){
			return memberDao.getMembersByMap(map);
		}
		return null;
	}
	
	@Override
	public List<MemberBean> getAllMemberInfo(){
		return this.getMemberByMap(new HashMap<String, String>());
	}
	
	@Override 
	public List<MemberBean> searchMemberByKey(String key, String valuelike){
		List<MemberBean> memberList = getAllMemberInfo();
		if(valuelike == null || valuelike.equals("")){
			return memberList;
		}
		List<MemberBean> searchResult = new ArrayList<MemberBean>();
		for(MemberBean memberBean : memberList){
			Map<String, String> memberMap = BeanUtil.transBean2Map(memberBean);
			if(memberMap.containsKey(key)){
				if(memberMap.get(key).contains(valuelike)){
					searchResult.add(memberBean);
				}
			}
		}
		return searchResult;
		
	}
	
	@Override
	public int deleteMemberByMap(Map<String, String> map){
		if(map == null){
			return -1;
		}
		return memberDao.deleteMemberByMap(map);
		
	}
	
	@Override
	public boolean deleteMemberByCode(String code){
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", code);
		return this.deleteMemberByMap(map) > 0;
	}

	@Override
	public boolean isCodeExist(String code) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", code);
		return this.getMemberByMap(map).size() > 0;
	}

	@Override
	public boolean addNewMember(MemberBean memberBean) {
		// TODO Auto-generated method stub
		if(memberBean == null){
			return false;
		}
		
		return memberDao.insertMemberByBean(memberBean);
	}

	@Override
	public boolean updateMember(MemberBean memberBean) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", memberBean.getId());
		return memberDao.updateMember(memberBean, map) > 0;
	}
	

}



