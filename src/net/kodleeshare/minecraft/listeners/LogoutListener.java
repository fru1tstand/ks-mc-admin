package net.kodleeshare.minecraft.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LogoutListener implements Listener
{
	public LogoutListener()
	{}

	@EventHandler
	public void playerLogout(PlayerQuitEvent e)
	{
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex reload");
	}
}
