package main.java.me.cain.cconomy.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatUtility
{
	public static void Console(String message)
	{
		System.out.println("[cConomy] " + message);
	}
	
	public static void Message(Player p, String message)
	{
		p.sendMessage(ChatColor.GREEN + message);
	}
	
	public static void Denied(Player p, String message)
	{
		p.sendMessage(ChatColor.RED + message);
	}
	
	public static void Message(CommandSender p, String message)
	{
		p.sendMessage(ChatColor.GREEN + message);
	}
}
