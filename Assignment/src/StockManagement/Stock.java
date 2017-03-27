package StockManagement;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import EmployeeAndCustomerManagement.Customer;
import EmployeeAndCustomerManagement.Employee;
import EmployeeAndCustomerManagement.Person;
import RentalManagement.Rental;

public class Stock {
	private static ArrayList<Guitar> guitars  = new ArrayList<Guitar>();
	private static ArrayList<Rental> rentals  = new ArrayList<Rental>();
	private static ArrayList<Employee> employees = new ArrayList<Employee>(); 
	private static ArrayList<Person> persons = new ArrayList<Person>(); 
	static Scanner scan = new Scanner(System.in);
	static Calendar c = Calendar.getInstance();
	//main method for testing
	public static void main(String[] args){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		//employee one date of birth
		c.set(1990, 01, 25);
		Date em1_birth = c.getTime();
		//create employee & customer
		Employee em1 = createEmployee();
		em1.searchPerson(1, persons);
		Customer cust = createCustomer();
		em1.searchPerson(2, persons);
		//create 3 guitars
		Guitar g1 = new Guitar("1", 200, Builder.PARAS, "Stratocaster",Type.ACOUSTIC,Wood.ADIRONDACK,Wood.COCOBOLO,2016, 10,"Red");
		Guitar g2 = new Guitar("2", 300, Builder.FENDER, "Telecaster",Type.ELECTRIC,Wood.SITKA,Wood.CEDAR,2015, 40,"Blue");
		Guitar g3 = new Guitar("3", 400, Builder.RYAN, "Stratocaster",Type.ACOUSTIC,Wood.ALDER,Wood.BRAZILIAN_ROSEWOOD,2016,30,"Black");
		
		//testing part 1
		
		// 1-1 Add a new guitar information
		//Employee add guitars 
		
		em1.addGuitar(g1,guitars);
		em1.addGuitar(g2,guitars);
		em1.addGuitar(g3,guitars);
		
		/*
		//Display all the guitars
		System.out.println("Display List of Guitars: ");
		em1.displayGuitars(guitars);
		// 1-2 Display a list of guitars available for rent
		//set Guitar g2 to rent 
		g2.rented();
		System.out.println("Display list of guitars available for rent: ");
		em1.guitarsAvailableForRent(guitars);
		//set Guitar g2 to return 
		g2.returend();
		//1-3 Display guitars details model, builder, colour and status of a selected model
		System.out.println("Enter the model to search guitars: " );
		try{
			String model = scan.next();
			em1.searchGuitarsByModel(model.toLowerCase(),guitars);
		}catch(InputMismatchException  ex){
			System.out.println("Error: Wrong input type string ");
		}
		//1-4 Display guitar details colour, backwood, topwood, builder, type and status of a selected serialNumber
		System.out.println("Enter the serial number to search guitar: " );
		try{
			String serialNum = scan.next();
			em1.displayGuitarBySerialNumber(serialNum.toLowerCase(),guitars);
		}catch(InputMismatchException  ex){
			System.out.println("Error: Wrong input type (string)");
		}
		//1-5 Display guitars details model, backwood, topwood and builder of a selected year of manufacture
		System.out.println("Enter the year of manufacture to search guitars: " );
		try{
			int year = scan.nextInt();
			em1.searchGuitarsByYearOfManufacture(year,guitars);
		}catch(InputMismatchException  ex){
			System.out.println("Error: Wrong input type (int)");
		}
		//1-6 Update the information of a selected guitar ( Hint: search guitar by its serialNumber and allow to 
		//update its details, you need to check what details of a guitar are changeable.)
		//test 2 times (1)
		System.out.println("Enter the serial number to update the infomation  of a selected guitar: ");
		try{
			String serialNum = scan.next();
			em1.updateInfo(serialNum,guitars);
		}catch(InputMismatchException  ex){
			System.out.println("Error: Wrong input type (string)");
		}
		//(2)
		System.out.println("Enter the serial number to update the infomation  of a selected guitar: ");
		try{
			String serialNum = scan.next();
			em1.updateInfo(serialNum,guitars);
		}catch(InputMismatchException  ex){
			System.out.println("Error: Wrong input type (string)");
		}
		*/
		
		//testing part 2
		/*
		//create 3 customers
		c.set(1970, 05, 11);
		Date cust1Birthday = c.getTime();
		c.set(2018, 7, 17);
		Date cust1LicenceExpiryDate = c.getTime();
		Customer cust1 = new Customer(2, "Ben", "Auckland", "098765432", cust1Birthday, "A123456" ,cust1LicenceExpiryDate);
		c.set(1980, 01, 1);
		Date cust2Birthday = c.getTime();
		c.set(2020, 4, 30);
		Date cust2LicenceExpiryDate = c.getTime();
		Customer cust2 = new Customer(3, "Chris", "Horeke", "091234567", cust2Birthday, "B123456"  ,cust2LicenceExpiryDate);
		c.set(1990, 05, 11);
		Date cust3Birthday = c.getTime();
		c.set(2019, 9, 5);
		Date cust3LicenceExpiryDate = c.getTime();
		Customer cust3 = new Customer(4, "Kevin", "Botany", "095789612", cust3Birthday, "C123456"  ,cust3LicenceExpiryDate);
		*/
		/*
		//2-2 Rent Guitar/Guitars to a customer
		//Customer (cust2) rent guitar(g3) serial numbers = 3
		//Customer (cust2) rent guitar(g2) serial numbers = 2
		em1.rentGuitar("3", cust2, guitars, rentals);
		em1.rentGuitar("2", cust2, guitars, rentals);
		//try the guitar not exist
		em1.rentGuitar("4", cust2, guitars, rentals);
		//try the guitar has been rent 
		em1.rentGuitar("3", cust1, guitars, rentals);
		//Customer (cust1) rent guitar(g1) serial numbers = 1
		em1.rentGuitar("1", cust1, guitars, rentals);
		
		//test rental display to check the rental system work
		for(Rental ren: rentals){
			ren.display();
		}
		//2-3 Return Guitar/Guitars rented by a customer
		//Customer (cust2) return guitar(g3) serial numbers = 3
		em1.ReturnGuitar("3", rentals);
		//2-1 Display a list of guitar rented by a selected customer
		em1.guitarsRentedbyCusotmer(cust2, rentals);
		//test customer(cust3) rent a guitar or not (not)
		em1.guitarsRentedbyCusotmer(cust3, rentals);
	    //2-4 Display the list of all guitars rented between two selected dates
		System.out.println("Display the list of all guitars rented between two selected dates: ");
		System.out.println("Enter start date (yyyy-MM-dd): ");
		String s =scan.next();
		Date startDate;
		Date endDate;
		try {
			startDate = sdf.parse(s);
			System.out.println("Enter end date (yyyy-MM-dd): ");
			s =scan.next();
			endDate = sdf.parse(s);
			em1.displayRentedBetweenTwoSelectedDates(startDate, endDate, rentals);	
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		//part 3
		/*
		//create 3 employees
		Employee em2 = new Employee(124, "Benny", "Auckland2", "091545", em1_birth,  "Maaaa", "021111111", "user2", "pass2", false);
		Employee em3 = new Employee(125, "Justina", "Auckland3", "09177777", em1_birth,  "Bbbbbb", "022222222", "user3", "pass3", true);
		Employee em4 = new Employee(126, "Kobe", "Auckland4", "0918888", em1_birth,  "ccccc", "033333333", "user4", "pass4", false);
		//3-3 Add details of a new employee

		em1.addEmployee(em2, employees);
		em1.addEmployee(em3, employees);
		em1.addEmployee(em4, employees);
		
		
		//3-1, 3-2, 3-4 View and update information of a selected customer or Employee
				
		persons.add(em1);
		persons.add(em2);
		persons.add(em3);
		persons.add(em4);
		
		persons.add(cust1);
		persons.add(cust2);
		persons.add(cust3);
		//search Person by id
		System.out.println("Search Person detail (by ID): ");
		System.out.println("Enter ID: ");
		try{
			int id = scan.nextInt();
			em1.searchPerson(id, persons);
		}catch(InputMismatchException ex){
			System.out.println("Error: worng input ");
		}
		*/
	}
	//create employee
	private static Employee createEmployee(){
		//int id, String name, String address, String phone,Date birth, String officeAddress, String exPhone, String username, String password, boolean isAdmin
		Employee em= null;
		System.out.println("Enter how many employee want to add: ");
		int number = scan.nextInt();
		for(int i =0; i < number; i++){
			System.out.println("Add new Employee: ");
			System.out.println("Enter ID: ");
			int id = scan.nextInt();
			System.out.println("Enter Name: ");
			String name = scan.next("[a-zA-Z]+");
			System.out.println("Enter Address: ");
			String add = scan.next();
			System.out.println("Enter Phone: ");
			String phone = scan.next();
			System.out.println("Enter date of birth: ");
			System.out.println("Enter Year: ");
			int year = scan.nextInt();
			System.out.println("Enter Month: ");
			int month = scan.nextInt()-1;
			System.out.println("Enter Date: ");
			int date = scan.nextInt();
			c.set(year, month, date);
			Date birth = c.getTime();
			System.out.println("Enter Office Address: ");
			String offAdd = scan.next();
			System.out.println("Enter extension phone: ");
			String exphone = scan.next();
			System.out.println("Enter User name: ");
			String userName = scan.next();
			System.out.println("Enter password: ");
			String pass = scan.next();
			System.out.println("Enter Role (Admin or staff): ");
			String input = scan.next();
			boolean role = false;
			if(input.toLowerCase().equals("admin")){
				role = true;
			}else if(input.toLowerCase().equals("staff")){
				role = false;
			}
			em =new Employee(id, name, add, phone, birth, offAdd, exphone, userName, pass, role);
			employees.add(em);
			persons.add(em);
		}
		return em;
	}
	//create Customer
	private static Customer createCustomer(){
		//(int id, String name, String address, String phone, Date birth, String licenceNum, int age  ,Date licenceExpiryDate)
		Customer cust = null;
		System.out.println("Enter how many Customer want to add: ");
		int number = scan.nextInt();
		for(int i =0; i < number; i++){
			System.out.println("Add new Employee: ");
			System.out.println("Enter ID: ");
			int id = scan.nextInt();
			System.out.println("Enter Name: ");
			String name = scan.next("[a-zA-Z]+");
			System.out.println("Enter Address: ");
			String add = scan.next();
			System.out.println("Enter Phone: ");
			String phone = scan.next();
			System.out.println("Enter date of birth: ");
			System.out.println("Enter Year: ");
			int year = scan.nextInt();
			System.out.println("Enter Month: ");
			int month = scan.nextInt()-1;
			System.out.println("Enter Date: ");
			int date = scan.nextInt();
			c.set(year, month, date);
			Date birth = c.getTime();
			
			System.out.println("Enter licence Number: ");
			String licNum = scan.next();
			System.out.println("Enter licence Expiry Date: ");
			System.out.println("Enter Year: ");
			year = scan.nextInt();
			System.out.println("Enter Month: ");
			month = scan.nextInt()-1;
			System.out.println("Enter Date: ");
			date = scan.nextInt();
			c.set(year, month, date);
			Date  licenceED= c.getTime();
			cust =new Customer(id, name, add, phone, birth, licNum,licenceED);
			//employees.add(em);
			persons.add(cust);
		}
		return cust;
	}
	/*
	// create guitar
	private static void createGuitar(){
		//String serialNumber, double price, Builder builder,String model, Type type, Wood backWood, Wood topWood, int year, double rent, String colour 
		System.out.println("Enter how many guitar want to add: ");
		int number = scan.nextInt();
		for(int i = 0; i<number; i++){
			
			System.out.println("Add new Guitar: ");
			System.out.println("Enter Serial Number: " );
			String serNum = scan.next();
			System.out.println("Enter Price: ");
			double price = scan.nextDouble();
			System.out.println("Enter Model: ");
			String m = scan.next();
			
			System.out.println("Enter Type: " );
			
			Type type = Type.valueOf(scan.next().toUpperCase());
			System.out.println("Enter Builder: " );
			System.out.println("Enter Colour: " );
			System.out.println("Enter TopWood: " );
			System.out.println("Enter BackWood: ");
			System.out.println("Enter Year of manufacture: " );
			System.out.println("Enter Rent rate per day: " );
			System.out.println("Enter Status: (Shop/rent)");
			
			Guitar guitar = new Guitar(serialNumber, price, builder,model, type, backWood, topWood, year, rent, colour );
			guitars.add(guitar);
			
		}
	}*/
	//access all the guitars
	public ArrayList<Guitar> getBooks(){
		return guitars;
	}
	public ArrayList<Rental> getRental(){
		return rentals;
	}
}
