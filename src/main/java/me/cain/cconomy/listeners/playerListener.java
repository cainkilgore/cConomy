package main.java.me.cain.cconomy.listeners;

import main.java.me.cain.cconomy.cConomy;

import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerLoginEvent;

public class playerListener extends PlayerListener
{
	//static plugin = cConomy.plugin.getConfig();
	
	public void onPlayerLogin(PlayerLoginEvent e)
	{
		String PLAYERNAME = e.getPlayer().getName();
		int amount = cConomy.plugin.getConfig().getInt("settings.starteramount");
		
		if(cConomy.plugin.getConfig().get("players." + PLAYERNAME) == null) {
			cConomy.plugin.getConfig().set("players." + PLAYERNAME, true);
			cConomy.plugin.getConfig().set("players." + PLAYERNAME + ".balance", amount);
			cConomy.plugin.saveConfig();
		}
		return;
	}

}
