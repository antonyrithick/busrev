package busreserv;

import java.sql.SQLException;
import java.util.Scanner;

public class busdemo {

	public static void main(String[] args) throws SQLException, InterruptedException {
		try {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int userin;
			System.out.println("|==--ANNAI TRAVELS--==|\n");
			System.out.println("1.admin\n2.user\n3.exit \n");
			System.out.println("Enter your choice :");
			userin = sc.nextInt();
			if (userin == 1) {
				busadmin bda=new busadmin();
			}
			else if(userin==2) {
				bususer bu=new bususer();
			}
			else if (userin==3) {
				break;
			}
			else {
				System.out.println("invalid...{option}");
			}
		}
		}
		catch (Exception e) {
			System.out.println("server down....");
		}
     
	}

}
	
