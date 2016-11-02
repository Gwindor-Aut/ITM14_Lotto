package at.fhj.itm.routes;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/tipps")
public class TippService {
	
	@GET
	@Path("/test")
	public String Test(){
		return "<h1>TEST - /tipps</h1>";
	}
	
	@GET
	@Path("/id/{id}")
	public String getTippById(@PathParam("id") Integer id){
		return "Test::TippById: " + id;
	}
	
	@POST
	@Path("/new")
	public void createNewTipp(String tipp){
		System.out.println("Test::createNewTipp " + tipp);
	}

}
