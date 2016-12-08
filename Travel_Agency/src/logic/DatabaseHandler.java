package logic;

import java.sql.*;


public class DatabaseHandler
{
	private static ResultSet queryResult;
	private static int updateResult;
	private static Connection con;
	private static Statement st;
	
	public static ResultSet getMyResult() {
		return queryResult;
	}
	public static int getResult() {
		return updateResult;
	}
	
	public ResultSet runQuery(String query)
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "mrwhite","IamZero1995");
			st = con.createStatement();
			queryResult = st.executeQuery(query);
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return queryResult;
	}
	public void closeConnection()
	{
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int runUpdate(String update)
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "mrwhite","IamZero1995");
			Statement st = con.createStatement();
			updateResult=st.executeUpdate(update);
			con.close();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return updateResult;
	}
}
