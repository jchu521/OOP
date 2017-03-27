package StockManagement;

import java.text.SimpleDateFormat;
import java.util.Date;

import RentalManagement.Rental;

public class Guitar {
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	private int year;
	private double price, rent;
	private String serialNumber, model, colour;
	//status (in store or rent)
	private boolean inStore;
	private Type type;
	private Builder builder;
	private Wood backWood, topWood;
	
	//Constructor 
	public Guitar(String serialNumber, double price, Builder builder,String model, Type type, Wood backWood, 
			Wood topWood, int year, double rent, String colour ){
		this.serialNumber =serialNumber;
		this.price = price;
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.backWood = backWood;
		this.topWood = topWood;
		this.year = year;
		this.rent = rent;
		this.colour = colour;
		this.inStore = true;
	}
	// getter
	public String getSerialNumber(){
		return serialNumber;
	}
	public double getPrice(){
		return price;
	}
	public Builder getBuilder(){
		return builder;
	}
	public String getModel(){
		return model;
	}
	public Type getType(){
		return type;
	}
	public Wood getBackWood(){
		return backWood;
	}
	public Wood getTopWood(){
		return topWood;
	}
	public int getYear(){
		return year;
	}
	public double getRent(){
		return rent;
	}

	public String getColour(){
		return colour;
	}
	//status 
	public Boolean inStore(){
		return inStore;
	}
	

	
	
	//setter
	public void setPrice(double price){
		this.price = price;
	}
	public void setRent(double rent){
		this.rent = rent;
	}
	
	// guitar rent or shop
	public void rented(){
		this.inStore = false;
	}
	public void returend(){
		this.inStore = true;
	}
	
	//display
	public void display() {
		System.out.println("Serial Number: " + serialNumber);
		System.out.println("Model: " + model);
		System.out.println("Type: " + type);
		System.out.println("Builder: " + builder);
		System.out.println("Colour: " + colour);
		System.out.println("TopWood: " + topWood);
		System.out.println("BackWood: " + backWood);
		System.out.println("Year of manufacture: " + year);
		System.out.println("Price: " + price);
		System.out.println("Rent rate per day: " + rent);
		
		if(inStore){
			System.out.println("Status: Shop");
		}else if(!inStore){
			System.out.println("Status: Rent");
		}
	}
}
