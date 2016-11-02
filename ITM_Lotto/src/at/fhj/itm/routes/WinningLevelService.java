package at.fhj.itm.routes;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/winlev")
public class WinningLevelService {
	
	@GET
	@Path("/test")
	public String Test(){
		return "<h1>TEST - /winlev</h1>";
	}
	
	@GET
	@Path("/id/{id}")
	public String getWinningLevelById(@PathParam("id") Integer id){
		return "Test::getWinningLevelById " + id;
	}
	
	@POST
	@Path("/new")
	public void createNewWinningLevel(String winlev){
		System.out.println("Test::createNewWinningLevel " + winlev);
	}
}
