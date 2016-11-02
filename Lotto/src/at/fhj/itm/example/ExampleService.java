package at.fhj.itm.example;

import javax.ws.rs.*;

@Path("/")
public class ExampleService {

	@GET
	@Path("/hello")
	public String sayHello(){
		return "<h1>Hello</h1>";
	}
	
	@GET
	@Path("/name/{name}")
	public String sayName(@PathParam("name") String name){
		return "Hello " + name;
	}
	
}
