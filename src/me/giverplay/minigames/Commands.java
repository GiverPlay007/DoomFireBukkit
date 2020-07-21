package me.giverplay.minigames;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(!(sender instanceof Player))
		{
			sender.sendMessage("§aComando para jogadores...");
			return true;
		}
		
		Player player = (Player) sender;
		Location loc = player.getLocation();
		
		if(args.length < 2)
		{
			player.sendMessage("§cEspecifique a resolução");
			return true;
		}
		
		int w, h;
		
		try
		{
			w = Integer.parseInt(args[0]);
			h = Integer.parseInt(args[1]);
		}
		catch(NumberFormatException e)
		{
			player.sendMessage("§cResolução deve ser em números inteiros...");
			return true;
		}
		
		Screen screen = new Screen(loc, w, h);
		screen.createBounds();
		System.out.println("Tudo ok");
		
		return false;
	}
}
