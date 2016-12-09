package logic;

public class Trip {
	private int Trip_ID;
	private int Route_ID;
	private int Bus_ID;
	private int Driver_ID;
	private int exit_time;
	
	public Trip(int trip_ID, int route_ID, int bus_ID, int driver_ID,
			int exit_time) {
		super();
		Trip_ID = trip_ID;
		Route_ID = route_ID;
		Bus_ID = bus_ID;
		Driver_ID = driver_ID;
		this.exit_time = exit_time;
	}
	public int getTrip_ID() {
		return Trip_ID;
	}
	public int getRoute_ID() {
		return Route_ID;
	}
	public int getBus_ID() {
		return Bus_ID;
	}
	public int getDriver_ID() {
		return Driver_ID;
	}
	public int getExit_time() {
		return exit_time;
	}
	public void setTrip_ID(int trip_ID) {
		Trip_ID = trip_ID;
	}
	public void setRoute_ID(int route_ID) {
		Route_ID = route_ID;
	}
	public void setBus_ID(int bus_ID) {
		Bus_ID = bus_ID;
	}
	public void setDriver_ID(int driver_ID) {
		Driver_ID = driver_ID;
	}
	public void setExit_time(int exit_time) {
		this.exit_time = exit_time;
	}

	
}
