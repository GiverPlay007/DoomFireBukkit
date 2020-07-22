package me.giverplay.minigames.graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

import me.giverplay.minigames.Game;

public class Screen
{
	private BufferedImage buffer;
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
		this.bx = this.x1 - 1;
		this.by = this.y1 - 1;
		
		buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		createBounds();
		
		BufferedImage temp;
		
		try
		{
			temp = ImageIO.read(new File(Game.getInstance().getDataFolder(), "ezio.png"));
		}
		catch(IOException e)
		{
			System.out.println("ERRO");
			return;
		}
		
		draw(temp);
	}
	
	public void createBounds()
	{
		for(int xx = bx; xx < x1 + width + 1; xx++)
		{
			world.getBlockAt(xx, by, z1).setType(Material.BEDROCK);
			world.getBlockAt(xx, by + height + 1, z1).setType(Material.BEDROCK);
		}
		
		for(int yy = by; yy < y1 + height + 1; yy++)
		{
			world.getBlockAt(bx, yy, z1).setType(Material.BEDROCK);
			world.getBlockAt(bx + width + 1, yy, z1).setType(Material.BEDROCK);
		}
	}
	
	public void draw(BufferedImage image)
	{
		buffer.getGraphics().drawImage(image, 0, 0, width, height, null);
	}
	
	public void render()
	{
		for(int xx = 0; xx < width; xx++)
		{
			for(int yy = 0; yy < height; yy++)
			{
				int rgb = buffer.getRGB(xx, yy);
				int r, g, b;
				
				r = (rgb >> 16) & 0xFF;
				g = (rgb >> 8) & 0xFF;
				b = rgb & 0xFF;
				
				Colors c = Colors.valueOf("C_" + r + "_" + g + "_" + b);
				
				world.getBlockAt(x1 + xx, y1 + height - yy, z1)
					   .setType(c != null ? c.getMaterial() : Material.AIR);
			}
		}
	}
}
