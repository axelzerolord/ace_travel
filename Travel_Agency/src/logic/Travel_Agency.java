package logic;

import java.util.ArrayList;



class Travel_Agency 
{	
	private static Travel_Agency travel_agency;
	private ArrayList<Client> clients;
	private ArrayList<Route> routes;
	private ArrayList<Trip> trips;
	
	
	public static Travel_Agency getInstances()
	{
		if(travel_agency == null)
		{
		  travel_agency = new Travel_Agency();			
		}
		return travel_agency;
	}
	
	public Travel_Agency()
	{
		super();
		this.clients = new ArrayList<Client>();
		this.routes = new ArrayList<Route>();
		this.trips = new ArrayList<Trip>();
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public ArrayList<Route> getRoutes() {
		return routes;
	}

	public ArrayList<Trip> getTrips() {
		return trips;
	}

}
