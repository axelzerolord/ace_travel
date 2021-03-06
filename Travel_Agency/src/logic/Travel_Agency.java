package logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



class Travel_Agency 
{	
	private static Travel_Agency travel_agency;
	private ArrayList<Client> clients;
	private ArrayList<Route> routes;
	private ArrayList<Trip> trips;
	private ArrayList<Reservations> reservations;
	private ArrayList<Tickets> tickets;
	private ArrayList<Guests> guests; 
	
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
	
	public ArrayList<Reservations> getReservations() {
		return reservations;
	}
	
	public ArrayList<Tickets> getTickets() {
		return tickets;
	}
	
	public ArrayList<Guests> getGuests() {
		return guests;
	}
	void loadclients() throws SQLException
	{
		DatabaseHandler myHandler = new DatabaseHandler();
		ResultSet sqlClients = myHandler.runQuery("Select * from clientes");
		while (sqlClients.next())
		{
			Client newClient = new Client(sqlClients.getInt(1), sqlClients.getInt(2), sqlClients.getInt(3), sqlClients.getInt(4), sqlClients.getString(5), sqlClients.getDate(6), sqlClients.getString(7), sqlClients.getString(8));
			Travel_Agency.getInstances().getClients().add(newClient);
		}
	}
	
	public void loadroutes() throws SQLException
	{
		DatabaseHandler myHandler = new DatabaseHandler();
		ResultSet sqlClients = myHandler.runQuery("Select * from rutas");
		while (sqlClients.next())
		{
			Route newRoute = new Route(sqlClients.getInt(1), sqlClients.getInt(2), sqlClients.getInt(3), sqlClients.getInt(4),sqlClients.getInt(5));
			Travel_Agency.getInstances().getRoutes().add(newRoute);
		}
	}
	
	public void loadtrips() throws SQLException
	{
		DatabaseHandler myHandler = new DatabaseHandler();
		ResultSet sqlClients = myHandler.runQuery("Select * from viajes");
		while (sqlClients.next())
		{
			Trip newTrip = new Trip(sqlClients.getInt(1), sqlClients.getInt(2), sqlClients.getInt(3), sqlClients.getInt(4),sqlClients.getInt(5));
			Travel_Agency.getInstances().getTrips().add(newTrip);
		}
	}
	
	public void loadreservations() throws SQLException
	{
		DatabaseHandler myHandler = new DatabaseHandler();
		ResultSet sqlClients = myHandler.runQuery("Select * from reservaciones");
		while (sqlClients.next())
		{
			Reservations reservations = new Reservations(sqlClients.getInt(1), sqlClients.getInt(2), sqlClients.getInt(3), sqlClients.getDate(4), sqlClients.getDate(5), sqlClients.getInt(6));
			Travel_Agency.getInstances().getReservations().add(reservations);
		}
	}
	
	public void loadtickets() throws SQLException
	{
		DatabaseHandler myHandler = new DatabaseHandler();
		ResultSet sqlClients = myHandler.runQuery("Select * from boletos");
		while (sqlClients.next())
		{
			Tickets tickets = new Tickets(sqlClients.getInt(1), sqlClients.getInt(2), sqlClients.getInt(3), sqlClients.getInt(4), sqlClients.getInt(5), sqlClients.getInt(6),sqlClients.getInt(7),sqlClients.getInt(8));
			Travel_Agency.getInstances().getTickets().add(tickets);
		}
	}
	
	public void loadGuests() throws SQLException
	{
		DatabaseHandler myHandler = new DatabaseHandler();
		ResultSet sqlClients = myHandler.runQuery("Select * from invitados");
		while (sqlClients.next())
		{
			Guests guests = new Guests(sqlClients.getInt(1), sqlClients.getString(2), sqlClients.getString(3), sqlClients.getString(4), sqlClients.getDate(5));
			Travel_Agency.getInstances().getGuests().add(guests);
		}
	}




}
