package ac.mmu.mmu_ac_assignment;

	//Mark Thomas Joseph Ryan-Palmer
	//13117467


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLConnection {

	
		String driverClassName = "com.mysql.jdbc.Driver";
		String dbUser = "joseph";
		String dbPwd = "theuser";
		String dBase = "assignment";
		
		
		//String connectionUrl = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk/"+dBase;
		String connectionUrl = "jdbc:google:mysql://mmuenterprise-1193:mmuesql/assignment";
	//			"jdbc:mysql://104.155.100.231/"+dBase;
		
			   // "jdbc:google:mysql://mmuenterprise-1193:mmuesql/database",
			   // "root", "theuser");
	
		
		
			private static SQLConnection connectiontoData = null;
			// Connection to data for DAO
		private SQLConnection() {
			try {
				Class.forName(driverClassName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		public Connection getConnection() throws SQLException {
			Connection conn = null;
			conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
			return conn;
		}

		public static SQLConnection getInstance() {
			if (connectiontoData == null) {
				connectiontoData = new SQLConnection();
			}
			return connectiontoData;
		}
	
}
