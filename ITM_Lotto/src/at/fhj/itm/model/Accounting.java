package at.fhj.itm.model;

import java.sql.Date;

public class Accounting {
	
	public int id;
	public double balance;
	public double diffBalance;
	public String description;
	public Date date;
	public int fk_userId;
	
	public Accounting(int id, double balance, double diffBalance, String description, Date date, int fk_userId) {
		super();
		this.id = id;
		this.balance = balance;
		this.diffBalance = diffBalance;
		this.description = description;
		this.date = date;
		this.fk_userId = fk_userId;
	}
	
	public Accounting(){};
	
	@Override
	public String toString() {
		return "Accounting [id=" + id + ", balance=" + balance + ", diffBalance=" + diffBalance + ", description="
				+ description + ", date=" + date + ", fk_userId=" + fk_userId +"]";
	}
	
	
	

}
