package logic;

import java.sql.Date;

public class Reservations 
{
	private int reservacion_id;
	private int client_id;	
	private int trip_id;
	private Date reservation_date;
	private Date cancellation_date;
	private int penalty_cost;
	
	public Reservations(int reservacion_id, int client_id, int trip_id,
			Date reservation_date, Date cancellation_date, int penalty_cost) 
	{
		super();
		this.reservacion_id = reservacion_id;
		this.client_id = client_id;
		this.trip_id = trip_id;
		this.reservation_date = reservation_date;
		this.cancellation_date = cancellation_date;
		this.penalty_cost = penalty_cost;
	}
	public int getReservacion_id() {
		return reservacion_id;
	}
	public int getClient_id() {
		return client_id;
	}
	public int getTrip_id() {
		return trip_id;
	}
	public Date getReservation_date() {
		return reservation_date;
	}
	public Date getCancellation_date() {
		return cancellation_date;
	}
	public int getPenalty_cost() {
		return penalty_cost;
	}
	public void setReservacion_id(int reservacion_id) {
		this.reservacion_id = reservacion_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public void setTrip_id(int trip_id) {
		this.trip_id = trip_id;
	}
	public void setReservation_date(Date reservation_date) {
		this.reservation_date = reservation_date;
	}
	public void setCancellation_date(Date cancellation_date) {
		this.cancellation_date = cancellation_date;
	}
	public void setPenalty_cost(int penalty_cost) {
		this.penalty_cost = penalty_cost;
	}
	
	
	
}
