package net.kodleeshare.minecraft;

import net.kodleeshare.minecraft.listeners.LoginListener;
import net.kodleeshare.minecraft.listeners.LogoutListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class KSAdminPlugin extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		Bukkit.getLogger().info("[KodleeShare Admin Plugin] Registering event handlers...");
		Bukkit.getPluginManager().registerEvents(new LoginListener(), this);
		Bukkit.getPluginManager().registerEvents(new LogoutListener(), this);

	}

	@Override
	public void onDisable()
	{

	}
}
