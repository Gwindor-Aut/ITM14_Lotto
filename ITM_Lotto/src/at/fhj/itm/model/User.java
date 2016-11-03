package at.fhj.itm.model;

public class User {
	
	public int id;
	public String username;
	public String password;
	
	public User (int id, String username, String password){
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public User(){};

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
}
