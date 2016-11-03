package at.fhj.itm.model;

import java.sql.Date;

public class WinningLevel {
	
	public int id;
	public Date date;
	public int six;
	public int five;
	public int four;
	public int three;
	public WinningLevel(int id, Date date, int six, int five, int four, int three) {
		super();
		this.id = id;
		this.date = date;
		this.six = six;
		this.five = five;
		this.four = four;
		this.three = three;
	}
	
	public WinningLevel(){};
	
	
	@Override
	public String toString() {
		return "WinningLevel [id=" + id + ", date=" + date + ", six=" + six + ", five=" + five + ", four=" + four
				+ ", three=" + three + "]";
	}
	
	

}
