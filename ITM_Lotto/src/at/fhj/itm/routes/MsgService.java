package at.fhj.itm.routes;

import javax.ws.rs.*;

import at.fhj.itm.msg.FakeMsg;

@Path("/msg")
public class MsgService {
	
	FakeMsg fm = new FakeMsg();
	
	@GET
	@Path("/test")
	public String Test(){
		return "<h1>TEST - /msg</h1>";
	}
	
	@GET
	@Path("/id/{id}")
	public String getMsgById(@PathParam("id") Integer id){
		return "Test::getMsgById " + id;
	}
	
	@POST
	@Path("/new")
	public void createNewMsg(String msg){
		System.out.println("Test::saveMsg " + msg);
	}
	
	
}
