package me.giverplay.minigames;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Game extends JavaPlugin
{
	private static Game instance;
	
	private String prefix = ChatColor.AQUA + "[MiniGames] ";
	
	@Override
	public void onEnable()
	{
		instance = this;
		
		sout(ChatColor.GREEN + "Habilitando plugin");
		
		getCommand("setup").setExecutor(new Commands());
		
		saveResource("ezio.png", false);
	}
	
	@Override
	public void onDisable()
	{
		sout("Desabilitando plugin");
	}
	
	public void sout(String msg)
	{
		Bukkit.getConsoleSender().sendMessage(prefix + msg);
	}
	
	public static Game getInstance()
	{
		return instance;
	}
}
