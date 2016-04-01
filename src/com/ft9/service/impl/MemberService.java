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
	 * @return memberService
	 * @throws DaoNotExistException  MemberService<BR>
	 */
	public static MemberService getInstance() throws DaoNotExistException{
		if(memberService == null){
			memberService = new MemberService();
		}
		return memberService;
	}
	/**
	 * @Override
	 * @see com.ft9.service.IMemberService#getMemberByMap(java.util.Map) <BR>
	 * Method name: getMemberByMap <BR>
	 * Description: Get Member By Map, Store Into A List <BR>
	 * Remark: <BR>
	 * @param map
	 * @return List <BR>
	*/
	@Override
	public List<MemberBean> getMemberByMap(Map<String, String> map){
		if(map != null){
			return memberDao.getMembersByMap(map);
		}
		return null;
	}
	
	/**
	 * @Override
	 * @see com.ft9.service.IMemberService#getAllMemberInfo() <BR>
	 * Method name: getAllMemberInfo <BR>
	 * Description: Get All Member Information Into A List <BR>
	 * Remark: <BR>
	 * @return List <BR>
	*/
	@Override
	public List<MemberBean> getAllMemberInfo(){
		return this.getMemberByMap(new HashMap<String, String>());
	}
	
	/**
	 * @Override
	 * @see com.ft9.service.IMemberService#searchMemberByKey(java.lang.String, java.lang.String) <BR>
	 * Method name: searchMemberByKey <BR>
	 * Description: Search Member By Key <BR>
	 * Remark: <BR>
	 * @param key
	 * @param valuelike
	 * @return List <BR>
	*/
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
	
	/**
	 * @Override
	 * @see com.ft9.service.IMemberService#deleteMemberByMap(java.util.Map) <BR>
	 * Method name: deleteMemberByMap <BR>
	 * Description: Delete Member By Map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return int <BR>
	*/
	@Override
	public int deleteMemberByMap(Map<String, String> map){
		if(map == null){
			return -1;
		}
		return memberDao.deleteMemberByMap(map);
		
	}
	
	/**
	 * @Override
	 * @see com.ft9.service.IMemberService#deleteMemberByCode(java.lang.String) <BR>
	 * Method name: deleteMemberByCode <BR>
	 * Description: Delete Member By Key Member ID <BR>
	 * Remark: <BR>
	 * @param code
	 * @return boolean <BR>
	*/
	@Override
	public boolean deleteMemberByCode(String code){
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", code);
		return this.deleteMemberByMap(map) > 0;
	}

	/**
	 * @Override
	 * @see com.ft9.service.IMemberService#isCodeExist(java.lang.String) <BR>
	 * Method name: isCodeExist <BR>
	 * Description: Check If The Member ID Existed <BR>
	 * Remark: <BR>
	 * @param code
	 * @return boolean <BR>
	*/
	@Override
	public boolean isCodeExist(String code) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", code);
		return this.getMemberByMap(map).size() > 0;
	}

	/**
	 * @Override
	 * @see com.ft9.service.IMemberService#addNewMember(com.ft9.bean.MemberBean) <BR>
	 * Method name: addNewMember <BR>
	 * Description: Add New Member <BR>
	 * Remark: <BR>
	 * @param memberBean
	 * @return boolean <BR>
	*/
	@Override
	public boolean addNewMember(MemberBean memberBean) {
		// TODO Auto-generated method stub
		if(memberBean == null){
			return false;
		}
		
		return memberDao.insertMemberByBean(memberBean);
	}

	/**
	 * @Override
	 * @see com.ft9.service.IMemberService#updateMember(com.ft9.bean.MemberBean) <BR>
	 * Method name: updateMember <BR>
	 * Description: Modify Member Infomation <BR>
	 * Remark: <BR>
	 * @param memberBean
	 * @return boolean <BR>
	*/
	@Override
	public boolean updateMember(MemberBean memberBean) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", memberBean.getId());
		return memberDao.updateMember(memberBean, map) > 0;
	}
	

}



