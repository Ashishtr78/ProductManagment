package com.infosys.jdbc_prepared_statement_crud.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.infosys.jdbc_prepared_statement_crud.Cnnection.MainConnection;
import com.infosys.jdbc_prepared_statement_crud.Entity.Admin;

public class AdminDao {

	Connection connection = MainConnection.getMainConnection();
	Admin admin=new Admin();
	private final String INSERTADMINQUERY = "insert into admin(id,username,password) values(?,?,?)";
	private final String GETDATAFORVALIDATION="select username,password from admin where id=1";

	public int saveAdminDao(Admin admin)
	{
		try {
			PreparedStatement ps=connection.prepareStatement(INSERTADMINQUERY);
			ps.setInt(1,admin.getId());
			ps.setString(2,admin.getUsername());
			ps.setString(3, admin.getPassword());
			int a=ps.executeUpdate();
			if(a>0)
			return a;
			else
				System.out.println("enter the valid data");
				return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
			
			return 0;
		}
	
	}

	

	public Admin checkForValidationDao(Admin admin)
	{
		List<String> adminDetail=new ArrayList<>();
		String usernamefromdatabase=null;
		String passwordfromdatabase=null;
		try {
			PreparedStatement ps=connection.prepareStatement(GETDATAFORVALIDATION);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
			 usernamefromdatabase=rs.getString("username");
			 passwordfromdatabase=rs.getString("password");
			
			
			}
			//new Admin(usernamefromdatabase, passwordfromdatabase);
			admin.setUsername(usernamefromdatabase);
			admin.setPassword(passwordfromdatabase);
			// System.out.println(username);
//			System.out.println(check);
//			if(username.equals(usernamefromdatabase) && password.equals(passwordfromdatabase) )
//			{
//				
//				return 1;
//			}
//			else
//			{
//				System.out.println("====================");
//				return 0;
//			}
//				
				
//			adminDetail.add(admin.getUsername());
//			adminDetail.add(admin.getPassword());
//			return adminDetail;
			return admin;
					
		} catch (SQLException e) {
			System.out.println("==============");
			e.printStackTrace();
			return null;
		}
	}

	
}
