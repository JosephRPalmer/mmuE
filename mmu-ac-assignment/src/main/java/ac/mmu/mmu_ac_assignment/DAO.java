package ac.mmu.mmu_ac_assignment;

import java.util.ArrayList;
import java.util.Collection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DAO implements Staff{

	Connection connection = null;
	PreparedStatement prepstate = null;
	ResultSet results = null;
	
		
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = SQLConnection.getInstance().getConnection();
		return conn;
	}
	
	
	@Override
	public void addStaff(StaffMember sinfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList listStaff() {
		ArrayList<StaffMember> stafflist = null;
		try{
			String queryString = "SELECT * FROM assignment";
			connection = getConnection();
			prepstate = connection.prepareStatement(queryString);
			results = prepstate.executeQuery();
			
			stafflist = new ArrayList<StaffMember>();
			while (results.next()) {
				StaffMember temp= new StaffMember();
				temp.setStaffID(results.getInt("StaffID"));
				temp.setForename(results.getString("Forename"));
				temp.setSurname(results.getString("Surname"));
				temp.setLocation(results.getString("Location"));
				temp.setPhone(results.getString("Phone"));
				temp.setEmail(results.getString("Email"));
				stafflist.add(temp);
								
				}
		} catch (SQLException e) {
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
	public Collection searchStaff(String searchStr) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
