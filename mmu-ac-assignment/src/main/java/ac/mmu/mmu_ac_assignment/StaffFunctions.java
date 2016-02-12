package ac.mmu.mmu_ac_assignment;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.lang.Object;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
@SuppressWarnings("unused")
@Path("Staff")
public class StaffFunctions {
	
	DAO staff = new DAO();
	//Output XML
	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public List<StaffMember> xmlout(){
		return staff.listStaff();
		
	}
	//Output JSON, set by default
	@GET
	//@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String jsonout(){
		Gson bob = new GsonBuilder().setPrettyPrinting().create();
		String json = bob.toJson(staff.listStaff());
		return json;
		
	}
	//Output Plain Text
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
	//search using plain text output
	@GET
	@Path("/searchpt")
	@Produces(MediaType.TEXT_PLAIN)
	public String searchpt(@Context UriInfo uriInfo){
		String query = uriInfo.getQueryParameters().getFirst("search");
ArrayList<StaffMember> list = staff.searchStaff(query);
		
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
	//search using xml
	@GET
	@Path("/searchxml")
	@Produces(MediaType.APPLICATION_XML)
	public List<StaffMember> searchxml(@Context UriInfo uriInfo){
		String query = uriInfo.getQueryParameters().getFirst("search");
		return staff.searchStaff(query);
	}
	//search using js
	@GET
	@Path("/searchjs")
	@Produces(MediaType.APPLICATION_JSON)
	public String searchjson(@Context UriInfo uriInfo){
		 String query = uriInfo.getQueryParameters().getFirst("search");
		 Gson bob = new GsonBuilder().setPrettyPrinting().create();
			String json = bob.toJson(staff.searchStaff(query));
			return json;
		}
	//POST to save data, uses extra headers
	 @POST
	    @Path("/save")
	    @Consumes(MediaType.TEXT_PLAIN)
	    @Produces(MediaType.TEXT_PLAIN)
	    public String addto(@Context UriInfo uriInfo){
		 
		 DAO minion = new DAO();
		 StaffMember bob = new StaffMember();
		 bob.setForename(uriInfo.getQueryParameters().getFirst("name")); 
		 bob.setSurname(uriInfo.getQueryParameters().getFirst("surname"));
		 bob.setStaffID(uriInfo.getQueryParameters().getFirst("id"));
		 bob.setLocation(uriInfo.getQueryParameters().getFirst("location"));
		 bob.setPhone(uriInfo.getQueryParameters().getFirst("phone"));
		 bob.setEmail(uriInfo.getQueryParameters().getFirst("email"));
		 
		 minion.addStaff(bob);
	        
		 return "Success";
	        
	        
	    }


	
	 

}
