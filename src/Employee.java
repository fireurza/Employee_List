import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Employee {
	   private int identification;
	   private String eName;

	   public Employee(int ident, String empName) {
	       identification = ident;
	       eName = empName;
	   }
	   public int getID() {
	       return identification;
	   }
	   public void setID(int iD) {
	       identification = iD;
	   }
	   public String getName() {
	       return eName;
	   }
	   public void setName(String name) {
	       eName = name;
	   }


	   static void printEmployees(ArrayList<Employee> records){
	       System.out.println("\nID Number   Name");
	       for(Employee record : records) {
	           System.out.println("   " + record.getID() + "\t     " + record.getName());  
	       }
	   }


	   public static void main(String[] args) {
	       Scanner scanID = new Scanner(System.in);
	       Scanner scanName = new Scanner(System.in);
	       ArrayList<Employee> employees = new ArrayList<Employee>();
	       int id;
	       String inID;
	       String name;
	       
	       for(int i=0;i<4;i++){
	           System.out.print("Enter ID: ");
	           inID = scanID.nextLine();
	           while (true) {
	        	   if (inID.matches("[0-9]+")) {
	        		   id = Integer.parseInt(inID);
	        		   break;	        		   
	        	   } else {
	        		   System.out.print("Re-enter the empoyee id without any letters: ");
	        		   inID = scanID.nextLine();
	        	   }
	           }
    		   
	           
	           System.out.print("Enter Name: ");
	           name = scanName.nextLine();
	           while (true) {
	        	   if ((name.matches(".*\\d.*"))) {
	        		   System.out.print("Re-enter employee name without any numbers: ");
	        		   name = scanName.nextLine();
	        	   } else {
	        		   break;
	        	   }	        	         	   
	           }
	           
	           Employee employee = new Employee(id, name);
	           employees.add(employee);
	       }
	       
	       scanID.close();
	       scanName.close();
	       
	       System.out.println("\nEmployees sorted by ID");
	       Collections.sort(employees, new Comparator<Employee>() {
	           @Override
	           public int compare(Employee o1, Employee o2) {
	               if(o1.getID()>o2.getID()){
	                   return 1;
	               }else if(o1.getID()<o2.getID()){
	                   return -1;
	               }else{
	                   return 0;
	               }
	           }
	       });
	       
	       printEmployees(employees);
	      
	      
	       System.out.println("\nEmployees sorted by NAME");
	       Collections.sort(employees, new Comparator<Employee>() {
	           @Override
	           public int compare(Employee o1, Employee o2) {
	               if(o1.getName().compareTo(o2.getName())>0){
	                   return 1;
	               }else if(o1.getName().compareTo(o2.getName())<0){
	                   return -1;
	               }else{
	                   return 0;
	               }
	           }
	       });
	       	       
	       printEmployees(employees);
	      
	      
	   }

	}