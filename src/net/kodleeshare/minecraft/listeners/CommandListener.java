package net.kodleeshare.minecraft.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class CommandListener implements Listener
{
	public CommandListener()
	{}

	@EventHandler
	public void commandHandler(final AsyncPlayerChatEvent e)
	{
		String[] args = e.getMessage().split(" ");
		if (args[0] == null)
			return;
		switch (args[0].toLowerCase())
		{
			case "/ban":
				e.setCancelled(true);
				break;
			case "/kick":
				e.setCancelled(true);
				break;
			case "/register":
				e.setCancelled(true);
				break;
			case "/registeruser":
				e.setCancelled(true);

				break;
		}
	}
}
