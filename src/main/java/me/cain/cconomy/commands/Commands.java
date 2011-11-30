package main.java.me.cain.cconomy.commands;

import main.java.me.cain.cconomy.cConomy;
import main.java.me.cain.cconomy.utils.ChatUtility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor
{
	static cConomy plugin;
	
	public boolean onCommand(CommandSender s, Command c, String l, String [] args)
	{
		if(c.getName().equalsIgnoreCase("money")) {
			if(args.length < 1) {
				if(s instanceof Player) {
					int amount = cConomy.plugin.getConfig().getInt("players." + s.getName() + ".balance");
					ChatUtility.Message((Player) s, "Your current balance: " + ChatColor.WHITE + amount);
				} else {
					ChatUtility.Console("You must be in-game to use cConomy commands.");
				}
			}
		}
		if(s instanceof Player) {
			if(c.getName().equalsIgnoreCase("pay")) {
				if(args.length < 2) {
						ChatUtility.Message((Player) s, "/pay [player] [amount]");
					} else {
						Player target = Bukkit.getServer().getPlayer(args[0]);
						if(target != null) {
						int balance = cConomy.plugin.getConfig().getInt("players." + s.getName() + ".balance");
						int player = cConomy.plugin.getConfig().getInt("players." + target.getName() + ".balance");
						int input = Integer.parseInt(args[1]);
						if(input < balance) {
							String sPlayer = cConomy.plugin.getConfig().getString("players." + target.getName() + ".balance");
							String dPlayer = cConomy.plugin.getConfig().getString("players." + s.getName() + ".balance");
							int final1 = player + input;
							int final2 = balance - input;
							cConomy.plugin.getConfig().set(sPlayer, final1);
							cConomy.plugin.getConfig().set(dPlayer, final2);
							ChatUtility.Message(target, "You have been given " + input + " by " + s.getName());
							ChatUtility.Message((Player) s, "You have given " + target.getName() + " " + input);
							cConomy.plugin.saveConfig();
						} else {
							ChatUtility.Denied((Player) s, "You do not have enough funds!");
						}
					} else {
						ChatUtility.Denied((Player) s, "This player is not online.");
					}
				}
			}
		} else {
			ChatUtility.Console("You can only use these commands in-game!");
		}
		return false;
	}

}
