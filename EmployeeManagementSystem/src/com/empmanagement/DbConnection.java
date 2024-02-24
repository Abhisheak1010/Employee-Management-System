package com.empmanagement;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	 static Connection con;
	    public static Connection createDBConnetion(){

	        try{
	            //load driver
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	            //get connection
	        	String url = "jdbc:mysql://localhost:3306/employeeDb?useSSL=false&allowPublicKeyRetrieval=true";
	            String username="root";
	            String password="5481";
	           con= DriverManager.getConnection(url,username,password);

	        }catch (Exception ex){
	            ex.printStackTrace();
	        }
	     return con;

	    }
}
