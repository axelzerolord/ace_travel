package logic;

public class Tickets {
	private int	ticket_id;
	private int guess_id;
	private int boarding_station;
	private int destiny_station;
	private int row_sit;
	private int column_sit;
	private int tax_cost;
	private int final_price;
	
	
	public Tickets(int ticket_id, int guess_id, int boarding_station,
			int destiny_station, int row_sit, int column_sit, int tax_cost,
			int final_price) {
		super();
		this.ticket_id = ticket_id;
		this.guess_id = guess_id;
		this.boarding_station = boarding_station;
		this.destiny_station = destiny_station;
		this.row_sit = row_sit;
		this.column_sit = column_sit;
		this.tax_cost = tax_cost;
		this.final_price = final_price;
	}
	
	public int getTicket_id() {
		return ticket_id;
	}
	public int getGuess_id() {
		return guess_id;
	}
	public int getBoarding_station() {
		return boarding_station;
	}
	public int getDestiny_station() {
		return destiny_station;
	}
	public int getRow_sit() {
		return row_sit;
	}
	public int getColumn_sit() {
		return column_sit;
	}
	public int getTax_cost() {
		return tax_cost;
	}
	public int getFinal_price() {
		return final_price;
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	public void setGuess_id(int guess_id) {
		this.guess_id = guess_id;
	}
	public void setBoarding_station(int boarding_station) {
		this.boarding_station = boarding_station;
	}
	public void setDestiny_station(int destiny_station) {
		this.destiny_station = destiny_station;
	}
	public void setRow_sit(int row_sit) {
		this.row_sit = row_sit;
	}
	public void setColumn_sit(int column_sit) {
		this.column_sit = column_sit;
	}
	public void setTax_cost(int tax_cost) {
		this.tax_cost = tax_cost;
	}
	public void setFinal_price(int final_price) {
		this.final_price = final_price;
	}
	
	

}
