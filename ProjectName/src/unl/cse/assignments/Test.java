package unl.cse.assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.airamerica.Address;
import com.airamerica.Person;
import com.airamerica.Customer;
import com.thoughtworks.xstream.XStream;
public class Test {

	public static void main(String args[]) {
		ArrayList<Person> peopleList = new ArrayList<Person>();
		Person person1  = null;

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
			String phoneNo = tokens[3];
			Person person = new Person(personCode, address1, firstName, lastName, phoneNo);
			if (tokens.length == 5 ){
				String emailaddresses[] = (tokens[4].split(","));
				for (int emailLength = 0; emailLength< emailaddresses.length; emailLength++){
					person.addEmail(emailaddresses[emailLength]);
				}
			} 
			//person1 = person;
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

			//System.out.println(peopleList.get(1).getPhoneNo()); 
			//System.out.println(person1.getFirstName());

		}

		XStream xstream = new XStream();
		xstream.alias("person", Person.class);
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("data/Person-example.xml"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		pw.print("<persons>\n");
		for(int i=0; i<peopleList.size(); i++){
			pw.print(xstream.toXML(peopleList.get(i)) + "\n");
		}
		pw.print("</persons>" + "\n");
		pw.close();

	}
	//System.out.println(peopleList.get(0).getEmails()); 
	//System.out.println(person1.getFirstName());

}