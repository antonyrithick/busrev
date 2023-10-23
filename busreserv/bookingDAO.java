package busreserv;

import java.awt.AWTError;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class bookingDAO{

	
	
	public int getBookedCount(int id,Date date)throws SQLException{
		String query="select count(passenger_name) from booking where bus_no=? and travel_date=?";
		Connection con=DBCOONNECTION.getConnection();
		PreparedStatement pst=con.prepareStatement(query);
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		pst.setInt(1, id);
		pst.setDate(2, sqlDate);
	    ResultSet rs=pst.executeQuery();
	    rs.next();
	    return rs.getInt(1);
		
	}
	
	public void addBooking(booking books)throws SQLException {
		java.sql.Date sqlDate=new java.sql.Date(books.date.getTime());
		String query="insert into booking values(?,?,?,?)";
		Connection con=DBCOONNECTION.getConnection();
		PreparedStatement pst=con.prepareStatement(query);
		pst.setString(1, books.passengerName);
		pst.setInt(2, books.busno);
		pst.setDate(3, sqlDate);
		pst.setInt(4,books.booking_id);
		int rs=pst.executeUpdate();
       		
	}
	
	public int calcellation(int bookid)throws SQLException {
		String query="delete from booking where booking_id=?";
		Connection con=DBCOONNECTION.getConnection();
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1, bookid);
		int rs=pst.executeUpdate();
		return rs;
	}
	
	public void viewbooking() throws SQLException {
		int count=0;
		String query="select * from booking";
		Connection con=DBCOONNECTION.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()) {
			System.out.println("passenger name :"+rs.getString(1));
			System.out.println("bus no :"+rs.getInt(2));
			System.out.println("Travel date :"+rs.getDate(3));
			System.out.println("booking id :"+rs.getInt(4));
			System.out.println("------");
			count++;
		}
	    System.out.println("total number of bookings :"+count);
	}
}
