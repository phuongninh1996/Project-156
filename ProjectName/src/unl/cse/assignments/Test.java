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
		Person person= new Person();
		List<String> emails;
		try {
			s = new Scanner(new File("data/Persons.dat"));
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		while(s.hasNext()){
			String line= s.nextLine();
			String tokens[]= line.split(";");
			person.setPersonCode(tokens[0]);
			// Name
			
			String name[]= tokens[1].split(",");
			person.setLastName(name[0]);
			person.setFirstName(name[1]); 
			// Address
			Address address = new Address();
			String addressTokened[]= tokens[2].split(",");
			address.setStreet(addressTokened[0]);
			address.setCity(addressTokened[1]);
			address.setState(addressTokened[2]);
			address.setZip(addressTokened[3]);
			address.setCountry(addressTokened[4]);
			
			person.setPhoneNo(tokens[3]);
			// Emailaddress
			String emailaddresses[]= (tokens[4].split(","));
			for (int emailLength = 0; emailLength< emailaddresses.length; emailLength++){
				//emails = person.setEmails(person.addEmail(emailaddresses[emailLength])); //how this email can be set
			}
			System.out.println(person.getLastName() );
		}
	}
}

