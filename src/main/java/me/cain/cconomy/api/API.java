package main.java.me.cain.cconomy.api;

import main.java.me.cain.cconomy.cConomy;

import org.bukkit.entity.Player;

public class API
{
	public boolean hasExactMoney(Integer amount, Player p) {
		int balance = cConomy.plugin.getConfig().getInt("players." + p.getName() + ".balance"); // Get how much that player currently has
		if(amount == balance) { // Check to see if the amount is the same as the player balance
			return true; // Return true, required for plugins to read the API.
		} else {
			return false; // Return false, for any else {'s in the people using the API.
		}
	}
}
