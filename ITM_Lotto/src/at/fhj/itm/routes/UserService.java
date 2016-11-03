package at.fhj.itm.routes;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import at.fhj.itm.dao.UserDAO;
import at.fhj.itm.model.User;

@Path("/user")
public class UserService {
	
	UserDAO udao = new UserDAO();
	
	@GET
	@Path("/test")
	public String Test(){
		return "<h1>TEST - /user WTF</h1>";
	}
	
	@GET
	@Path("/id/{id}")
	public String getUserById(@PathParam("id") Integer id){
		User u = udao.read(id);
		return u.toString();
	}
	
	@POST
	@Path("/new")
	public void createNewUser(String user){
		System.out.println("Test::createUser " + user);
	}

}
