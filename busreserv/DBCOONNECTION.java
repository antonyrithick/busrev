package busreserv;

import java.sql.*;

public class DBCOONNECTION {
   private static final String url="jdbc:mysql://localhost:3306/busrev";
   private static final String username="root";
   private static final String password="manager";
   
   public static Connection getConnection() throws SQLException{
	   return DriverManager.getConnection(url, username, password);
   }

   
}
