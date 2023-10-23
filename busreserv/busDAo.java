package busreserv;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class busDAo {
    
	public void busdisplayinfo() throws SQLException {
	String query="select * from bus";
	Connection	con=DBCOONNECTION.getConnection();
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(query);
	System.out.println("<<---bus details...>>>");
	while(rs.next()) {
		System.out.println("bus no : "+rs.getInt(1));
		if(rs.getInt(2)==1) {
		System.out.println("AC : YES");
		}
		else {
			System.out.println("AC : NO");
		}
		System.out.println("capacity : "+rs.getInt(3));
		System.out.println("pickup point : "+rs.getString(4));
		System.out.println("drop point : "+rs.getString(5));
		System.out.println("-----");
	}
	System.out.println("___________________________");
	
	}
	
	public int getCapcity(int id) throws SQLException {
		String query="select capacity from bus where id="+id;
		Connection con=DBCOONNECTION.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
}
