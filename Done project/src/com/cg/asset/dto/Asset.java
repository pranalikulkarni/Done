package com.cg.asset.dto;

import java.util.Date;

public class Asset {


	private int deptId;
	private String userName;
	private String password;
	private int allocationId;
	private int assetId;
	private int empNo;
	private String employeeName;
	private Date allocationDate;
	private Date releaseDate;
	private String assetName;
	private String assetDes;
	private int quantity;
	private int allocatedQuantity;
	private int mgrId;


	
	
	
	
	public Asset(int allocationId, int assetId, int empNo, String assetName, String assetDes, int quantity,int allocatedQuantity,String status,int mgrId) {
		super();
		this.allocationId = allocationId;
		this.assetId = assetId;
		this.empNo = empNo;
	
		this.assetName = assetName;
		this.assetDes = assetDes;
		this.quantity = quantity;
		this.allocatedQuantity=allocatedQuantity;
		this.status=status;
		this.mgrId=mgrId;
	
	}

	public Asset(int assetId, int empNo,int allocatedQuantity) {
		super();

		this.assetId = assetId;
		this.empNo = empNo;
		this.allocatedQuantity=allocatedQuantity;
	}

	
	
	
	
	
	
	
	
	
	public int getMgrId() {
		return mgrId;
	}


	public void setMgrId(int mgrId) {
		this.mgrId = mgrId;
	}


	private String status;
	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getAllocatedQuantity() {
		return allocatedQuantity;
	}


	public void setAllocatedQuantity(int allocatedQuantity) {
		this.allocatedQuantity = allocatedQuantity;
	}




	public int getAllocationId() {
		return allocationId;
	}

	public void setAllocationId(int allocationId) {
		this.allocationId = allocationId;
	}

	public Asset() {
		
	}




	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public Date getAllocationDate() {
		return allocationDate;
	}

	public void setAllocationDate(Date allocationDate) {
		this.allocationDate = allocationDate;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getAssetDes() {
		return assetDes;
	}

	public void setAssetDes(String assetDes) {
		this.assetDes = assetDes;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	

	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	

	@Override
	public String toString() {
		return "Asset [allocationId=" + allocationId + ", assetId=" + assetId
				+ ", empNo=" + empNo + ", allocationDate=" + allocationDate
				+ ", releaseDate=" + releaseDate + ", assetName=" + assetName
				+ ", assetDes=" + assetDes + ", quantity=" + quantity
				+ ", allocatedQuantity=" + allocatedQuantity + ", mgrId="
				+ mgrId + ", status=" + status + "]";
	}
}
