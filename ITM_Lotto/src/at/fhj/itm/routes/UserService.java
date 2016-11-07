package at.fhj.itm.routes;

import javax.ws.rs.FormParam;
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
	
	@POST
	@Path("/login")
	public void login(@FormParam("username") String username, @FormParam("password") String password){
		
		System.out.println("Login");
		
		try{
			System.out.println("Username: " + username);
			System.out.println("Password: " + password);
		} catch (Exception e){
			e.printStackTrace();
		}
	
	}

}
