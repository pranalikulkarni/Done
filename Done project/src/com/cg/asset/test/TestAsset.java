package com.cg.asset.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.asset.dao.AssetDaoImpl;
import com.cg.asset.dao.IAssetDao;
import com.cg.asset.dto.Asset;
import com.cg.asset.exception.AssetException;



public class TestAsset {
	
	static IAssetDao dao=null;
	static Asset bean=null;
	
	@BeforeClass
	public static void initialize() {
		System.out.println("Login successfully");
		dao= new AssetDaoImpl();
		bean= new Asset();
	}

	
	@Test
	public void getUserType() throws AssetException {
		assertNotNull(dao.getUserType("SNEHAL BAGADE",bean));
	}
	
	@Test
	public void loginDetails() throws AssetException
	{

		assertNotNull(dao.loginDetails(bean));
	}
	
	@Test
	public void viewRequestsByManager() throws AssetException
	{

		assertNotNull(dao.viewRequestsByManager(123));	
	}

	@Test
	public void testData()
	{
		bean.setUserName("SHWETA TRIPATHI");
		bean.setPassword("CORP");
		bean.setMgrId(12);
    	bean.setAssetName("LAPTOP");
    	bean.setAllocatedQuantity(4);
    	bean.setEmployeeName("ROHIT");
    	bean.setAssetDes("HARDWARE");
		bean.setAssetId(1);
		bean.setQuantity(8);
	}
	
	
	@Test
	public void modifyAsset() throws AssetException {
		assertNotNull(dao.modifyAsset("LAPTOP",5));
		
		
	}
	
	 @Test
	 public void checkAsset() throws AssetException
	    {

			assertNotNull(dao.checkAsset(34));

	    }
	 @Test
	 public void approveRequest() throws AssetException
		{
			assertNotNull(dao.approveRequest(34));
			
	    }
		
	 @Test
		public void getDetails() throws AssetException
		{
			assertNotNull(dao.retrieveDetails());
		}
}
	
	


