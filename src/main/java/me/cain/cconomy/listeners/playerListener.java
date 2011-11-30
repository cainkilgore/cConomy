package main.java.me.cain.cconomy.listeners;

import main.java.me.cain.cconomy.cConomy;

import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerLoginEvent;

public class playerListener extends PlayerListener
{
	cConomy plugin;
	
	public void onPlayerLogin(PlayerLoginEvent e)
	{
		String PLAYERNAME = e.getPlayer().getName();
		int amount = plugin.getConfig().getInt("settings.starteramount");
		
		if(plugin.getConfig().get("players." + PLAYERNAME) == null) {
			plugin.getConfig().set("players." + PLAYERNAME, true);
			plugin.getConfig().set("players." + PLAYERNAME + ".balance", amount);
			plugin.saveConfig();
		}
		return;
	}

}
