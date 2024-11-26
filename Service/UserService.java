package com.infosys.jdbc_prepared_statement_crud.Service;

import com.infosys.jdbc_prepared_statement_crud.DAO.UserDao;
import com.infosys.jdbc_prepared_statement_crud.Entity.User;

public class UserService {
	UserDao ud=new UserDao();
	User user=new User();
	public int  checkUserValidationService(String email, String password) {
		
		
      int uv=ud.checkUserValidationDao(user,email,password); 
		if(uv==1)
			return 1;
		else
			return 0;
		
	}

	
	
	
}
