package at.fhj.itm.routes;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import at.fhj.itm.dao.DrawDAO;
import at.fhj.itm.model.Draw;

@Path("/draw")
public class DrawService {
	
	DrawDAO ddao = new DrawDAO();
	
	@GET
	@Path("/test")
	public String Test(){
		return "<h1>TEST - /draw</h1>";
	}
	
	@GET
	@Path("/id/{id}")
	public String getDrawById(@PathParam("id") Integer id){
		Draw d = ddao.read(id);
		return d.toString();
	}
	
	@POST
	@Path("/new")
	public void createNewDraw(String draw){
		System.out.println("Test::createNewDraw" + draw);
	}

}
