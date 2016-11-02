package at.fhj.itm.routes;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/user")
public class UserService {
	
	@GET
	@Path("/test")
	public String Test(){
		return "<h1>TEST - /user</h1>";
	}
	
	@GET
	@Path("/id/{id}")
	public String getUserById(@PathParam("id") Integer id){
		return "Test::getUserById " + id;
	}
	
	@POST
	@Path("/new")
	public void createNewUser(String user){
		System.out.println("Test::createUser " + user);
	}

}
