package com.ft9.dao.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.ft9.bean.MemberBean;
import com.ft9.common.FileConst;
import com.ft9.dao.DaoException;
import com.ft9.dao.intl.IMemberDao;

/**
 * class name:MemberDao <BR>
 * class description: The implement of the IMemberDao <BR>
 * Remark: <BR>
 * @version 1.00
 * @author caiyicheng
 */
public class MemberDao extends BaseDao implements IMemberDao {
	
	private static MemberDao memberDao=null;
	/**
	 * Method name: MemberDao<BR>
	 * Description: The constructor of MemberDao<BR>
	 * Remark: <BR>
	 * @throws FileNotFoundException
	 * @throws IOException <BR>
	 */
	private MemberDao() throws FileNotFoundException, IOException{
		super(FileConst.getFileNameByBeanName("Member"));
	}

	/**
	 * Method name: getInstance <BR>
	 * Description: Get instance of MemberDao <BR>
	 * Remark: <BR>
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException  MemberDao<BR>
	 */
	public static MemberDao getInstance() throws FileNotFoundException, IOException{
		if(memberDao==null){
			memberDao=new MemberDao();
		}
		return memberDao;
	}
	/**
	 * @Override
	 * @see com.ft9.dao.intl.IMemberDao#getMembersByMap(java.util.Map) <BR>
	 * Method name: getMembersByMap <BR>
	 * Description: Get member by search map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  <BR>
	*/
	public List<MemberBean>getMembersByMap(Map<String,String>map){
		try {
			return super.<MemberBean>transferObjectList2BeanList(super.getBeanByMap(map));
		} catch (DaoException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @Override
	 * @see com.ft9.dao.intl.IMemberDao#insertMemberByBean(com.ft9.bean.MemberBean) <BR>
	 * Method name: insertMemberByBean <BR>
	 * Description: Insert Member record by bean <BR>
	 * Remark: <BR>
	 * @param memberBean
	 * @return  <BR>
	*/
	public boolean insertMemberByBean(MemberBean memberBean){
		return super.addBean(memberBean);
	}
	
	/**
	 * @Override
	 * @see com.ft9.dao.intl.IMemberDao#deleteMemberByMap(java.util.Map) <BR>
	 * Method name: deleteMemberByMap <BR>
	 * Description: Delete member record by search map <BR>
	 * Remark: <BR>
	 * @param map
	 * @return  <BR>
	*/
	public int deleteMemberByMap(Map<String,String>map){
		return super.deleteBeanByMap(map);
	}
	
	/**
	 * @Override
	 * @see com.ft9.dao.intl.IMemberDao#updateMember(com.ft9.bean.MemberBean, java.util.Map) <BR>
	 * Method name: updateMember <BR>
	 * Description: update member record by new bean and search map <BR>
	 * Remark: <BR>
	 * @param memberBean
	 * @param map
	 * @return  <BR>
	*/
	public int updateMember(MemberBean memberBean,Map<String,String>map){
		return super.updateBeanByMap(memberBean, map);
	}
}
