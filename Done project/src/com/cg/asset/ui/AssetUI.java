package com.cg.asset.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.asset.dto.Asset;
import com.cg.asset.exception.AssetException;
import com.cg.asset.service.AssetServiceImpl;
import com.cg.asset.service.IAssetService;

public class AssetUI {
	
	

	public static void main(String args[]) throws AssetException
	{
		int choice;

		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		IAssetService service=new AssetServiceImpl();
		Asset bean=new Asset();
		System.out.println("************************************************");
		System.out.println("***********Asset Management System**************");
		System.out.println("************************************************");
		
		do
		{
		System.out.println("Login As\n 1.User  2.Admin  3.Exit");
		choice=sc.nextInt();
		
		
		switch(choice)
		{
		case 1:
			sc.nextLine();
			System.out.println("Enter User Name");
			String userName=sc.nextLine();
			System.out.println("Enter User Password");
			String password=sc.next();
		if(service.checkPassword(password)){
			bean.setUserName(userName);
			bean.setPassword(password);
			int n=service.getUserType("USER",bean);
		if(n==1)
			{
		    String display=service.loginDetails(bean);
		    System.out.println(display);
		    if(display.equals("Login Successfull!!!"))
		    {
		    	
		    	int ch;
				do{
		    		
		    	System.out.println("1: Asset Allocation Request  2.View Status 3.Logout");
		    	System.out.println("***************************************");
		    	 ch = sc.nextInt();
		    	 
		    	 switch(ch)
		    	 {
		    	case 1:
		    	System.out.println("Enter Asset Name");
		    	String assetName=sc.next();
		    	System.out.println("Enter Quantity");
		    	int quantity=sc.nextInt();
		    	sc.nextLine();
		    	System.out.println("Enter Employee Name");
		    	String empName=sc.nextLine();
		    	System.out.println("Enter Your Manager Id");
		    	int mgrId=sc.nextInt();
		    	bean.setMgrId(mgrId);
		    	bean.setAssetName(assetName);
		    	bean.setAllocatedQuantity(quantity);
		    	bean.setEmployeeName(empName);
		    	bean=service.raiseRequest(bean);
		    	
		    	int allocationId=service.insertRequests(bean);
		    	System.out.println("Request Raised For Allocation Request Number: "+allocationId);
		    	break;
		    	
		    	 
		    	 
		 case 2:
			 ArrayList<Asset> list =new ArrayList<Asset>();
		    		 System.out.println("Enter Your Manager Id");
		    		 int retMgrId=sc.nextInt();
		    		
		    		
		    	if(service.doesIdExist(retMgrId))
		    	{ 
		    		list=service.viewRequestsByManager(retMgrId);
		    		int index=1;
		    		 for(Asset requests:list)
		    		 {
		    			 
		    			 System.out.println("Manager Requests No:"+index);
		    			 
		    			 System.out.println("---------------------------");
		    		     System.out.println("Manger Id :"+requests.getMgrId());
		    			 System.out.println("Allocation Id :"+requests.getAllocationId());
		    			 System.out.println("Asset Id :"+requests.getAssetId());
		    			 System.out.println("Employee No :"+requests.getEmpNo());
		    			 System.out.println("Asset Name :"+requests.getAssetName());
		    			 System.out.println("Asset Description :"+requests.getAssetDes());
		    			 System.out.println("Asset Quantity :"+requests.getQuantity());
		    			 System.out.println("Requested Quantity :"+requests.getAllocatedQuantity());
		    			 System.out.println("Status"+requests.getStatus());
		    			System.out.println("---------------------------");
		    			index++;
		    			 
		    		 }
		    	}
		    	else{
		    		System.out.println("Manager Id Does Not Exist");
		    	}
			 	break;
		    	
		    	
		    	
		    	 case 3:
		    		 System.out.println("Logged Out !!");
		    		
		    		 break;
		    		 
		    		 
		    	 default:
					 System.out.println("Invalid choice");
		    	 }
		    	 
		    	
		    }while(ch!=3);
			}
			}
		    else
		    {
		    		 System.out.println("Invalid userName or Password");
		    	 
		    }
		    
		}
		
		else
		{
			System.out.println("Invalid Credentials !!!");
		}
			
		    break;
		    	
		 case 2:
		    		
			 sc.nextLine();
		 	System.out.println("Enter Admin Name");
		 	String userName1=sc.nextLine();
		 	System.out.println("Enter Admin Password");
		 	String password1=sc.next();
		 	if(service.checkPassword(password1)){
		 		bean.setUserName(userName1);
	 			bean.setPassword(password1);
	 			int n1=service.getUserType("ADMIN",bean);
	 	if(n1==1)
	 			{
	 			String display1=service.loginDetails(bean);
			    System.out.println(display1);
			    int choice1;
			    
	 			do{
	 			System.out.println("Admin Area:\n 1.Add Assets 2.Modify Assets 3.View Requests 4.Logout");
	 			choice1=sc.nextInt();
	 			int assetId=0;
	 			int quantity=0;
	 			switch(choice1)
	 			{
	 			
	 			case 1:
	 				System.out.println("Enter Asset Id");
	 			    assetId=sc.nextInt();
	 				System.out.println("Enter Asset Name");
	 				String assetName=sc.next();
	 				System.out.println("Enter Asset Description");
	 				String assetDesc=sc.next();
	 				System.out.println("Enter Quantity");
	 				quantity=sc.nextInt();
	 				
	 			if(service.checkAssetQuantity(quantity)){
	 				bean.setAssetDes(assetDesc);
	 				bean.setAssetId(assetId);
	 				bean.setQuantity(quantity);
	 				bean.setAssetName(assetName);
	 				
	 				int rows=service.addDetails(bean);
	 				if(rows==1)
	 				{
	 					System.out.println("Rows inserted");
	 				}
	 			}
	 			else{
	 				System.out.println("Quantity out of range");
	 			}
	 				break;
	 				
	 			case 2:
	 				
	 				System.out.println("Enter Asset name to be modified");
	 				String assetName1=sc.next();
	 				System.out.println("Enter Asset quanity to be modified ");
	 				int quantity1=sc.nextInt();
	 				int n2=service.modifyAsset(assetName1,quantity1);
	 				System.out.println("Asset Updated");
	 				break;
	 				 
	 			case 3:
	 				ArrayList<Asset> list=new ArrayList<Asset>();
	 				list=service.retrieveDetails();
	 				for(Asset l:list)
	 				{
	 					 System.out.println("Request No :"+l.getAllocationId());
	 					 System.out.println("---------------------------");
	 					 System.out.println("Allocation Id :"+l.getAllocationId());
		    		     System.out.println("Manger Id :"+l.getMgrId());
		    		     System.out.println("Employee No :"+l.getEmpNo());
		    			 System.out.println("Asset Id :"+l.getAssetId());
		    			 System.out.println("Asset Name :"+l.getAssetName());
		    			 System.out.println("Asset Description :"+l.getAssetDes());
		    			 System.out.println("Asset Quantity :"+l.getQuantity());
		    			 System.out.println("Requested Quantity :"+l.getAllocatedQuantity());
		    			 System.out.println("Status"+l.getStatus());
		    			System.out.println("---------------------------");
		    		 }
	 				
	 				System.out.println("1.Approve/Reject Request \n"
	 						          +"2.Back\n");
	 				
	 				int adminChoice=sc.nextInt();
	 				switch(adminChoice)
	 				{
	 				
	 				case 1:
	 					System.out.println("Enter the Allocation Id");
	 					int allocId=sc.nextInt();
	 					System.out.println("1.Approve \n"
	 							         + "2.Reject \n");
	 					int allocChoice=sc.nextInt();
	 					if(allocChoice==1)
	 					{
	 						
	 						int checkQuantity=service.checkAsset(allocId);
	 						
	 						if(checkQuantity>0)
	 						{
	 							int allocated=service.approveRequest(allocId);
	 							
	 							if(allocated==1)
	 							{
	 								String allocStatus="Approved";
	 								System.out.println(allocStatus);
	 								service.setStatus(allocId,allocStatus);
	 								
	 								
	 								
	 							}else{
	 								
	 								System.out.println("Could not approve");
	 								
	 							}
	 						}else{
	 							System.out.println("Asset Quantity not sufficient");
	 						}
	 					
	 					}else{
	 						String rejectStatus="Rejected";
	 						System.out.println(rejectStatus);
	 						service.setStatus(allocId,rejectStatus);
	 					}
	 				
	 				break;
	 			case 2:
	 				System.out.println("Enter Your Choice Here");
	 					
	 				break;
	 			default:
	 				System.out.println("Invalid Choice !!!");
	 				break;
	 				
	 			}
	 				break;
	 			
	 			case 4:
	 				System.out.println("Logged Out!!!");
	 				
	 				
	 				break;
	 			default:
					 System.out.println("Invalid choice");
	 		
	 			}
	 			
	 			}while(choice1!=4);
	    		 
	    		
	    	 }
	 			
	 		else
	 			{
	 				 System.out.println("Invalid userName or Password");
	 			}
		 	}
		 	else
		 		{
		 			System.out.println("Invalid Password");
		 		}
		 	break;
		 case 3: 
			 System.out.println("Thank You !!");
			 break;
			 
			 default:
				 System.out.println("Invalid choice");
		}
		}
		while(choice !=3);
	
	}
	
	

}
