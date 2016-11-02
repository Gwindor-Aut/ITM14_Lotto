package at.fhj.itm.routes;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/site")
public class SiteService {
	
	@GET
	@Path("/name/{name}")
	public Response getSiteWithName(@PathParam("name") String name){
		System.out.println(getClass().getClassLoader().getResourceAsStream(name));
		return Response.status(200).entity(name).build();
	}
}
