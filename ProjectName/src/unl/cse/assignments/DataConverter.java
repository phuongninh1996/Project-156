package unl.cse.assignments;

/* Phase-I */
import com.airamerica.*;

import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;







// Include imports for XML/JSON libraries if needed
import com.thoughtworks.xstream.XStream;

public class DataConverter {
	static ArrayList<Person> peopleList = new ArrayList<Person>();
	static ArrayList<Product> productList = new ArrayList<Product>();
	static ArrayList<Customer> customerList = new ArrayList<Customer>();
	static ArrayList<AirPort> airPortList = new ArrayList<AirPort>();

	
	public static void main(String args[]) {
			
		// TODO: Add your code to read data from .dat files, create objects
		//and export them as XML or JSON 
		

		/*
		 * Uncomment the following line to see an example of XML implementation
		 * using XStream
		 */
//		/XMLExample();
	}

	/*
	 * An example of using XStream API It exports to "data/Person-example.xml"
	 * NOTE: It may be interesting to note how compositions (and relationships
	 * are exported. NOTE: Pay attention how to alias various properties of an
	 * object.
	 */
	/*public static void XMLExample() {
		XStream xstream = new XStream();

		Address address1 = new Address("Street1", "City1");
		Person p1 = new Person("PersonCode1", address1);
		p1.addEmail("Email1");
		p1.addEmail("Email2");
		Person p2 = new Person("PersonCode2", address1);
		p2.addEmail("Email3");
		p2.addEmail("Email4");
		xstream.alias("person", Person.class);
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("data/Person-example.xml"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		pw.print("<persons>\n");
		pw.print(xstream.toXML(p1) + "\n");
		pw.print(xstream.toXML(p2) + "\n");
		pw.print("</persons>" + "\n");
		pw.close();

		System.out.println("XML generated at 'data/Person-example.xml'");
	}*/
	
	
	
	// Method to load file Person
	public static void loadFilePersons(){
		Scanner s= null;
		try {
			s = new Scanner(new File("data/Persons.dat"));
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		// Create Strings to hold PersonCode, firstName, lastName...
		while(s.hasNext()){
			String line= s.nextLine();
			String tokens[]= line.split(";");
			String personCode = tokens[0];
			// Name
			String name[]= tokens[1].split(",");
			String firstName = name[0];
			String lastName = name[1];
			// Address
			String address[] = tokens[2].split(",");
			String street = address[0];
			String city = address[1];
			String state = address[2];
			String zipCode = address[3];
			String country = address[4];
			Address address1 = new Address(street,city,state,zipCode,country);//Creater constructor in Address class
			address1.setStreet(street);										  //Add address to address class
			address1.setCity(city);
			address1.setState(state);
			address1.setZip(zipCode);
			address1.setCountry(country);
			String phoneNo = tokens[3];
			Person person = new Person(personCode, address1, firstName, lastName, phoneNo);
			if (tokens.length == 5 ){
				String emailaddresses[] = (tokens[4].split(","));
				for (int emailLength = 0; emailLength< emailaddresses.length; emailLength++){
					person.addEmail(emailaddresses[emailLength]);
					}
			} 
			peopleList.add(person);
			

			//Print out result
			/*System.out.println (person.getPersonCode() + " " +
								person.getFirstName() + " " +
								person.getLastName() + " " +
								person.getAddress().getStreet() + " " +
								person.getAddress().getCity() + " " +
								person.getAddress().getState() + " " +
								person.getAddress().getZip() + " " +
								person.getAddress().getCountry() + " " +
								person.getPhoneNo() + " " + person.getEmails());*/
								
			
			}
		System.out.println(peopleList.get(0).getEmails()); 
	}
	
	
	
	
	//Method to load AirPort Data
	public static void loadFileAirport(){
		Scanner s= null;
		try {
			s = new Scanner(new File("data/Persons.dat"));
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		// Create Strings to hold airportCode, name , address...
		while(s.hasNext()){
			String line= s.nextLine();
			String tokens[]= line.split(";");
			// airportCode
			String airportCode = tokens[0];
			//name
			String name= tokens[1];
			//Address
			String address[] = tokens[2].split(",");
			String street = address[0];
			String city = address[1];
			String state = address[2];
			String zipCode = address[3];
			String country = address[4];
			Address address1 = new Address(street,city,state,zipCode,country);//Creater constructor in Address class
			//Coordinates
			String coordinatesArr[] = tokens[3].split(","); 
			String latdges = coordinatesArr[0];
			String latmins = coordinatesArr[1];
			String londegs = coordinatesArr[2];
			String lonmins = coordinatesArr[3];
			Coordinates coordinates = new Coordinates( latdges,  latmins,  londegs,  lonmins);
			
			//passengerFacilityFee
			String passengerFacilityFee = tokens[4];
			AirPort airPort = new AirPort(airportCode, name, address1, coordinates, passengerFacilityFee);
			
					
			// add all the airport into list of airport
			airPortList.add(airPort);
	}
	}
	
	
	
	
	
	// Method to load file Customer
	public static void loadFileCustomer(){
		Scanner s= null;
		try {
			s = new Scanner(new File("data/Persons.dat"));
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		// Create Strings to hold PersonCode, firstName, lastName...
		while(s.hasNext()){
			String line= s.nextLine();
			String tokens[]= line.split(";");
			// customerCode
			String customerCode = tokens[0];
			//type
			String type= tokens[1];
			//primaryContact
			Person primaryContact = null;
			for(int i=0; i< peopleList.size(); i++){
				if( peopleList.get(i).getPersonCode().equals(tokens[2]));
				primaryContact = peopleList.get(i);
			}
			//Name	
			String name = tokens[3];
			
			//airlineMiles
			String airlineMiles;
			if(tokens.length == 5){
			airlineMiles= tokens[4];}
			else { airlineMiles = null;}
			Customer customer = new Customer(customerCode ,primaryContact, type, name,airlineMiles );
			
			// add all the customers into list of customer
			customerList.add(customer);
	}
	}
	
	
	
	
	
	
	//Method to load Products
	public static void loadFileProducts(){
		Scanner s= null;
		try {
			s = new Scanner(new File("data/Persons.dat"));
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		// Create Strings to hold PersonCode, firstName, lastName...
		while(s.hasNext()){
			String line= s.nextLine();
			String tokens[]= line.split(";");
			// customerCode
			String customerCode = tokens[0];
			//type
			String type= tokens[1];
			//primaryContact
			Person primaryContact = null;
			for(int i=0; i< peopleList.size(); i++){
				if( peopleList.get(i).getPersonCode().equals(tokens[2]));
				primaryContact = peopleList.get(i);
			}
			//Name	
			String name = tokens[3];
			
			//airlineMiles
			String airlineMiles;
			if(tokens.length == 5){
			airlineMiles= tokens[4];}
			else { airlineMiles = null;}
			Customer customer = new Customer(customerCode ,primaryContact, type, name,airlineMiles );
			
			// add all the customers into list of customer
			customerList.add(customer);
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	