/**
 * 
 */
package com.ft9.dao.intl;

import java.util.List;
import java.util.Map;

import com.ft9.bean.MemberBean;

/**
 * @author hippo
 *
 */
public interface IMemberDao {
	public List<MemberBean>getMembersByMap(Map<String,String>map);
	public boolean insertMemberByBean(MemberBean memberBean);
	
	public int deleteMemberByMap(Map<String,String>map);
	
	public int updateMember(MemberBean memberBean,Map<String,String>map);
}
