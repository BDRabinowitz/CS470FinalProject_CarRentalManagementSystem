package src;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

public class Inventory {
	private ArrayList<Car> list;
	public Inventory() {
		this.list = new ArrayList<Car>();
	}
	public Inventory(String filename) {
		this.list = new ArrayList<Car>();
		try {
			URL path = Inventory.class.getResource(filename);
			File myObj = new File(path.getFile());
		    Scanner myReader = new Scanner(myObj);
		    while (myReader.hasNextLine()) {
		       String[] data = myReader.nextLine().split(",");
		       Car c = new Car(Integer.parseInt(data[0]), data[1], data[2], Boolean.parseBoolean(data[3]), data[4], data[5], data[6], data[7], Integer.parseInt(data[8]));
		       this.add(c);
		   }
		   myReader.close();
		} catch (FileNotFoundException e) {
		       System.out.println("An error occurred.");
		       e.printStackTrace();
		}
	}
	
	public void add(Car c) {
		list.add(c);
	}
	
	public void delete(Car c) {
		list.remove(c);
	}
	
	public void delete(int index) {
		list.remove(index);
	}
	
	public void modify(int index, Car c) {
		list.set(index, c);
	}
	
	public Car at(int index) {
		return list.get(index);
	}
	
	public ArrayList<Car> getList(){
		return list;
	}
	
	public ArrayList<Car> available(){
		ArrayList<Car> avail = new ArrayList<Car>();
		for(Car c: list) {
			if(c.isAvailable()) {
				avail.add(c);
			}
		}
		return avail;
	}
	
	public ArrayList<Car> search(int maxPrice, String make, boolean available){
		ArrayList<Car> hits = new ArrayList<Car>();
		for(Car c: list) {
			if(c.isAvailable() || !available) {
				if(maxPrice==0||c.getPrice() <= maxPrice) {
					if(make.isEmpty() || c.getMake().equals(make)) {
						hits.add(c);
					}
				}
			}
		}
		return hits;
	}
	
	public void toFile() throws FileNotFoundException {
		URL path = Inventory.class.getResource("inventory.txt");
		File f = new File(path.getFile());
		PrintWriter pw = new PrintWriter(f);
		for(Car c : list) {
			pw.println(c.toString());
		}
		pw.close();
	}
	
	public static void main(String[] args) {
		Inventory inv = new Inventory("inventory.txt");
		for(Car c : inv.list) {
			System.out.println(c.toString());
		}
	}
}
