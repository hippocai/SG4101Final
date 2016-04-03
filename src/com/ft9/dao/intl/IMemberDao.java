/**
 * 
 */
package com.ft9.dao.intl;

import java.util.List;
import java.util.Map;

import com.ft9.bean.MemberBean;


/**
 * class name:IMemberDao <BR>
 * class description: The interface of member dao <BR>
 * Remark: <BR>
 * @version 1.00
 * @author caiyicheng
 */
public interface IMemberDao {
	/**
	 * Method name: getMembersByMap <BR>
	 * Description: get the member by search map<BR>
	 * Remark: <BR>
	 * @param map
	 * @return  List<MemberBean><BR>
	 */
	public List<MemberBean>getMembersByMap(Map<String,String>map);
	/**
	 * Method name: insertMemberByBean <BR>
	 * Description: Insert the member by bean <BR>
	 * Remark: <BR>
	 * @param memberBean
	 * @return  boolean<BR>
	 */
	public boolean insertMemberByBean(MemberBean memberBean);
	
	/**
	 * Method name: deleteMemberByMap <BR>
	 * Description: Delete member by search map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  int<BR>
	 */
	public int deleteMemberByMap(Map<String,String>map);
	
	/**
	 * Method name: updateMember <BR>
	 * Description: Update the member by search bean and map <BR>
	 * Remark: <BR>
	 * @param memberBean
	 * @param map
	 * @return  int<BR>
	 */
	public int updateMember(MemberBean memberBean,Map<String,String>map);
}
