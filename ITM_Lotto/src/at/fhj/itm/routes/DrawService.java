package at.fhj.itm.routes;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/draw")
public class DrawService {
	
	@GET
	@Path("/test")
	public String Test(){
		return "<h1>TEST - /draw</h1>";
	}
	
	@GET
	@Path("/id/{id}")
	public String getDrawById(@PathParam("id") Integer id){
		return "Test::getDrawById " + id;
	}
	
	@POST
	@Path("/new")
	public void createNewDraw(String draw){
		System.out.println("Test::createNewDraw" + draw);
	}

}
