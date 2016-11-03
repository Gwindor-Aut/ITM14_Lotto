package at.fhj.itm.model;

import java.sql.Date;

public class Tipp {

	public int id;
	public String numbers;
	public boolean isQuicktipp;
	public Date date;
	public int fk_userId;
	public int fk_drawId;
	
	public Tipp(int id, String numbers, boolean isQuicktipp, Date date, int fk_userId, int fk_drawId) {
		super();
		this.id = id;
		this.numbers = numbers;
		this.isQuicktipp = isQuicktipp;
		this.date = date;
		this.fk_userId = fk_userId;
		this.fk_drawId = fk_drawId;
	}
	
	public Tipp(){};
	
	
	@Override
	public String toString() {
		return "Tipp [id=" + id + ", numbers=" + numbers + ", isQuicktipp=" + isQuicktipp + ", date=" + date + ", fk_userId=" + fk_userId + ", fk_drawId=" + fk_drawId + "]";
	}
	
	
	
	
}
