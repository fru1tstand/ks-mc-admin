package net.kodleeshare.minecraft.other;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import net.kodleeshare.mysql;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public enum Entry
{
	REGISTER(0),
	KICK(1),
	BAN(2);

	private Entry(int i)
	{
		this.i = i;
	}

	private int	i;

	public int get()
	{
		return this.i;
	}

	public static void add(Entry entry, int expires, String reason, Player player)
	{
		Connection conn = mysql.getMysql();

		Statement stmt = null;

		try
		{
			stmt = conn.createStatement();
			stmt.execute("INSERT INTO ks_entries (player_id, type, date, expires, value) VALUES ((SELECT player_id FROM hawk_players WHERE player = '"
					+ player.getName()
					+ "'), "
					+ entry.get()
					+ ", "
					+ Math.round(System.currentTimeMillis() / 1000)
					+ ", "
					+ expires
					+ ", '"
					+ reason
					+ "')");
		} catch (SQLException e)
		{
			Bukkit.getLogger().severe(e.toString());
		}

	}
}
