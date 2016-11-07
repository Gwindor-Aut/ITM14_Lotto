package at.fhj.itm.routes;

import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

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
	public void createNewManualTipp(@FormParam("userId") int userId, @FormParam("drawId") int drawId,
			@FormParam("numberOne") int numberOne,
			@FormParam("numberTwo") int numberTwo,
			@FormParam("numberThree") int numberThree,
			@FormParam("numberFour") int numberFour,
			@FormParam("numberFive") int numberFive,
			@FormParam("numberSix") int numberSix){
		
		System.out.println("Test::createNewManualTipp");
		
		Date date = new Date(Calendar.getInstance().getTimeInMillis());
		
		String tipps = numberOne + ";" + numberTwo + ";" + numberThree + ";" + 
				numberFour + ";" + numberFive + ";" + numberSix;
		
		Tipp tipp = new Tipp(0, tipps, false, date, userId, drawId);
		
		System.out.println(tipp);
		
		try {
			int tippId = tdao.create(tipp);
			System.out.println("Tipp ID: " + tippId);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@POST
	@Path("/new")
	public void createNewQuickTipp(@FormParam("userId") int userId,
			@FormParam("drawId") int drawId,
			@FormParam("quicktipps") int quicktipps){
		
		System.out.println("Test::createNewQuickTipp");
		Random randomGenerator = new Random();
		Date date = new Date(Calendar.getInstance().getTimeInMillis());
		
		for (int q = 0; q < quicktipps; q++) {
			String tipps = "";
			int[] numbers = new int[6];
			for (int i = 0; i < 6; i++) {
				// nextInt gibt einen Wert zwischen 0 - 44
				int randomInt = randomGenerator.nextInt(45) + 1;
				boolean exist = true;
				
				while (exist) {
					exist = find(numbers, randomInt);
				}
				
				numbers[i] = randomInt;
				if (i != 0) {
					tipps += ";";
				}
				tipps += randomInt;
			}
			
			Tipp tipp = new Tipp(0, tipps, true, date, userId, drawId);
			
			System.out.println(tipp);
			
			try {
				int tippId = tdao.create(tipp);
				System.out.println("Tipp ID: " + tippId);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean find(int[] array, int value) {
	    for (int i = 0; i < array.length; i++) 
	         if (array[i] == value)
	             return true;
	    
	    return false;
	}

}
