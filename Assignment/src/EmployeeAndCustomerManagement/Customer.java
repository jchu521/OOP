package EmployeeAndCustomerManagement;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer extends Person{
	/*
	 * For customers, information such as licence number, age and license expiry date is maintained.
	 */
	private ArrayList<Person> persons = new ArrayList<Person>();
	private String licenceNum;
	private int age;
	private Date licenceExpiryDate;
	//Constructor
	public Customer(int id, String name, String address, String phone, Date birth, String licenceNum ,Date licenceExpiryDate){
		super(id, name,address,phone, birth);
		this.licenceNum = licenceNum;		
		this.setAge(birth);
		this.licenceExpiryDate = licenceExpiryDate;
	}
	
	// TODO Auto-generated method stub

	//setter
	public void setLicenceExpiryDate(Date date){
		this.licenceExpiryDate = date;
	}
	public void setAge(Date birth){
		Calendar g = Calendar.getInstance();
		int currentYear =g.get(g.YEAR);
		g.setTime(birth);
		int birthYear =g.get(g.YEAR);
		this.age = currentYear - birthYear;;

	}

	//View and update information of a selected customer
	@Override
	protected void updatePersonInfo() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		// update new address
		String s;
		System.out.println("Enter new address: ");
		try{
			s = scan.next("[a-zA-Z]+");	
			setAddress(s);
		}catch(InputMismatchException ex){
			System.out.println("Error: Wrong input ");
		}
		//update new telephone number
		System.out.println("Enter new telephone number: ");
		try{
			s = scan.next("[0-9]+");
			setPhone(s);
		}catch(InputMismatchException ex){
			System.out.println("Error: Wrong input ");
		}
		//update new Licence expiry Date
		System.out.println("Enter Licence Expiry Date (yyyy-MM-dd): ");
		s = scan.next(); 	
		try {
			Date date = sdf.parse(s);
			setLicenceExpiryDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	//display customer detail
	protected void viewPersonUnfo() {
		// TODO Auto-generated method stub
		System.out.println("Customer info: ");
		displayPersonInfo();
		System.out.println("Licence Number: " + licenceNum);
		System.out.println("Age: " + age);
		System.out.println("Licence Expiry Date: " + sdf.format(licenceExpiryDate));
		
	}

}
