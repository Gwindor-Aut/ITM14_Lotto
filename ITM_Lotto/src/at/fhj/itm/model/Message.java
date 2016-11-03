package at.fhj.itm.model;

import java.sql.Date;

public class Message {
	
	public int id;
	public String text;
	public boolean isRead;
	public Date date;
	public int fk_userId;
	
	public Message(int id, String text, boolean isRead, Date date, int fk_userId) {
		super();
		this.id = id;
		this.text = text;
		this.isRead = isRead;
		this.date = date;
		this.fk_userId = fk_userId;
	}
	
	public Message(){};
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", text=" + text + ", isRead=" + isRead + ", date=" + date + ", fk_userId=" + fk_userId + "]";
	}
	
	

}
