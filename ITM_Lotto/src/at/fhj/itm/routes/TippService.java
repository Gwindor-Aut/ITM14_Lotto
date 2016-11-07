package at.fhj.itm.routes;

import java.sql.Date;
import java.util.Calendar;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import at.fhj.itm.dao.TippDAO;
import at.fhj.itm.model.Tipp;

@Path("/tipps")
public class TippService {
	
	TippDAO tdao = new TippDAO();
	
	@GET
	@Path("/test")
	public String Test(){
		return "<h1>TEST - /tipps</h1>";
	}
	
	@GET
	@Path("/id/{id}")
	public String getTippById(@PathParam("id") Integer id){
		Tipp t = tdao.read(id);
		return t.toString();
	}
	
	@POST
	@Path("/new")
	public void createNewTipp(@FormParam("isQuicktipp") boolean isQuicktipp,
			@FormParam("userId") int userId, @FormParam("drawId") int drawId,
			@FormParam("numberOne") int numberOne,
			@FormParam("numberTwo") int numberTwo,
			@FormParam("numberThree") int numberThree,
			@FormParam("numberFour") int numberFour,
			@FormParam("numberFive") int numberFive,
			@FormParam("numberSix") int numberSix){
		
		System.out.println("Test::createNewTipp");
		
		Date date = new Date(Calendar.getInstance().getTimeInMillis());
		
		String tipps = numberOne + ";" + numberTwo + ";" + numberThree + ";" + 
				numberFour + ";" + numberFive + ";" + numberSix;
		
		Tipp tipp = new Tipp(0, tipps, isQuicktipp, date, userId, drawId);
		
		System.out.println(tipp);
		
		try {
			int tippId = tdao.create(tipp);
			System.out.println("Tipp ID: " + tippId);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
