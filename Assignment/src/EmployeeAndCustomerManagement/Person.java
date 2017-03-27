package EmployeeAndCustomerManagement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//import java.text.SimpleDateFormat;

abstract public class Person {
	/*
	 * Basic information about all persons is person ID, name, date of birth, address, and telephone number.
	 */
	private ArrayList<Person> persons = new ArrayList<Person>();
	private int id;
	private String name,address,phone;
	private Date birth;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

	//constructor 
	public Person(int id, String name, String address, String phone, Date birth){
		this.id = id;
		this.name = name;
		this.birth = birth;
		this.address = address;
		this.phone = phone;
	}
	//Display method 
	protected void displayPersonInfo(){
		
		System.out.println("ID: " + id);
		System.out.println("name: " + name);
		System.out.println("birth: " + sdf.format(birth));
		System.out.println("address: " + address);
		System.out.println("phone: " + phone);
	}
	// update person info
	protected abstract void updatePersonInfo();
	
	protected abstract void viewPersonUnfo();
	public String getName(){
		return name;
	}
	public int getId(){
		return id;
	}
	public Date getBirth(){
		return birth;
	}
	//setter
	public void setAddress(String address){
		this.address = address;
	}
	public void setPhone(String ph){
		this.phone = ph;
	}


}
