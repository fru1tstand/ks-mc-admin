package net.kodleeshare.minecraft.listeners;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.kodleeshare.mysql;
import net.kodleeshare.minecraft.KSAdminPlugin;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class LoginListener implements Listener
{
	public LoginListener() {}
	
	@EventHandler
	public void playerLogin(PlayerLoginEvent event)
	{
		PermissionUser p = PermissionsEx.getUser(event.getPlayer());
		
		for (String s : p.getGroupsNames())
		{
			KSAdminPlugin.log("Player " + event.getPlayer().getName() + " is in group: " + s);
			
			switch (s)
			{
				case "banned": // check for unbanning
					KSAdminPlugin.log("Ban check");
					Connection conn = mysql.getMysql();
					Statement query = null;
					ResultSet result = null;
					try
					{
						query = conn.createStatement();
						result = query.executeQuery("SELECT expires FROM ks_entries WHERE type = 2 AND player_id = (SELECT player_id FROM hawk_players WHERE player = '" + event.getPlayer().getName() + "') ORDER BY id DESC LIMIT 1");
						
						while (result.next())
						{
							KSAdminPlugin.log("Time: " + System.currentTimeMillis());
							if ((System.currentTimeMillis() / 1000) > Integer.parseInt(result.getString("expires")))
							{
								event.getPlayer().sendMessage(Color.GRAY + "Your time is up! You've been automatically unbanned from the server and are a regular member again.");
								p.setGroups(new String[] { "member" });
							}
						}
					} catch (SQLException e)
					{
						Bukkit.getLogger().severe(e.toString());
					} finally
					{
						if (result != null)
							try
							{
								result.close();
							} catch (SQLException e)
							{
								e.printStackTrace();
							}
						if (query != null)
							try
							{
								query.close();
							} catch (SQLException e)
							{
								e.printStackTrace();
							}
					}
				break;
				case "visitor":
					event.getPlayer().sendMessage(Color.GRAY + "Welcome to the KodleeShare server!");
					event.getPlayer().sendMessage(Color.GRAY + "Please visit http://kodleeshare.net/mc/");
				break;
			}
		}
	}
}
