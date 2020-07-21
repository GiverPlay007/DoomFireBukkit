package me.giverplay.minigames;

import java.awt.image.BufferedImage;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

public class Screen
{
	private World world;
	
	private int width;
	private int height;
	private int bx;
	private int by;
	private int x1;
	private int y1;
	private int z1;
	
	public Screen(Location start, int width, int height)
	{
		this.world = start.getWorld();
		this.width = width;
		this.height = height;
		this.x1 = start.getBlockX() + 5;
		this.y1 = start.getBlockY() + 5;
		this.z1 = start.getBlockZ();
		bx = x1 - 1;
		by = y1 + 1;
		
		createBounds();
	}
	
	public void createBounds()
	{
		for(int xx = bx; xx < x1 + width + 1; xx++)
		{
			world.getBlockAt(xx, by, z1).setType(Material.BEDROCK);
			world.getBlockAt(xx, by + height + 1, z1).setType(Material.BEDROCK);
		}
		
		for(int yy = by; yy < by + height + 1; by++)
		{
			world.getBlockAt(bx, yy, z1).setType(Material.BEDROCK);
			world.getBlockAt(x1 + width + 1, yy, z1).setType(Material.BEDROCK);
		}
	}
	
	public void draw(BufferedImage image)
	{
		
	}
}
