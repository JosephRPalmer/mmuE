package ac.mmu.mmu_ac_assignment;

import java.util.ArrayList;
import java.util.Collection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.google.appengine.api.utils.SystemProperty;

public class DAO implements Staff{

	Connection connection = null;
	PreparedStatement prepstate = null;
	ResultSet results = null;
	
		
	
	@Override
	//Implements interface method to add staff member to database
	public void addStaff(StaffMember sinfo) {
		// TODO Auto-generated method stub
		try {
			String url = null;
			
			  // Connecting from App Engine.
			  // Load the class that provides the "jdbc:google:mysql://"
			  // prefix.
			  Class.forName("com.mysql.jdbc.GoogleDriver");
			  url ="jdbc:google:mysql://mmuenterprise-1193:mmusql2/assignment?user=root";
			
			Connection conn = DriverManager.getConnection(url);
			String queryString = "INSERT INTO assignment(StaffID, Surname, Forename, Location, Phone, Email) VALUES(?,?,?,?,?,?)";
			
			prepstate = conn.prepareStatement(queryString);
			prepstate.setString(1, sinfo.getStaffID());
			prepstate.setString(2, sinfo.getSurname());
			prepstate.setString(3, sinfo.getForename());
			prepstate.setString(4, sinfo.getLocation());
			prepstate.setString(5, sinfo.getPhone());
			prepstate.setString(6, sinfo.getEmail());
			prepstate.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			

		}
	}

	@Override
	//Implements interface to list all staff
	public ArrayList<StaffMember> listStaff() {
		ArrayList<StaffMember> stafflist = null;
		try{
			String url = null;
			
			  // Connecting from App Engine.
			  // Load the class that provides the "jdbc:google:mysql://"
			  // prefix.
			  Class.forName("com.mysql.jdbc.GoogleDriver");
			  url ="jdbc:google:mysql://mmuenterprise-1193:mmusql2/assignment?user=root";
			
			Connection conn = DriverManager.getConnection(url);
			results = conn.createStatement().executeQuery("SELECT * FROM assignment");
						stafflist = new ArrayList<StaffMember>();
			while (results.next()) {
				StaffMember temp= new StaffMember();
				temp.setStaffID(results.getString("StaffID"));
				temp.setForename(results.getString("Forename"));
				temp.setSurname(results.getString("Surname"));
				temp.setLocation(results.getString("Location"));
				temp.setPhone(results.getString("Phone"));
				temp.setEmail(results.getString("Email"));
				stafflist.add(temp);
								
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (results != null)
					results.close();
				if (prepstate != null)
					prepstate.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		return stafflist;
	}

	@Override
	//implements interface to search for staff member by forename
	public ArrayList<StaffMember> searchStaff(String searchStr) {
		ArrayList<StaffMember> stafflist = null;
		try{
			String url = null;
			
			  // Connecting from App Engine.
			  // Load the class that provides the "jdbc:google:mysql://"
			  // prefix.
			  Class.forName("com.mysql.jdbc.GoogleDriver");
			  url ="jdbc:google:mysql://mmuenterprise-1193:mmusql2/assignment?user=root";
			
			Connection conn = DriverManager.getConnection(url);
			results = conn.createStatement().executeQuery("SELECT * FROM assignment WHERE Forename LIKE '%"+ searchStr + "%'");
						stafflist = new ArrayList<StaffMember>();
			while (results.next()) {
				StaffMember temp= new StaffMember();
				temp.setStaffID(results.getString("StaffID"));
				temp.setForename(results.getString("Forename"));
				temp.setSurname(results.getString("Surname"));
				temp.setLocation(results.getString("Location"));
				temp.setPhone(results.getString("Phone"));
				temp.setEmail(results.getString("Email"));
				stafflist.add(temp);
								
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (results != null)
					results.close();
				if (prepstate != null)
					prepstate.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		return stafflist;
	}
	
}
