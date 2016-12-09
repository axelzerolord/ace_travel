package logic;

import java.time.LocalDate;

public class Client 
{
	private int cliente_id;
	private int vip_lv_id;
	private int trip_id;
	private LocalDate reservation_date;
	private LocalDate cancellation_date;
	
	
	public Client(int cliente_id, int vip_lv_id, int trip_id,
			LocalDate reservation_date, LocalDate cancellation_date) {
		super();
		this.cliente_id = cliente_id;
		this.vip_lv_id = vip_lv_id;
		this.trip_id = trip_id;
		this.reservation_date = reservation_date;
		this.cancellation_date = cancellation_date;
	}
	public int getCliente_id() 
	{
		return cliente_id;
	}
	public int getVip_lv_id() {
		return vip_lv_id;
	}
	public int getTrip_id() {
		return trip_id;
	}
	public LocalDate getReservation_date() {
		return reservation_date;
	}
	public LocalDate getCancellation_date() {
		return cancellation_date;
	}
	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}
	public void setVip_lv_id(int vip_lv_id) {
		this.vip_lv_id = vip_lv_id;
	}
	public void setTrip_id(int trip_id) {
		this.trip_id = trip_id;
	}
	public void setReservation_date(LocalDate reservation_date) {
		this.reservation_date = reservation_date;
	}
	public void setCancellation_date(LocalDate cancellation_date) {
		this.cancellation_date = cancellation_date;
	}
	
	
}
