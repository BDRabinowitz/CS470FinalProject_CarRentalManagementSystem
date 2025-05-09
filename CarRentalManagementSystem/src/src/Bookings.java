package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Bookings {
	private ArrayList<Booking> bookings;
	
	public Bookings() {
		this.bookings = new ArrayList<Booking>();
	}
	
	public Bookings(String filename) {
		this.bookings = new ArrayList<Booking>();
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
		bookings.add(b);
	}
	
	public void delete(Booking b) {
		bookings.remove(b);
	}
	
	public ArrayList<Booking> search(int user) {
		ArrayList<Booking> reserved = new ArrayList<Booking>();
		for(Booking b : bookings) {
			if(b.getUser() == user) {
				reserved.add(b);
			}
		}
		return reserved;
	}
	
	public ArrayList<Booking> search(Car c) {
		ArrayList<Booking> reserved = new ArrayList<Booking>();
		for(Booking b : bookings) {
			if(b.getCar().getId() == c.getId()) {
				reserved.add(b);
			}
		}
		return reserved;
	}
	
	public boolean dateOverlap(Booking b) {
		for(Booking book: bookings) {
			if(b.getCar().getId() == book.getCar().getId()) {
				if(b.getStart().before(book.getEnd()) && b.getStart().after(book.getStart())) {
					return true;
				}
				if(b.getEnd().before(book.getEnd()) && b.getEnd().after(book.getStart())) {
					return true;
				}
				if(book.getStart().before(b.getEnd()) && book.getStart().after(b.getStart())) {
					return true;
				}
				if(book.getEnd().before(b.getEnd()) && book.getEnd().after(b.getStart())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void toFile() throws FileNotFoundException {
		URL path = Inventory.class.getResource("bookings.txt");
		File f = new File(path.getFile());
		PrintWriter pw = new PrintWriter(f);
		for(Booking b : bookings) {
			pw.println(b.toString());
		}
		pw.close();
	}
}
