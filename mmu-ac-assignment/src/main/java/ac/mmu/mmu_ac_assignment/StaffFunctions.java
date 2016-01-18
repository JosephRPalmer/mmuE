package ac.mmu.mmu_ac_assignment;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import ac.mmu.mmu_ac_assignment.StaffDAO;
@SuppressWarnings("unused")
@Path("Staff")
public class StaffFunctions {
	
	DAO staff = new DAO();
	/*@GET
	@Path("/def")
	 @Produces(MediaType.TEXT_PLAIN)
	    public String getIt() {
	        return "Default";
	    }*/
	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public List<StaffMember> xmlout(){
		return staff.listStaff();
		
	}
	@GET
	//@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StaffMember> jsonout(){
		return staff.listStaff();
		
	}
	@GET
	@Path("/pt")
	@Produces(MediaType.TEXT_PLAIN)
	public String plain(){
		ArrayList<StaffMember> list = staff.listStaff();
		
		StringBuilder sb = new StringBuilder();
		for (StaffMember s : list)
		{
		    sb.append(s.getForename());
		    sb.append("\n");
		    sb.append(s.getSurname());
		    sb.append("\n");
		    sb.append(s.getPhone());
		    sb.append("\n");
		    sb.append(s.getStaffID());
		    sb.append("\n");
		    sb.append(s.getLocation());
		    sb.append("\n");
		    sb.append(s.getEmail());
		    sb.append("\n");
		    sb.append("\n");
		}

		
		return sb.toString();
		
	}


	
	 

}
