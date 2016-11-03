package at.fhj.itm.routes;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import at.fhj.itm.dao.AccountingDAO;
import at.fhj.itm.model.Accounting;

@Path("/accounting")
public class AccountingService {
	
	AccountingDAO adao = new AccountingDAO();
	
	@GET
	@Path("/test")
	public String Test(){
		return "<h1>TEST - /accounting</h1>";
	}

	@GET
	@Path("/id/{id}")
	public String getAccoutingById(@PathParam("id") Integer id){
		Accounting a = adao.read(id);
		return a.toString();
	}
	
	@POST
	@Path("/new")
	public void createNewAccount(String account){
		System.out.println("TEST::createNewAccount" + account);
	}
}
