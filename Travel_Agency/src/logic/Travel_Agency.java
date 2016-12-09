package logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.tracing.dtrace.DependencyClass;



public class Travel_Agency 
{	
	private static Travel_Agency travel_agency;
	private ArrayList<Client> clients;
	private ArrayList<Route> routes;
	private ArrayList<Trip> trips;
	private ArrayList<Reservations> reservations;
	private ArrayList<Tickets> tickets;
	private ArrayList<Guests> guests; 
	private ArrayList<Station> stations;
	
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
		this.reservations = new ArrayList<Reservations>();
		this.tickets = new ArrayList<Tickets>();
		this.guests   = new ArrayList<Guests>();
		this.stations = new ArrayList<Station>();
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
	
	public ArrayList<Station> getStations() {
		return stations;
	}

	public void loadclients() throws SQLException
	{
		DatabaseHandler myHandler = new DatabaseHandler();
		ResultSet sqlClients = myHandler.runQuery("Select * from clientes order by cliente_id asc");
		while (sqlClients.next())
		{
			Client newClient = new Client(sqlClients.getInt(1), sqlClients.getInt(2), sqlClients.getInt(3), sqlClients.getInt(4), sqlClients.getString(5), sqlClients.getDate(6), sqlClients.getString(7), sqlClients.getString(8));
			Travel_Agency.getInstances().getClients().add(newClient);
		}
		myHandler.closeConnection();
	}
	
	public void loadroutes() throws SQLException
	{
		DatabaseHandler myHandler = new DatabaseHandler();
		ResultSet sqlClients = myHandler.runQuery("Select * from rutas order by ruta_id asc");
		while (sqlClients.next())
		{
			Route newRoute = new Route(sqlClients.getInt(1), sqlClients.getInt(2), sqlClients.getInt(3), sqlClients.getInt(4),sqlClients.getInt(5));
			Travel_Agency.getInstances().getRoutes().add(newRoute);
		}
		myHandler.closeConnection();
	}
	
	public void loadtrips() throws SQLException
	{
		DatabaseHandler myHandler = new DatabaseHandler();
		ResultSet sqlClients = myHandler.runQuery("Select * from viajes order by viaje_id asc");
		while (sqlClients.next())
		{
			Trip newTrip = new Trip(sqlClients.getInt(1), sqlClients.getInt(2), sqlClients.getInt(3), sqlClients.getInt(4),sqlClients.getInt(5));
			Travel_Agency.getInstances().getTrips().add(newTrip);
		}
		myHandler.closeConnection();
	}
	
	public void loadreservations() throws SQLException
	{
		DatabaseHandler myHandler = new DatabaseHandler();
		ResultSet sqlClients = myHandler.runQuery("Select * from reservaciones order by reservacion_id asc");
		while (sqlClients.next())
		{
			Reservations reservations = new Reservations(sqlClients.getInt(1), sqlClients.getInt(2), sqlClients.getInt(3), sqlClients.getDate(4), sqlClients.getDate(5), sqlClients.getInt(6));
			Travel_Agency.getInstances().getReservations().add(reservations);
		}
		myHandler.closeConnection();
	}
	
	public void loadtickets() throws SQLException
	{
		DatabaseHandler myHandler = new DatabaseHandler();
		ResultSet sqlClients = myHandler.runQuery("Select * from boletos order by boleto_id asc");
		while (sqlClients.next())
		{
			Tickets tickets = new Tickets(sqlClients.getInt(1), sqlClients.getInt(2), sqlClients.getInt(3), sqlClients.getInt(4), sqlClients.getInt(5), sqlClients.getInt(6),sqlClients.getInt(7),sqlClients.getInt(8));
			Travel_Agency.getInstances().getTickets().add(tickets);
		}
		myHandler.closeConnection();
	}
	
	public void loadGuests() throws SQLException
	{
		DatabaseHandler myHandler = new DatabaseHandler();
		ResultSet sqlClients = myHandler.runQuery("Select * from invitados order by invitado_id asc");
		while (sqlClients.next())
		{
			Guests guests = new Guests(sqlClients.getInt(1), sqlClients.getString(2), sqlClients.getString(3), sqlClients.getString(4), sqlClients.getDate(5));
			Travel_Agency.getInstances().getGuests().add(guests);
		}
		myHandler.closeConnection();
	}
	
	public void loadstations() throws SQLException
	{
		DatabaseHandler myHandler = new DatabaseHandler();
		ResultSet sqlClients = myHandler.runQuery("Select * from estaciones order by estacion_id asc");
		while (sqlClients.next())
		{
			Station station = new Station(sqlClients.getInt(1),sqlClients.getInt(2), sqlClients.getString(3));
			Travel_Agency.getInstances().getStations().add(station);
		}
		myHandler.closeConnection();
	}
	
	public void LoadEverything()
	{
		try {
			loadclients();
			loadGuests();
			loadreservations();
			loadroutes();
			loadtickets();
			loadtrips();
			loadstations();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Client findbyID(int id)
	{
		for(Client auxClient: Travel_Agency.getInstances().getClients())
		{
			if(auxClient.getCliente_id()==id)
			{
				return auxClient;
			}
		}
		return null;
	}
	public Trip findTripByID(int id)
	{
		for(Trip auxTrip: Travel_Agency.getInstances().getTrips())
		{
			if(auxTrip.getTrip_ID()==id)
			{
				return auxTrip;
			}
		}
		return null;
	}
	
	public Route findRouteByID(int id)
	{
		for(Route auxRoute: Travel_Agency.getInstances().getRoutes())
		{
			if(auxRoute.getRoute_ID()==id)
			{
				return auxRoute;
			}
		}
		return null;
	}
	
	public Reservations findReservationByID(int id)
	{
		for(Reservations auxReservations: Travel_Agency.getInstances().getReservations())
		{
			if(auxReservations.getReservacion_id()==id)
			{
				return auxReservations;
			}
		}
		return null;
	}
	
}
