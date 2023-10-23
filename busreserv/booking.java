package busreserv;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class booking {
	String passengerName;
	int busno;
	Date date;
    int booking_id;
    Scanner sc = new Scanner(System.in);
    
	booking() throws InterruptedException {
		System.out.println("Enter the passanger name :");
		passengerName = sc.next();
		System.out.println("Enter the busno :");
		busno = sc.nextInt();
		System.out.println("Enter the Date (DD-MM-YYYY) :");
		String dateinput = sc.next();
		System.out.println("please wait...processing...");
		Thread.sleep(2000);
		Random rs=new Random();
		int tempbk=rs.nextInt(9999);
		System.out.println("your booking_id is :"+tempbk);
		System.out.println("Enter the booking_id  :");
		booking_id = sc.nextInt();
		if(booking_id==tempbk) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			date = dateFormat.parse(dateinput);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		}
		else {
			System.out.println("wrong booking_id...>>");
		}
		sc.close();
	}

	public boolean isavailable() throws SQLException {
		busDAo busdao=new busDAo();
		int capacity=busdao.getCapcity(busno);
		
		bookingDAO bookingdao=new bookingDAO();
		int booked=bookingdao.getBookedCount(busno,date);
		
			return booked<capacity?true:false;
		

	}
	
	public void displaybill(){
		System.out.println("||BOOKING REFERENCE||\n");
		System.out.println("booking id :"+booking_id);
		System.out.println("passanger_name :"+passengerName);
		System.out.println("bus_no :"+busno);
		System.out.println("Travel_date :"+date);
		System.out.println("\n");
	}
	
   
 
}
