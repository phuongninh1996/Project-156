package unl.cse.assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import com.airamerica.Address;
import com.airamerica.Person;
import com.airamerica.Customer;

public class Test {

public static void main(String args[]) {
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
		Person person = new Person(personCode, address1, firstName, lastName, phoneNo); //Create constructor for Person Class
		person.setPersonCode(personCode);//Add information to Person class
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setAddress(address1);
		person.setPhoneNo(phoneNo);
		// Emailaddress
		String emailaddresses[]= (tokens[4].split(","));
		for (int emailLength = 0; emailLength< emailaddresses.length; emailLength++){
			person.addEmail(emailaddresses[emailLength]);
		}
		System.out.println(person.getEmails());

		//Print out result
		/*System.out.println (person.getPersonCode() + " " +
							person.getFirstName() + " " +
							person.getLastName() + " " +
							person.getAddress().getStreet() + " " +
							person.getAddress().getCity() + " " +
							person.getAddress().getState() + " " +
							person.getAddress().getZip() + " " +
							person.getAddress().getCountry() + " " +
							person.getPhoneNo());*/
		
		}
	}
}