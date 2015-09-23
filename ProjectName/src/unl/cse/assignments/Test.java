package unl.cse.assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.joda.time.DateTime;

import com.airamerica.Address;
import com.airamerica.AirPort;
import com.airamerica.AwardTickets;
import com.airamerica.CheckedBagage;
import com.airamerica.Insurance;
import com.airamerica.OffSeasonTickets;
import com.airamerica.Person;
import com.airamerica.Customer;
import com.airamerica.Product;
import com.airamerica.Refreshment;
import com.airamerica.SpecialAssistance;
import com.airamerica.StandardTickets;
import com.thoughtworks.xstream.XStream;
public class Test {

	public static void main(String args[]) {
		ArrayList<Person> peopleList = new ArrayList<Person>();
		ArrayList<Product> productList = new ArrayList<Product>();
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		ArrayList<AirPort> airPortList = new ArrayList<AirPort>();		

		Scanner s= null;
		try {
			s = new Scanner(new File("data/Products.dat"));
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		// Create Strings to hold PersonCode, firstName, lastName...
		AirPort depAirportCode=null;
		AirPort arrAirportCode=null;
		while(s.hasNext()){
			String line= s.nextLine();
			String tokens[]= line.split(";");
			// productCode
			String productCode = tokens[0];
			//type
			String type= tokens[1];
			System.out.println(type);

			//declare all the variables
			String seasonStartDate;
			String seasonEndDate;
			String depTime;
			String arrTime;
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
						//System.out.println("hello");

						depAirportCode = airPortList.get(i);
					}

					else if( airPortList.get(i).getAirportCode().equals(tokens[3])){
						arrAirportCode= airPortList.get(i);
						//System.out.println(arrAirportCode);
					}

				}
				System.out.println(arrAirportCode);
				
				depTime= tokens[4];
				arrTime=tokens[5];
				flightNo= tokens[6];
				flightClass= tokens[7];
				aircraftType=tokens[8]; 				
				Product standardTicket = new StandardTickets(productCode,  type,  depAirportCode,  arrAirportCode, depTime, arrTime, flightNo, flightClass, aircraftType);
				productList.add(standardTicket);


			}
			//Off season Ticket
			else if(type.equals("TO")){
				seasonStartDate = tokens[2];
				seasonEndDate= tokens[3];
				for(int i=0; i< airPortList.size(); i++){
					if( airPortList.get(i).getAirportCode().equals(tokens[4])){
						depAirportCode = airPortList.get(i);
					}

					if( airPortList.get(i).getAirportCode().equals(tokens[5])){
						arrAirportCode= airPortList.get(i);}

				}
				depTime= tokens[6];
				arrTime=tokens[7];
				flightNo= tokens[8];
				flightClass= tokens[9];
				aircraftType=tokens[10]; 
				rebate=tokens[11];
				Product offSeasonTickets =  new OffSeasonTickets( productCode, type, seasonStartDate, seasonEndDate,  depAirportCode,  arrAirportCode,  depTime,
						arrTime,flightNo,flightClass,aircraftType, rebate );
				productList.add(offSeasonTickets);

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
				depTime= tokens[4];
				arrTime=tokens[5];
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


		XStream xstream = new XStream();
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("data/Product-example.xml"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println(productList.size());
		for(int i=0; i<productList.size(); i++){
			xstream.alias("product", Product.class);
			pw.print("<product>\n");
			pw.print(xstream.toXML(productList.get(i)) + "\n");
			pw.print("</product>" + "\n");
			
			/*if (productList.get(i).getType().equals("TS")){
				xstream.alias("product", StandardTickets.class);
				pw.print("<product>\n");
				pw.print(xstream.toXML(productList.get(i)) + "\n");
				pw.print("</product>" + "\n");
			}
			else if (productList.get(i).getType().equals("TO")){
				xstream.alias("product", OffSeasonTickets.class);
				pw.print("<product>\n");
				pw.print(xstream.toXML(productList.get(i)) + "\n");
				pw.print("</product>" + "\n");
			}
			else if (productList.get(i).getType().equals("TA")){
				xstream.alias("product", AwardTickets.class);
				pw.print("<product>\n");
				pw.print(xstream.toXML(productList.get(i)) + "\n");
				pw.print("</product>" + "\n");
			}
			else if (productList.get(i).getType().equals("SC")){
				xstream.alias("product", CheckedBagage.class);
				pw.print("<product>\n");
				pw.print(xstream.toXML(productList.get(i)) + "\n");
				pw.print("</product>" + "\n");
			}
			else if (productList.get(i).getType().equals("SI")){
				xstream.alias("product", Insurance.class);
				pw.print("<product>\n");
				pw.print(xstream.toXML(productList.get(i)));
				pw.print("</product>" + "\n");
			}
			else if (productList.get(i).getType().equals("SS")){
				xstream.alias("product", SpecialAssistance.class);
				pw.print("<product>\n");
				pw.print(xstream.toXML(productList.get(i)) + "\n");
				pw.print("</product>" + "\n");
			}
			else if (productList.get(i).getType().equals("SR")){
				xstream.alias("product", Refreshment.class);
				pw.print("<product>\n");
				pw.print(xstream.toXML(productList.get(i)) + "\n");
				pw.print("</product>" + "\n");
			}*/

		}
		pw.close();


	}
}