package logic;

public class Route 
{
	private int route_ID;
	private int Origing_station;
	private int destination_station;
	private int route_type_id;

	public Route(int route_ID, int origing_station, int destination_station,int route_type_id) 
	{
		super();
		this.route_ID = route_ID;
		Origing_station = origing_station;
		this.destination_station = destination_station;
		this.route_type_id = route_type_id;
	}
	public int getRoute_ID() 
	{
		return route_ID;
	}
	public int getOriging_station() 
	{
		return Origing_station;
	}
	public int getDestination_station() 
	{
		return destination_station;
	}
	public int getRoute_type_id() 
	{
		return route_type_id;
	}
	public void setRoute_ID(int route_ID) 
	{
		this.route_ID = route_ID;
	}
	public void setOriging_station(int origing_station) 
	{
		Origing_station = origing_station;
	}
	public void setDestination_station(int destination_station) 
	{
		this.destination_station = destination_station;
	}
	public void setRoute_type_id(int route_type_id) 
	{
		this.route_type_id = route_type_id;
	}
	
}
