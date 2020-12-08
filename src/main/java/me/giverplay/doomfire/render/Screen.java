package me.giverplay.doomfire.render;

import me.giverplay.doomfire.DoomFire;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitTask;

import java.util.Arrays;

public class Screen
{
  private final World world;

  private final int baseX;
  private final int baseY;
  private final int baseZ;

  private final int width;
  private final int height;

  private final BukkitTask updateTask;
  private final Fire fire;

  private final Material[] pixels;

  public Screen(DoomFire plugin, Location location, int width, int height)
  {
    this.width = width;
    this.height = height;

    this.baseX = location.getBlockX();
    this.baseY = location.getBlockY();
    this.baseZ = location.getBlockZ();

    world = location.getWorld();
    pixels = new Material[this.width * this.height];
    Arrays.fill(pixels, Material.BARRIER);

    fire = new Fire();
    fire.start(this.width, this.height);

    updateTask = Bukkit.getScheduler().runTaskTimer(plugin, Screen.this::draw, 0L, 1L);
  }

  public void draw()
  {
    fire.calculateFirePropagation();
    fire.renderFire(pixels);
    drawOnWorld();
  }

  public void dispose()
  {
    updateTask.cancel();
  }

  private void drawOnWorld()
  {
    for(int x = 0; x < fire.fireWidth; x++)
    {
      for(int y = 0; y < fire.fireHeight; y++)
      {
        Block block = world.getBlockAt(baseX + x, baseY + fire.fireHeight - y, baseZ);
        int index = x + y * fire.fireWidth;

        block.setType(pixels[index]);
      }
    }
  }
}
