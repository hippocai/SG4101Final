package com.ft9.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ft9.dao.impl.BaseDao;
import com.ft9.dao.impl.CategoryDao;
import com.ft9.dao.impl.DiscountDao;
import com.ft9.dao.impl.MemberDao;
import com.ft9.dao.impl.ProductDao;
import com.ft9.dao.impl.StoreKeeperDao;
import com.ft9.dao.impl.TransactionDao;
import com.ft9.dao.impl.VendorDao;
/**
 * @author CaiYicheng
 */
public class DAOer {
	private static Logger log = Logger.getLogger(DAOer.class);
	private static Map<String,BaseDao>daoMapper=new HashMap<String,BaseDao>();
	public static BaseDao getDao(String typeName) throws DaoNotExistException{
		if(!typeName.endsWith("Dao")){
			typeName+="Dao";
		}
		if(!daoMapper.containsKey(typeName)){
			throw new DaoNotExistException(typeName);
		}
		return daoMapper.get(typeName);
	}
	public static void initDao() throws FileNotFoundException, IOException{
		log.info("Initialing Dao...");
		daoMapper.put("ProductDao", ProductDao.getInstance());
		daoMapper.put("CategoryDao", CategoryDao.getInstance());
		daoMapper.put("MemberDao", MemberDao.getInstance());
		daoMapper.put("TransactionDao", TransactionDao.getInstance());
		daoMapper.put("DiscountDao", DiscountDao.getInstance());
		daoMapper.put("VendorDao", VendorDao.getInstance());
		daoMapper.put("StoreKeeperDao", StoreKeeperDao.getInstance());
		log.info("Initial Successful");
	}
}
