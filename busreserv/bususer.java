package busreserv;

import java.sql.SQLException;
import java.util.Scanner;

public class bususer {
	Scanner sc = new Scanner(System.in);

	bususer() throws InterruptedException, SQLException {
		System.out.println("--[][][]---welcome customer page---[][][]--");
		//display bus details
		busDAo busdao=new busDAo();
        busdao.busdisplayinfo();
        //user choice
		System.out.println("1.booking 2.cancellation");
		int usin = sc.nextInt();
		if (usin == 1) {
			booking book = new booking();
			if (book.isavailable()) {
				bookingDAO bookingdao = new bookingDAO();
				bookingdao.addBooking(book);
				System.out.println("your booing is confirm...");
				System.out.println("please wait take the bill..");
				book.displaybill();
			} else {
				System.out.println("sorry bus is full try another bus or date...");
			}
		}
		else if (usin==2) {
			System.out.println("cancellation....");
			System.out.println("please enter the booking_id :");
			int bookid=sc.nextInt();
			bookingDAO bDao=new bookingDAO();
			int n=bDao.calcellation(bookid);
			if(n==1) {
				System.out.println("cancellation sucessul...");
				System.out.println("your amount was refund>>>");
			}
			else {
				System.out.println("||wrong booking_id||");
			}
		}
		else {
			System.out.println("<<<invalid input>>>");
		}
	}
}
