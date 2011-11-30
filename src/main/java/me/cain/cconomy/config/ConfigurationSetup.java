package main.java.me.cain.cconomy.config;

import main.java.me.cain.cconomy.cConomy;

public class ConfigurationSetup
{
	static cConomy plugin;
	
	public static void load()
	{
		if(plugin.getConfig().get("settings.starteramount") == null) {
			plugin.getConfig().set("settings.starteramount", 10);
		}
		plugin.saveConfig();
	}
}
