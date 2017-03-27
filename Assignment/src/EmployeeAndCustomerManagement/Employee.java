package EmployeeAndCustomerManagement;

import java.util.*;
import java.text.SimpleDateFormat;

import RentalManagement.Rental;
import StockManagement.Guitar;

public class Employee extends Person{
	/*
	 * For employee, additional information is office address, phone extension number, login details (username and password) and role like admin or staff.
	 */
	//private ArrayList<Employee> employees = new ArrayList<Employee>();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private String officeAddress;
	private String exPhone;
	private String username;
	private String password;
	private boolean isAdmin;
	
	public Employee(int id, String name, String address, String phone,Date birth, String officeAddress, String exPhone, String username, String password, boolean isAdmin){
		super(id, name,address,phone, birth);
		this.officeAddress = officeAddress;
		this.exPhone = exPhone;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	//part one
	// add Guitar
		public void addGuitar(Guitar guitar, ArrayList<Guitar> guitars){
			guitars.add(guitar);
		}
		//Display all the guitar
		public void displayGuitars(ArrayList<Guitar> guitars){
			int i = 1;
			for(Guitar g:guitars){
				System.out.println(i + ".");
				g.display();
				i++;
			}
			System.out.println("\n");
		}
		
		//Display a list of guitars available for rent
		public void guitarsAvailableForRent(ArrayList<Guitar> guitars){
			int i = 1;
			for(Guitar g: guitars){
				if(g.inStore()){
					System.out.println(i + ".");
					g.display();
					i++;
				}
			}
			System.out.println("\n");
		}
		//Search By Model
		
		public void searchGuitarsByModel(String model,ArrayList<Guitar> guitars){
			boolean isFound =false;
			int i = 1;
			for(Guitar g: guitars){
				if(g.getModel().toLowerCase().equals(model)){
					System.out.println(i++ + ".");
					System.out.println("Model: " + g.getModel());
					System.out.println("Builder: " + g.getBuilder());
					System.out.println("Colour: " + g.getColour());
					if(g.inStore()){
						System.out.println("Status: Shop");
					}else{
						System.out.println("Status: Rent");
					}
					System.out.print("\n");
					isFound = true;
				}
			}
			if(!isFound){
				System.out.println("Not Found, Model: " + model);
			}
		}
		
		//Search By serialNumber
		public Guitar searchGuitarBySerialNumber(String serialNumber, ArrayList<Guitar> guitars){
			Guitar guitar = null;
			for(Guitar g: guitars){
				if(g.getSerialNumber().equals(serialNumber)){
					guitar = g;
					break;
				}
			}
			return guitar;
		}
		//display guitar info  (search by serial number)
		public void displayGuitarBySerialNumber(String serialNumber, ArrayList<Guitar> guitars){
			Guitar g =searchGuitarBySerialNumber(serialNumber, guitars);
			if(g != null){
				System.out.println("Search for serialNumber: " + g.getSerialNumber());
				System.out.println("Colour: " + g.getColour());
				System.out.println("Backwood: " + g.getBackWood().toString());
				System.out.println("TopWood: " + g.getTopWood().toString());
				System.out.println("Builder: " + g.getBuilder());
				System.out.println("Type: " + g.getType());
				if(g.inStore()){
					System.out.println("Status: Shop");
				}else{
					System.out.println("Status: Rent");
				}
				System.out.print("\n");
			}else{
				System.out.println("Guitar not found ");
			}
		}
		
		//Search By year of manufacture
		public void searchGuitarsByYearOfManufacture(int year, ArrayList<Guitar> guitars){
			boolean isFound =false;
			int i = 1;
			for(Guitar g: guitars){
				if(g.getYear() == year){
					System.out.println(i++ + ".");
					System.out.println("Search for year: " + g.getYear());
					System.out.println("Model: " + g.getModel());
					System.out.println("Backwood: " + g.getBackWood());
					System.out.println("TopWood: " + g.getTopWood());
					System.out.println("Builder: " + g.getBuilder() + "\n");
					isFound = true;
				}
			}
			if(!isFound){
				System.out.println("Not Found, no match year : " + year);
			}
		}
		
		//Update the info of a selected guitar
		public void updateInfo(String serialNumber, ArrayList<Guitar> guitars){
			Guitar g = searchGuitarBySerialNumber(serialNumber, guitars);
			Scanner scan =new Scanner(System.in);
			if(g == null){
				System.out.println("Sorry this guitar does not exist");
			}else{
				//Before update 
				System.out.println("Before update :");
				g.display();
				//change info
				System.out.println("\nUpdate Info :");
				try{
					System.out.println("Change price to :");
					g.setPrice(scan.nextDouble());
				}catch(InputMismatchException ex){
					System.out.println("Not a number");
				}
				try{
					System.out.println("Change Rent charge per day to:");
					g.setRent(scan.nextDouble());
				}catch(InputMismatchException ex){
					System.out.println("Not a number");
				}

				//After update 
				System.out.println("\nAfter update :");
				g.display();
				//scan.close();
			}
		}
		//part two
		//Rent Guitar/Guitars to a customer by serialNumber
		public void rentGuitar(String serialNumber, Customer cust, ArrayList<Guitar> guitars,ArrayList<Rental> rentals){
			Guitar guitar = searchGuitarBySerialNumber(serialNumber, guitars);
			Rental ren = null;
			if(guitar == null){
				System.out.println("Sorry this guitar does not exist");
				//if found check the status
			}else if(!guitar.inStore()){
				System.out.println("Sorry this guitar has been rent");
			}else{
				
				Calendar c = Calendar.getInstance();
				Date rentDate = c.getTime();
				c.add(c.DATE, 7);
				Date returnDueDate = c.getTime();
				ren = new Rental(cust, guitar, rentDate, returnDueDate);
				rentals.add(ren);
				System.out.println("Guitar has been borrowed successfully");
				guitar.rented();
			}
		}
		//Return Guitar/Guitars rented by a customer by serialNumber
		public void ReturnGuitar(String serialNumber, ArrayList<Rental> rentals){
			for(Rental ren : rentals){
				if(ren.getGuitar().getSerialNumber().equals(serialNumber) && ren.getReturnDate() == null){
					ren.getGuitar().returend();
					Date returnDate = new Date();
					ren.setReturnDate(returnDate);
					System.out.println("Return sucessfully\n");
					if(returnDate.after(ren.getReturnDueDate())){
						System.out.println("late return");
					}
					//if guitar is return before the due date 
					//and i want to delete the rental history to free memory space
					//rentals.remove(ren);
				}
			}
		}
		//Display a list of guitar rented by a selected customer
		public void guitarsRentedbyCusotmer(Customer cust, ArrayList<Rental> rentals){
			boolean isFound = false;
			for(Rental ren: rentals){
				if(ren.getCustomer().equals(cust) && ren.getReturnDate() == null){
					if(!isFound){
						System.out.println("The customer details who rented guitar/guitars: " + ren.getCustomer().getName());
						isFound = true;
					}
					ren.getGuitar().display();
					System.out.println("The guitar has been rented on " + sdf.format(ren.getRentDate()));
					System.out.println("The guitar return due date " + sdf.format(ren.getReturnDueDate()));
					System.out.println("\n");
				}
			}
			if(!isFound){
				System.out.println("No rent result " );
			}
		}
		//Display the list of all guitars rented between two selected dates
		public void displayRentedBetweenTwoSelectedDates(Date startDate,Date endDate, ArrayList<Rental> rentals){
			int count = 1;
			for(Rental ren: rentals){
				//if between two selected dates
				if(ren.getRentDate().after(startDate) && ren.getRentDate().before(endDate) && !ren.getGuitar().inStore()){
					System.out.println(count++);
					ren.getGuitar().display();
					System.out.println("The guitar has been rented on " + sdf.format(ren.getRentDate()));
					System.out.println("The guitar return due date " + sdf.format(ren.getReturnDueDate()));
				}else{
					System.out.println("No guitar rented between " + sdf.format(startDate) + " " + sdf.format(endDate));
				}
					
			}
		}
		//part 3
		
		// Add details of a new employee
		public void addEmployee (Employee em, ArrayList<Employee> employees){
			employees.add(em);
		}
		// Add details of a new Customer
		public void addCustomer (Customer cust, ArrayList<Customer> customers){
			customers.add(cust);
		}
		//search person by id
		public void searchPerson(int id, ArrayList<Person> persons) {
			// TODO Auto-generated method stub
			boolean isFound =false;
			for(Person p: persons){
				//search person by id 
				if(p.getId() == id){
					isFound = true;
					//if person is employee
					if(p instanceof Employee){
						Employee em = (Employee) p;
						em.viewPersonUnfo();
						//update employee info
						if(wantUpdatePersonInfo()){
							updatePersonInfo();
							System.out.println("After Update: ");
							viewPersonUnfo();
						}
						
					}else if(p instanceof Customer){
						//if person is customer
						Customer cust = (Customer) p;
						cust.viewPersonUnfo();
						if(wantUpdatePersonInfo()){
							cust.updatePersonInfo();
							System.out.println("After Update: ");
							cust.viewPersonUnfo();
						}
					}
				}
			}
			//if not found
			if(!isFound){
				System.out.println("No match ID, not found");
			}
		}
		//ask for update person info 
		public boolean wantUpdatePersonInfo(){
			boolean update = false;
			Scanner scan = new Scanner(System.in);
			System.out.println("Update info ? (Y/N): ");
			try{
				char input = scan.next("[ynYN]").charAt(0);
				if(input == 'Y' || input == 'y'){
					update = true;
				}else if(input == 'N' || input == 'n'){
					update = false;
				}
			}catch(InputMismatchException ex){
				System.out.println("Error: Wrong input ");
			}
			
			return update;
		}
		//update Employee info
		@Override
		protected void updatePersonInfo() {
			// TODO Auto-generated method stub
			Scanner scan = new Scanner(System.in);
			// update new address
			System.out.println("Enter new address: ");
			try{

				String add = scan.next("^[a-z]+");	
				setAddress(add);
			}catch(InputMismatchException ex){
				System.out.println("Error: Wrong input ");
			}
			//update new telephone number
			System.out.println("Enter new telephone number: ");
			try{
				String tel = scan.next("[0-9]+");
				setPhone(tel);
			}catch(InputMismatchException ex){
				System.out.println("Error: Wrong input ");
			}
			// update new  office address
			System.out.println("Enter new office address: ");
			try{
				String offAdd = scan.next("[a-zA-Z]+");	
				setOfficeAddress(offAdd);
			}catch(InputMismatchException ex){
				System.out.println("Error: Wrong input ");
			}
			// update new extension phone
			System.out.println("Enter new extension phone: ");
			try{
				String exPhone = scan.next("[0-9]+");	
				setExPhone(exPhone);
			}catch(InputMismatchException ex){
				System.out.println("Error: Wrong input ");
			}
			// update new password
			System.out.println("Enter new password: ");
			try{
				String pass = scan.next();	
				setPassword(pass);
			}catch(InputMismatchException ex){
				System.out.println("Error: Wrong input ");
			}
		}
		@Override
		//display employee detail
		protected void viewPersonUnfo() {
			// TODO Auto-generated method stub
			System.out.println("Employee info: ");
			displayPersonInfo();
			System.out.println("office Address: " + officeAddress);
			System.out.println("Phone extension number : " + exPhone);
			System.out.println("Username: " + username);
			System.out.println("Password: " + password);
			if(isAdmin){
				System.out.println("Role: Admin");
			}else{
				System.out.println("Role: Staff");
			}
		}
		//setter 
		public void setOfficeAddress(String add){
			this.officeAddress = add;
		}
		public void setExPhone(String ph){
			this.exPhone = ph;
		}
		public void setPassword(String pass){
			this.password = pass;
		}
}