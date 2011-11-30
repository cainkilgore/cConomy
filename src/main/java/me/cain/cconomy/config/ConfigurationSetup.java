package main.java.me.cain.cconomy.config;

import main.java.me.cain.cconomy.cConomy;

public class ConfigurationSetup
{
	public static void load()
	{
		if(cConomy.plugin.getConfig().get("settings.starteramount") == null) {
			cConomy.plugin.getConfig().set("settings.starteramount", 10);
		}
		cConomy.plugin.saveConfig();
	}
}
