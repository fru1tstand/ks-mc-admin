package net.kodleeshare.minecraft.other;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class CommandHandler implements Runnable
{
	private PlayerCommandPreprocessEvent	event;

	public CommandHandler(PlayerCommandPreprocessEvent e)
	{
		this.event = e;
	}

	@Override
	public void run()
	{

		String[] args = this.event.getMessage().trim().split(" ");

		PermissionUser user = PermissionsEx.getUser(this.event.getPlayer());

		switch (args[0].toLowerCase())
		{
			case "/ban": // Syntax: /ban <user> <length> <reason>
				if (!user.has("ks.ban"))
				{
					Message.send(this.event.getPlayer(), Message.PERMISSION_DENIED_MINADMIN);
					return;
				}

				if (args.length <= 2)
				{
					this.event.getPlayer().sendMessage(ChatColor.GRAY
							+ "Usage: /ban [user] [length] <reason>");
					this.event.getPlayer().sendMessage(ChatColor.GRAY
							+ "Length of 0 or less is a permanent ban.");
					return;
				}

				// check for user
				Player igPlayer = Bukkit.getPlayer(args[1]);
				if (igPlayer == null)
				{
					Message.send(this.event.getPlayer(), Message.NOTFOUND_USER, "Given: "
							+ args[1]);
					return;
				}

				// check for valid length
				int iExpires = 0;
				try
				{
					iExpires = Integer.parseInt(args[2])
							* 60
							+ Math.round(System.currentTimeMillis() / 1000);
				} catch (NumberFormatException nfe)
				{
					Message.send(this.event.getPlayer(), Message.NAN, "Given: "
							+ args[2]);
					return;
				}
				if (iExpires < 1)
					iExpires = 2147483647;

				PermissionUser pPlayer = PermissionsEx.getUser(igPlayer);

				StringBuffer reason = new StringBuffer();
				if (args.length > 3)
				{
					for (int i = 3; i < args.length; i++)
						reason.append(args[i]
								+ " ");
				}

				pPlayer.setGroups(new String[] { "banned" });
				igPlayer.sendMessage(ChatColor.RED
						+ "You've been banned from this server. Please visit http://kodleeshare.net/minecraft/?ref=banned for more details.");

				Entry.add(Entry.BAN, iExpires, reason.toString(), igPlayer);

				break;
			case "/kick": // Syntax: /kick <user> <reason>
				if (!user.has("ks.kick"))
				{
					Message.send(this.event.getPlayer(), Message.PERMISSION_DENIED_MINADMIN);
					return;
				}
				if (args.length <= 1)
				{
					this.event.getPlayer().sendMessage(ChatColor.GRAY
							+ "Usage: /kick [user] <reason>");
					return;
				}
				break;
			case "/help":
				break;
		}
	}

}
