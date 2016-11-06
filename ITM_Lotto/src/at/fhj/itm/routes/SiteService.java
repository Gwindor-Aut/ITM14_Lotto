package at.fhj.itm.routes;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import at.fhj.itm.utils.FileLoader;

@Path("/site")
public class SiteService {
	
	FileLoader fl = new FileLoader();
	
	@GET
	@Path("/{name}")
	public Response getSiteWithName(@PathParam("name") String name){
		String resp = fl.getFile(name);
		System.out.println("TestSite: " 
				+ resp);
		return Response.status(200).entity(resp).build();
	}
}
