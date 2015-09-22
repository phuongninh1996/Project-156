package unl.cse.assignments;


/* Phase-I */
import com.airamerica.*;

import java.io.File;
import java.io.PrintWriter;


// Include imports for XML/JSON libraries if needed
import com.thoughtworks.xstream.XStream;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class DataConverter {

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
	// Read file Person
	public static void loadFilePersons(){
		Scanner s= null;
		try {
			s = new Scanner(new File("data/Persons.dat"));
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}

		while(s.hasNext()){
			String line= s.nextLine();
			String tokens[]= line.split(";");
			Person person= new Person();
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
			// Email address
			String emailaddresses[]= (tokens[4].split(","));
			for (int emailLength = 0; emailLength< emailaddresses.length; emailLength++){
				person.addEmail(emailaddresses[emailLength]);
			}
		}
	}
	// Read file Customers
	public static void loadFileCustomer(){
		Scanner s= null;
		try {
			s = new Scanner(new File("data/Persons.dat"));
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}

		while(s.hasNext()){
			String line= s.nextLine();
			String tokens[]= line.split(";");
			
			
			
			
			
		}
	}

	// Read file Invoices
	public static void loadFileInvoices(){
		Scanner s= null;
		try {
			s = new Scanner(new File("data/Persons.dat"));
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}

		while(s.hasNext()){
			String line= s.nextLine();
			String tokens[]= line.split(";");
		}
	}
	
	
	// Read file Products
	public static void loadFileProducts(){
		Scanner s= null;
		try {
			s = new Scanner(new File("data/Persons.dat"));
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}

		while(s.hasNext()){
			String line= s.nextLine();
			String tokens[]= line.split(";");
			
		}
	}
	// Read Airports
	public static void loadFileAirports(){
		Scanner s= null;
		try {
			s = new Scanner(new File("data/Persons.dat"));
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}

		while(s.hasNext()){
			String line= s.nextLine();
			String tokens[]= line.split(";");
		}
	}

}

hello how are you 
