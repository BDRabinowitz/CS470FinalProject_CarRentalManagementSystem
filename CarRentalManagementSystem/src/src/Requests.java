package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Requests {
	private ArrayList<Booking> requests;
	
	public Requests() {
		this.requests = new ArrayList<Booking>();
	}
	
	public Requests(String filename) {
		this.requests = new ArrayList<Booking>();
		try {
			URL path = Inventory.class.getResource(filename);
			File myObj = new File(path.getFile());
		    Scanner myReader = new Scanner(myObj);
		    while (myReader.hasNextLine()) {
		       String[] line = myReader.nextLine().split(";");
		       String[] data = line[0].split(",");
		       Car c = new Car(Integer.parseInt(data[0]), data[1], data[2], Boolean.parseBoolean(data[3]), data[4], data[5], data[6], data[7], Integer.parseInt(data[8]));
		       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		       Calendar start = Calendar.getInstance();
		       try {
		            Date date = sdf.parse(line[1]);
		            start.setTime(date);
		       } catch (ParseException e) {
		            System.err.println("Error parsing date: " + e.getMessage());
		       }
		       Calendar end = Calendar.getInstance();
		       try {
		            Date date = sdf.parse(line[2]);
		            end.setTime(date);
		       } catch (ParseException e) {
		            System.err.println("Error parsing date: " + e.getMessage());
		       }
		       this.add(new Booking(c, start, end, Integer.parseInt(line[3])));
		   }
		   myReader.close();
		} catch (FileNotFoundException e) {
		       System.out.println("An error occurred.");
		       e.printStackTrace();
		}
	}
	
	public void add(Booking b) {
		requests.add(b);
	}
	
	public void remove(Booking b) {
		requests.remove(b);
	}
	
	public Booking remove(int index) {
		return requests.remove(index);
	}
	
	public ArrayList<Booking> getList() {
		return this.requests;
	}
	
	public ArrayList<Booking> search(int user) {
		ArrayList<Booking> reserved = new ArrayList<Booking>();
		for(Booking b : requests) {
			if(b.getUser() == user) {
				reserved.add(b);
			}
		}
		return reserved;
	}
	
	
	public void toFile() throws FileNotFoundException {
		URL path = Inventory.class.getResource("requests.txt");
		File f = new File(path.getFile());
		PrintWriter pw = new PrintWriter(f);
		for(Booking b : requests) {
			System.out.println(b.toString());
			pw.println(b.toString());
		}
		pw.close();
	}
}
