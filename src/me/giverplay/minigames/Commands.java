package me.giverplay.minigames;

import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;

import me.giverplay.minigames.graphics.Screen;

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
		
		if(cmd.getName().equalsIgnoreCase("setup"))
		{
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
		}
		
		if(cmd.getName().equalsIgnoreCase("setcolor"))
		{
			if(args.length < 3)
			{
				player.sendMessage("Especifique o R G B");
				return true;
			}
			
			int r, g, b;
			
			try
			{
				r = Integer.parseInt(args[0]);
				g = Integer.parseInt(args[1]);
				b = Integer.parseInt(args[2]);
			}
			catch (NumberFormatException e)
			{
				player.sendMessage("Inteiros apenas");
				return true;
			}
			
			Sheep s = (Sheep) loc.getWorld().spawnEntity(loc, EntityType.SHEEP);
			s.setColor(DyeColor.getByColor(Color.fromRGB(r, g, b)));
		}
		
		return false;
	}
}
