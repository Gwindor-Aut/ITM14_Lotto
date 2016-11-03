package at.fhj.itm.routes;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import at.fhj.itm.dao.WinningLevelDAO;
import at.fhj.itm.model.WinningLevel;

@Path("/winlev")
public class WinningLevelService {
	
	WinningLevelDAO wdao = new WinningLevelDAO();
	
	@GET
	@Path("/test")
	public String Test(){
		return "<h1>TEST - /winlev</h1>";
	}
	
	@GET
	@Path("/id/{id}")
	public String getWinningLevelById(@PathParam("id") Integer id){
		WinningLevel wl = wdao.read(id);
		return wl.toString();
	}
	
	@POST
	@Path("/new")
	public void createNewWinningLevel(String winlev){
		System.out.println("Test::createNewWinningLevel " + winlev);
	}
}
