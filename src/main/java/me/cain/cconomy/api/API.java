package main.java.me.cain.cconomy.api;

import main.java.me.cain.cconomy.cConomy;

import org.bukkit.entity.Player;

public class API
{
	cConomy plugin;
	
	public API(cConomy plugin) {
		cConomy.plugin = plugin;
	}
	
	public boolean hasExactMoney(Integer amount, Player p) {
		int balance = cConomy.plugin.getConfig().getInt("players." + p.getName() + ".balance"); // Get how much that player currently has
		if(amount == balance) { // Check to see if the amount is the same as the player balance
			return true; // Return true, required for plugins to read the API.
		} else {
			return false; // Return false, for any else {'s in the people using the API.
		}
	}
	
	public boolean hasNotEnoughMoney(Integer amount, Player p) {
		int balance = cConomy.plugin.getConfig().getInt("players." + p.getName() + ".balance"); // Get how much that player currently has
		if(balance < amount) { // Check to see if the amount is below the player balance
			return true; // Return true.
		} else {
			return false; // Return false.
		}
	}
	
	public boolean hasAboveMoney(Integer amount, Player p) {
		int balance = cConomy.plugin.getConfig().getInt("players." + p.getName() + ".balance"); // Get how much that player has
		if(balance > amount) { // I'll stop from here, comments are getting boring.
			return true;
		} else {
			return false;
		}
	}
	
	
}
