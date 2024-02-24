package com.empmanagement;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		EmployeeDataImpl edi = new EmployeeDataImpl();
		
		System.out.println("Welcome to Employee Management Application");
		
		Scanner sc = new Scanner(System.in);
		do {
			 System.out.println("1. Add Employee\n" +
	                    "2. Show All Employee\n" +
	                    "3. Show Employee based on ID \n" +
	                    "4. Update the Employee\n" +
	                    "5. Delete the Employee\n");
			 
			 System.out.println("Enter the choice:");
			 
			 int ch=sc.nextInt();
			 
			 
			 switch(ch) {
			 case 1: 
				 Employee emp = new Employee();
				 System.out.println("Enter ID: ");
				 int id = sc.nextInt();
				 System.out.println("Enter Name: ");
				 String name = sc.next();
				 System.out.println("Enter Salary: ");
				 double salary = sc.nextDouble();
				 System.out.println("Enter Age: ");
				 int age = sc.nextInt();
				 
				 emp.setId(id);
				 emp.setName(name);
				 emp.setSalary(salary);
				 emp.setAge(age);
				 edi.createEmployee(emp);
				break;
				
			 case 2:
				 edi.showAllEmployee();
				 break;
				 
			 case 3:
                 System.out.println("Enter id to show the details:	 ");
                 int empid=sc.nextInt();
                 edi.showEmployeeBasedOnID(empid);
                 break;
				 
			 case 4:
                 System.out.println("Enter id to update the details");
                 int empid1=sc.nextInt();
                 System.out.println("Enter the new name: ");
                  name=sc.next();
                  System.out.println("Enter the new salary: ");
                  salary = sc.nextDouble();
                  System.out.println("Enter the new age: ");
                  age=sc.nextInt();
                 edi.updateEmployee(empid1,name,salary,age);
                 break;
                 
			  case 5:
                  System.out.println("Enter the id to delete: ");
                  id=sc.nextInt();
                  edi.deleteEmployee(id);
                  break;
                 
			 case 6:
				 System.out.println("Thank you using our application!!!");
				 System.exit(0);
				default:
					System.out.println("Enter a valid choice");
					
			 }
		} 
		while(true);
	}

}
