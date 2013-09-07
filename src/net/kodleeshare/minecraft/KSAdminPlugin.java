package net.kodleeshare.minecraft;

import net.kodleeshare.mysql;
import net.kodleeshare.minecraft.listeners.CommandListener;
import net.kodleeshare.minecraft.listeners.LoginListener;
import net.kodleeshare.minecraft.listeners.LogoutListener;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class KSAdminPlugin extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		KSAdminPlugin.log("Checking for PermissionsEx");
		if (Bukkit.getPluginManager().isPluginEnabled("PermissionsEx"))
		{
			KSAdminPlugin.log("Registering event handlers...");
			Bukkit.getPluginManager().registerEvents(new LoginListener(), this);
			Bukkit.getPluginManager().registerEvents(new LogoutListener(), this);
			Bukkit.getPluginManager().registerEvents(new CommandListener(), this);
		} else
		{
			Bukkit.getLogger().severe("PEX Not detected...");
		}
	}
	
	@Override
	public void onDisable()
	{
		mysql.releaseMysql();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		switch (cmd.getName().toLowerCase())
		{
			case "help":
			break;
			case "setlogin":
			
			break;
		}
		return true;
	}
	
	public static void log(String s)
	{
		Bukkit.getLogger().info("[KodleeShare Admin Plugin] " + s);
	}
}
