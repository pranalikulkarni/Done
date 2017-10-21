package com.cg.asset.dao;

import java.util.ArrayList;

import com.cg.asset.dto.Asset;
import com.cg.asset.exception.AssetException;

public interface IAssetDao {
	public String loginDetails(Asset b) throws AssetException;
	public int getUserType(String string,Asset b) throws AssetException;
	public int addDetails(Asset b) throws AssetException;
	public int modifyAsset(String assetName1, int quantity1) throws AssetException ;
	public Asset raiseRequest(Asset bean) throws AssetException;
	public int insertRequests(Asset bean) throws AssetException;
	
	public int checkAsset(int assetId) throws AssetException;
	public int approveRequest(int allocationId) throws AssetException;
	public ArrayList<Asset> retrieveDetails() throws AssetException;
	public void setStatus(int allocId,String status) throws AssetException;
	public ArrayList<Asset> viewRequestsByManager(int mgrId) throws AssetException;
	public boolean doesIdExist(int retMgrId) throws AssetException;
	

}
