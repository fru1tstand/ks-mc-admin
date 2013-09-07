package net.kodleeshare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mysql
{
	private static Connection	conn	= null;

	public static Connection getMysql()
	{
		if (mysql.conn == null)
		{
			try
			{
				mysql.conn = DriverManager.getConnection("jdbc:mysql://192.168.1.10/minecraft?user=minecraft&password=itSMIN3cr@Ftttsa");
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return mysql.conn;
	}

	public static void releaseMysql()
	{
		if (mysql.conn != null)
		{
			try
			{
				mysql.conn.close();
			} catch (SQLException e)
			{}
		}
	}

	public mysql()
	{} // uninstanatied cuz... well.. static classes ftw
}
