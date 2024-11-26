package com.infosys.jdbc_prepared_statement_crud.Service;

import java.util.List;

import com.infosys.jdbc_prepared_statement_crud.DAO.AdminDao;
import com.infosys.jdbc_prepared_statement_crud.Entity.Admin;

public class AdminService {
	AdminDao ad=new AdminDao();
	Admin admin=new Admin();
	
	
	
	public int checkForValidationService( String username,String password)
	{
		
	Admin a1=ad.checkForValidationDao(admin);
	
//	System.out.println(check);
	if(username.equals(a1.getUsername()) && password.equals(a1.getPassword()) )
	{
		return 1;
	}
	else
		return 0;
		
	}
 }
