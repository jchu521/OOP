package RentalManagement;

import java.text.SimpleDateFormat;
import java.util.Date;

import EmployeeAndCustomerManagement.Customer;
import StockManagement.Guitar;

public class Rental {
	private Date rentDate,returnDueDate,returnDate;
	private Customer cust;
	private Guitar guitar;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	//constructor
	public Rental(Customer cust, Guitar guitar, Date rentDate, Date returnDueDate){
		this.cust = cust;
		this.guitar = guitar;
		this.rentDate = rentDate;
		this.returnDate = null;
		this.returnDueDate = returnDueDate;
	}
	//getter
	public Guitar getGuitar(){
		return guitar;
	}
	public Customer getCustomer(){
		return cust;
	}
	public Date getRentDate(){
		return rentDate;
	}
	public Date getReturnDueDate(){
		return returnDueDate;
	}
	public Date getReturnDate(){
		return returnDate;
	}
	//setter
	public void setReturnDate(Date returnDate){
		this.returnDate = returnDate;
	}
	public void setRentDate(Date rentDate){
		this.rentDate = rentDate;
	}
	public void setReturnDueDate(Date returnDueDate){
		this.returnDueDate = returnDueDate;
	}
	//display
	public void display(){
		System.out.println("Guitar: " + guitar.getSerialNumber());
		System.out.println("Rent Date: " + sdf.format(rentDate));
		System.out.println("Return Due Date: " + sdf.format(returnDueDate));
	}

}
