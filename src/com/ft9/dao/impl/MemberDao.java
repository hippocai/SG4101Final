package com.ft9.dao.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.ft9.bean.MemberBean;
import com.ft9.common.FileConst;
import com.ft9.dao.DaoException;
import com.ft9.dao.intl.IMemberDao;

public class MemberDao extends BaseDao implements IMemberDao {
	private MemberDao() throws FileNotFoundException, IOException{
		super(FileConst.getFileNameByBeanName("Member"));
	}
	
	private static MemberDao memberDao=null;
	public static MemberDao getInstance() throws FileNotFoundException, IOException{
		if(memberDao==null){
			memberDao=new MemberDao();
		}
		return memberDao;
	}
	public List<MemberBean>getMembersByMap(Map<String,String>map){
		try {
			return super.<MemberBean>transferObjectList2BeanList(super.getBeanByMap(map));
		} catch (DaoException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean insertMemberByBean(MemberBean memberBean){
		return super.addBean(memberBean);
	}
	
	public int deleteMemberByMap(Map<String,String>map){
		return super.deleteBeanByMap(map);
	}
	
	public int updateMember(MemberBean memberBean,Map<String,String>map){
		return super.updateBeanByMap(memberBean, map);
	}
}
