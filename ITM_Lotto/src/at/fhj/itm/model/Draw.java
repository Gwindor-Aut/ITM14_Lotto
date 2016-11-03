package at.fhj.itm.model;

import java.sql.Date;

public class Draw {

	public int id;
	public int pot;
	public String numbers;
	public Date date;
	public int jackpotLevel;
	public int priceOfTipp;
	public int taxRate;
	public int ownerRate;
	public int fk_winningLevelId;
	
	public Draw(int id, int pot, String numbers, Date date, int jackpotLevel, int priceOfTipp, int taxRate,
			int ownerRate, int fk_winningLevelId) {
		super();
		this.id = id;
		this.pot = pot;
		this.numbers = numbers;
		this.date = date;
		this.jackpotLevel = jackpotLevel;
		this.priceOfTipp = priceOfTipp;
		this.taxRate = taxRate;
		this.ownerRate = ownerRate;
		this.fk_winningLevelId = fk_winningLevelId;
	}
	
	public Draw(){};
	
	@Override
	public String toString() {
		return "Draw [id=" + id + ", pot=" + pot + ", numbers=" + numbers + ", date=" + date + ", jackpotLevel="
				+ jackpotLevel + ", priceOfTipp=" + priceOfTipp + ", taxRate=" + taxRate + ", ownerRate=" + ownerRate
				+ ", fk_winningLevelId" + fk_winningLevelId + "]";
	}
	
	
}
