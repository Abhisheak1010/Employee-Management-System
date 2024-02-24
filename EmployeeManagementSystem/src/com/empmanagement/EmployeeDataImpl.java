package com.empmanagement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class EmployeeDataImpl implements EmployeeDataInterface {
	Connection con;
	
	@Override
	public void createEmployee(Employee emp) {
		 con = DbConnection.createDBConnetion();
		 String query = "insert into employee values(?,?,?,?)";
		 try {
		PreparedStatement pstm = con.prepareStatement(query);
		pstm.setInt(1,emp.getId());
		pstm.setString(2,emp.getName());
		pstm.setDouble(3, emp.getSalary());
		pstm.setInt(4,emp.getAge());
		int count = pstm.executeUpdate();
		if(count!=0) {
			System.out.println("Employee details inserted successfully!!!");
		}
		
	} catch(Exception ex) {
		ex.printStackTrace();	
	    }
	}

	 @Override
	    public void showAllEmployee() {
	        con=DbConnection.createDBConnetion();
	        String query="select * from employee";
	        System.out.println("Employee Details :");
	        
	        System.out.println("---------------------------------------------");
	        System.out.format("%s\t%s\t%s\t\t%s\n","ID","Name","Salary","Age");
	        System.out.println("---------------------------------------------");

	        try{
	            Statement stmt=con.createStatement();
	            ResultSet result= stmt.executeQuery(query);
	            while (result.next()){
	                System.out.format("%d\t%s\t%f\t%d\n",
	                        result.getInt(1),
	                        result.getString(2),
	                        result.getDouble(3),
	                        result.getInt(4));
	                System.out.println("---------------------------------------------");

	            }

	        }catch (Exception ex){
	            ex.printStackTrace();
	        }

	    }
	 @Override
	    public void showEmployeeBasedOnID(int id) {
	        con=DbConnection.createDBConnetion();
	        String query="select * from employee where id="+id;
	        System.out.println("---------------------------------------------");
	        System.out.format("%s\t%s\t%s\t\t%s\n","ID","Name","Salary","Age");
	        System.out.println("---------------------------------------------");
	        
	        try{
	            Statement stmt=con.createStatement();
	           ResultSet result= stmt.executeQuery(query);
	            while (result.next()){
	                System.out.format("%d\t%s\t%f\t%d\n",
	                        result.getInt(1),
	                        result.getString(2),
	                        result.getDouble(3),
	                        result.getInt(4));
	                System.out.println("---------------------------------------------");
	            }

	        }
	        catch (Exception ex){
	            ex.printStackTrace();
	        }

	    }

		  @Override
		    public void updateEmployee(int id, String name, double salary, int age) {
		        con=DbConnection.createDBConnetion();
		        String query="update employee set name=?, salary=?, age=? where id=?";
		        try{
		            PreparedStatement pstm=con.prepareStatement(query);
		            pstm.setString(1,name);
		            pstm.setDouble(2, salary);
		            pstm.setInt(3,age);
		            pstm.setInt(4,id);
		            int cnt=pstm.executeUpdate();
		            if(cnt!=0)
		                System.out.println("Employee Details updated successfully !!");

		        }catch (Exception ex){
		            ex.printStackTrace();
		        }

		    }
		

	@Override
	public void deleteEmployee(int id) {
		 con=DbConnection.createDBConnetion();
	        String query="delete from employee where id=?";
	        try{
	            PreparedStatement pstm=con.prepareStatement(query);
	            pstm.setInt(1,id);
	           int cnt= pstm.executeUpdate();
	           if(cnt!=0)
	               System.out.println("Employee Details Deleted Successfully!!! ");

	        }catch (Exception ex){
	            ex.printStackTrace();
	        }

		
	}
	
}
