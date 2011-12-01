package main.java.me.cain.cconomy;

import main.java.me.cain.cconomy.commands.Commands;
import main.java.me.cain.cconomy.config.ConfigurationSetup;
import main.java.me.cain.cconomy.listeners.playerListener;
import main.java.me.cain.cconomy.utils.ChatUtility;

import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class cConomy extends JavaPlugin
{
	public static Configuration config;
	PluginManager pm = Bukkit.getServer().getPluginManager();
	public static cConomy plugin;
	
	public void onEnable()
	{
		ConfigurationSetup.load();
		pm.registerEvent(Type.PLAYER_LOGIN, new playerListener(plugin), Priority.Normal, this);
		getServer().getPluginCommand("money").setExecutor(new Commands(plugin));
		getServer().getPluginCommand("pay").setExecutor(new Commands(plugin));
		getServer().getPluginCommand("startermoney").setExecutor(new Commands(plugin));
		getServer().getPluginCommand("createaccount").setExecutor(new Commands(plugin));
		ChatUtility.Console("cConomy has been enabled successfully!");
		plugin = this;
	}
	
	public void onDisable()
	{
		ChatUtility.Console("cConomy has been disabled successfully!");
	}

}
