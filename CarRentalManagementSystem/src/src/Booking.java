package src;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Booking {
	private Car car;
	private Calendar start;
	private Calendar end;
	private int user;
	
	public Booking(Car car, Calendar start, Calendar end, int user) {
		this.setCar(car);
		this.setStart(start);
		this.setEnd(end);
		this.setUser(user);
	}
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Calendar getEnd() {
		return end;
	}

	public void setEnd(Calendar end) {
		this.end = end;
	}

	public Calendar getStart() {
		return start;
	}

	public void setStart(Calendar start) {
		this.start = start;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}
	
	public boolean current() {
		Calendar now = Calendar.getInstance();
		if(start.after(now)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		Date date = start.getTime();             
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");          
		String startDate = format1.format(date);
		
		date = end.getTime();                      
		String endDate = format1.format(date);
		
		return String.format("%s;%s;%s;%d", car.toString(), startDate, endDate, user);
	}
}
