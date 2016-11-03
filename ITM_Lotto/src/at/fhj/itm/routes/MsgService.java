package at.fhj.itm.routes;

import javax.ws.rs.*;

import at.fhj.itm.dao.MessageDAO;
import at.fhj.itm.model.Message;

@Path("/msg")
public class MsgService {
	
	MessageDAO mdao = new MessageDAO();
	
	@GET
	@Path("/test")
	public String Test(){
		return "<h1>TEST - /msg</h1>";
	}
	
	@GET
	@Path("/id/{id}")
	public String getMsgById(@PathParam("id") Integer id){
		Message m = mdao.read(id);
		return m.toString();
	}
	
	@POST
	@Path("/new")
	public void createNewMsg(String msg){
		System.out.println("Test::saveMsg " + msg);
	}
	
	
}
