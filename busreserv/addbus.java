package busreserv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class addbus extends bus {
	private int buscount = 0;
	private String pickuppoint;
	private String droppoint;

	addbus() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the bus No :");
		busno = sc.nextInt();
		System.out.println("enter the Ac details(true /false) :");
		ac = sc.nextBoolean();
		System.out.println("Enter the capacity :");
		capacity = sc.nextInt();
		System.out.println("Enter the pickup point :");
		pickuppoint = sc.next();
		System.out.println("Enter the drop point :");
		droppoint = sc.next();
		try {
			addbusdetails();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("bus added.....");
		buscount++;
	}
	
	addbus(int l){
		
	}

	@Override
	public void displaybusinfo() {
		System.out.println("new bus details :" + "number of bus added :" + buscount);
		super.displaybusinfo();
	}

	public void addbusdetails() throws SQLException {
		String query = "insert into bus values(?,?,?,?,?);";
		Connection con = DBCOONNECTION.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, busno);
		pst.setBoolean(2, ac);
		pst.setInt(3, capacity);
		pst.setString(4, pickuppoint);
		pst.setString(5, droppoint);
		int rs = pst.executeUpdate();

	}

	@Override
	public void busdetails() {
		System.out.println("<<<bus deatils>>>");
		busDAo bsd1 = new busDAo();
		try {
			bsd1.busdisplayinfo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
