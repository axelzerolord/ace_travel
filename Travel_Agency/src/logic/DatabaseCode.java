package logic;

import java.sql.*;

public class DatabaseCode {
	
public static void main(String[] args) {
		
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
				"system","admin");
		Statement st = con.createStatement();
		String sql = "select * from Persona";
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
			System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  "+rs.getLong(3));
		}
		
		System.out.println("Insertando a Joel Zapata...");
		String insert = "Insert into Persona " + "VALUES (10,'Joel',8092213454,'Mas vago')";
		st.executeUpdate(insert);
		System.out.println("Insertado");
		con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}

	}

}
