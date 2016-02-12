package ac.mmu.mmu_ac_assignment;

	//Mark Thomas Joseph Ryan-Palmer
	//13117467



import java.io.*;
import java.sql.*;



public class SQLConnection{

	
		String driverClassName = "com.mysql.jdbc.GoogleDriver";
		String dbUser = "root";
		String dbPwd = "";
		String dBase = "assignment";
		
		
		
		//String connectionUrl = "jdbc:mysql://localhost/"+dBase;
		String connectionUrl = "jdbc:google:mysql://mmuenterprise-1193:mmusql2/assignment?root";
	//			"jdbc:mysql://104.155.100.231/"+dBase;
		
			   // "jdbc:google:mysql://mmuenterprise-1193:mmuesql/database",
			   // "root", "theuser");
	
		
		
			private static SQLConnection connectiontoData = null;
			// Connection to data for DAO
		private SQLConnection()  throws SQLException, RuntimeException, ClassNotFoundException {
			
				Class.forName(driverClassName);
			
		}

		public Connection getConnection() throws SQLException {
			
			Connection conn = null;
			conn = DriverManager.getConnection(connectionUrl);
			//conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
			return conn;
		}

		public static SQLConnection getInstance() throws ClassNotFoundException, SQLException, RuntimeException {
			if (connectiontoData == null) {
				connectiontoData = new SQLConnection();
			}
			return connectiontoData;
		}
	
}
