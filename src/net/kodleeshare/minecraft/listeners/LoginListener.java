package net.kodleeshare.minecraft.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class LoginListener implements Listener
{
	public LoginListener()
	{}

	@EventHandler
	public void playerLogin(PlayerLoginEvent event)
	{
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex reload");
	}
}
