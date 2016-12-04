package logic;

import java.sql.*;
public class DatabaseCode {
	
public static void main(String[] args) {
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"mrwhite","IamZero1995");
			Statement st = con.createStatement();
			//Insert
			String insert = "Insert into dias " + "VALUES ((select count(dia_ID) from dias),'Lunes')";
			st.executeUpdate(insert);
			System.out.println("Insertado");
			String sql = "select * from dias";
			
			//Read
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+ " " + rs.getString(2));
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
}
