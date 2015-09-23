package unl.cse.assignments;

/* Phase-I */
import com.airamerica.*;

import org.joda.time.DateTime;

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
			//Coordinates - find longtitude and latitude
			String coordinatesArr[] = tokens[3].split(","); 
			double latdges = Double.parseDouble(coordinatesArr[0]);
			double latmins = Double.parseDouble(coordinatesArr[1]);
			double londegs = Double.parseDouble(coordinatesArr[2]);
			double lonmins = Double.parseDouble(coordinatesArr[3]);
			Coordinates coordinates = new Coordinates( latdges,  latmins,  londegs,  lonmins);
			double latitude = coordinates.latitudeCalculate();
			double longtitude = coordinates.longtitudeCalculate();
			//passengerFacilityFee
			String passengerFacilityFee = tokens[4];
			AirPort airPort = new AirPort(airportCode, name, address1, latitude, longtitude, passengerFacilityFee);


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
			// productCode
			String productCode = tokens[0];
			//type
			String type= tokens[1];
			//declare all the variables
			DateTime seasonStartDate;
			DateTime seasonEndDate;
			AirPort depAirportCode= null;
			AirPort arrAirportCode= null;
			DateTime depTime;
			DateTime arrTime;
			String flightNo;
			String flightClass;
			String aircraftType;
			String rebate;
			String pointsPerMile;
			//Comparing the services
			//Standard ticket
			if(type.equals("TS")){
				for(int i=0; i< airPortList.size(); i++){
					if( airPortList.get(i).getAirportCode().equals(tokens[2])){
						depAirportCode = airPortList.get(i);
					}

					if( airPortList.get(i).getAirportCode().equals(tokens[3])){
						arrAirportCode= airPortList.get(i);}

				}
				depTime= DateTime.parse(tokens[4]);
				arrTime=DateTime.parse(tokens[5]);
				flightNo= tokens[6];
				flightClass= tokens[7];
				aircraftType=tokens[8]; 				
				Product standardTicket = new StandardTickets(productCode,  type,  depAirportCode,  arrAirportCode, depTime, arrTime, flightNo, flightClass, aircraftType);
				productList.add(standardTicket);


			}
			//Off season Ticket
			else if(type.equals("TO")){
				seasonStartDate = DateTime.parse(tokens[2]);
				seasonEndDate= DateTime.parse(tokens[3]);
				for(int i=0; i< airPortList.size(); i++){
					if( airPortList.get(i).getAirportCode().equals(tokens[4])){
						depAirportCode = airPortList.get(i);
					}

					if( airPortList.get(i).getAirportCode().equals(tokens[5])){
						arrAirportCode= airPortList.get(i);}

				}
				depTime= DateTime.parse(tokens[6]);
				arrTime=DateTime.parse(tokens[7]);
				flightNo= tokens[8];
				flightClass= tokens[9];
				aircraftType=tokens[10]; 
				rebate=tokens[11];
				Product offSeasonTickets =  new OffSeasonTickets( productCode, type, seasonStartDate, seasonEndDate,  depAirportCode,  arrAirportCode,  depTime,
						arrTime,flightNo,flightClass,aircraftType, rebate );

			}
			//Award ticket
			else if(type.equals("TA")){
				for(int i=0; i< airPortList.size(); i++){
					if( airPortList.get(i).getAirportCode().equals(tokens[2])){
						depAirportCode = airPortList.get(i);
					}

					if( airPortList.get(i).getAirportCode().equals(tokens[3])){
						arrAirportCode= airPortList.get(i);}

				}
				depTime= DateTime.parse(tokens[4]);
				arrTime=DateTime.parse(tokens[5]);
				flightNo= tokens[6];
				flightClass= tokens[7];
				aircraftType=tokens[8]; 
				pointsPerMile =tokens[9];
				Product awardTicket = new AwardTickets(productCode, type, depAirportCode,  arrAirportCode, depTime, arrTime, flightNo, flightClass, aircraftType, pointsPerMile);
				productList.add(awardTicket);


			}
			//Checked baggage
			else if(type.equals("SC")){
				String ticketCode = tokens[2];
				Product checkedBaggage = new CheckedBagage(productCode, type,  ticketCode);
				productList.add(checkedBaggage);

			}
			//Insurance
			else if(type.equals("SI")){
				String name = tokens[2];
				String ageClass= tokens[3];
				String costPerMile= tokens[4];
				Product insurance = new Insurance( productCode,  type,  name,  ageClass, costPerMile); 
				productList.add(insurance);

			}
			//Special assistance
			else if(type.equals("SS")){
				String typeofService=tokens[2];
				Product assistance = new SpecialAssistance(productCode,  type,  typeofService);
				productList.add(assistance);


			}
			//Refreshments
			else if(type.equals("SR")){
				String name= tokens[2];
				String cost= tokens[3];
				Product refreshment = new Refreshment(productCode, type, name, cost);
				productList.add(refreshment);

			}


		}
	}


}

