package net.kodleeshare.minecraft.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LogoutListener implements Listener
{
	public LogoutListener()
	{}

	@EventHandler
	public void playerLogout(PlayerQuitEvent e)
	{}
}
