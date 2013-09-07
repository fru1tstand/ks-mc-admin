package net.kodleeshare.minecraft.listeners;

import java.util.Arrays;

import net.kodleeshare.minecraft.other.CommandHandler;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener
{
	public CommandListener()
	{}

	@EventHandler
	public void commandHandler(final PlayerCommandPreprocessEvent e)
	{
		if (e.getMessage().charAt(0) != '/')
			return;

		String[] args = e.getMessage().trim().split(" ");
		if (args.length == 0)
			return;

		String[] values = { "/ban", "/kick", "/help" };
		if (!Arrays.asList(values).contains(args[0].toLowerCase()))
			return;

		e.setCancelled(true);
		(new Thread(new CommandHandler(e))).start();
	}

}
