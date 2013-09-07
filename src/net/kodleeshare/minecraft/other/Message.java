package net.kodleeshare.minecraft.other;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public enum Message
{
	LOGIN_BANNED(ChatColor.WHITE
			+ "You are currently Banned. Please visit "
			+ ChatColor.BLUE
			+ "http://kodleeshare.net/minecraft/?ref=ban"
			+ ChatColor.WHITE
			+ " for more details or to appeal."),
	LOGIN_MEMBER(ChatColor.WHITE
			+ "Welcome back! Remember to "),

	NAN(ChatColor.GRAY
			+ "A number was expected"),
	NOTFOUND_USER(ChatColor.GRAY
			+ "The user requested was not found"),
	PERMISSION_DENIED_MINADMIN(ChatColor.RED
			+ "Sorreh. You must be an admin to do this");

	private Message(String s)
	{
		this.m = s;
	}

	private String	m;

	public String get()
	{
		return this.m;
	}

	public static void send(Player player, Message message)
	{
		player.sendMessage(message.get());
	}

	public static void send(Player player, Message message, String append)
	{
		player.sendMessage(message.get()
				+ " ("
				+ append
				+ ")");
	}
}
