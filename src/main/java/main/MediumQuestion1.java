package main;

import java.util.Scanner;

abstract class Customer {

	private String name, address, mobileNumber;

	private Integer age;

Customer(String name, String address, Integer age, String mobile) {

	this.name = name;
	this.address = address;
	this.age = age;
	this.mobileNumber = mobile;

}

public String toString() {
	return "Name: " + this.name+"\n"+"Mobile: "+this.mobileNumber+"\n"+"Age: " + this.age+"\n"+"Address: "+ this.address;
}
abstract Double getBillAmount(Double amt);

}

class SeniorCitizenCustomer extends Customer {

	SeniorCitizenCustomer(String name, String address, Integer age, String mobile) {
		super(name, address, age, mobile);
	}
	
	Double getBillAmount(Double amount) {
		Double bill =null; 
		
		System.out.print("Your bill amount is Rs." +amount);
		double bal=0.12*amount;
		bill=amount-bal;
		System.out.println(bill);
		return bill;
		
	}

}

class PrivilegeCustomer extends Customer {
	PrivilegeCustomer(String name, String address, Integer age, String mobile) {
			super(name, address, age, mobile);
		}
		Double getBillAmount(Double amount) {
			Double bill = null; //edit as per the Question 
			//write your code here if required.
			System.out.print("Your bill amount is Rs." +amount);
			double bal= 0.3*amount;
			bill=amount-bal;
			return bill;
		}
}

public class MediumQuestion1 {
	static Scanner in = new Scanner(System.in);
	static String name, address, phn;
	static Integer age;
	static Double purchasedAmt;
	public static void main(String[] args) {
		
		System.out.print("1)Privilege Customer" + "\n" + "2)Senior Citizen \n");
		System.out.println("Enter Customer Type: ");
		int select = in.nextInt();
		switch (select) {
			case 1:
			
				takeInput();
				
				Customer cust = new PrivilegeCustomer(name, address, age, phn);
				//Double billAmt = cust.getBillAmount(purchasedAmt);
				System.out.println("Bill details");
				
				System.out.println(cust.toString());
				double a= cust.getBillAmount(purchasedAmt);
				System.out.println(" Congrats! As you are a Privileged customer, you are eligible for a discount!");
				System.out.println("You have to pay Rs "+a);
				
				break;
			case 2:
				takeInput();
				Customer cust1 = new SeniorCitizenCustomer(name, address, age, phn);
				
				System.out.println("Bill details");
				
				System.out.println(cust1.toString());
				double a1= cust1.getBillAmount(purchasedAmt);
				System.out.println(" Congrats! As you are a senior citizen, you are eligible for a discount!");
				System.out.println("You have to pay Rs "+a1);
				break;
				
			default:
				System.out.println("Invalid Customer Type");
				break;
			}
}

public static void takeInput() {

		System.out.println("Enter the name: ");
		
		in.nextLine();
		
		name = in.nextLine();
		
		System.out.println("Enter the age: ");
		
		age = in.nextInt();
		
		System.out.println("Enter the address: ");
		
		in.nextLine();
		
		address = in.nextLine();
		
		System.out.println("Enter the mobile number: ");
		
		phn = in.nextLine();
		
		System.out.println("Enter the purchased amount: ");
		
		purchasedAmt = in.nextDouble();

	}

}