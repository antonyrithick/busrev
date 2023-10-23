package busreserv;

import java.sql.SQLException;
import java.util.Scanner;

public class busadmin {

	public busadmin() throws SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("---[[]]--welcome admin page--[[]]---");
		System.out.println("1.add new bus\n2.view bookings\n3.view worker details \n4.display bus information");
		int bain=sc.nextInt();
		switch (bain) {
		case 1:{
			addbus add=new addbus();
			add.displaybusinfo();
			break;
		}
		case 2:{
			bookingDAO bdao1=new bookingDAO();
			System.out.println("<<<---||total booking||--->>");
			bdao1.viewbooking();
			break;
		}
		case 3:{
			busadmin bs1=new busadmin("l");
			bs1.busworker();
			bs1.busworker("sales");
			break;
		}
		case 4:{
			System.out.println("display bus information...");
			addbus ad1=new addbus(1);
			ad1.busdetails();
			break;
		}
		default:
			System.out.println("______[[]]]_________");
		}
	}
	
	busadmin(String n){
		
	}
	
	public void busworker() {
		System.out.println("below driver details...");
	}
	
	public void busworker(String n) {
		System.out.println("below cleaner details...");
	}
}
