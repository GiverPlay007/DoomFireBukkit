package me.giverplay.doomfire;

import me.giverplay.doomfire.render.Screen;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public final class DoomFire extends JavaPlugin
{
  private Screen screen;

  @Override
  public void onEnable()
  {
    new DoomFireCommand(this);
  }

  @Override
  public void onDisable()
  {
    if(screen != null)
      disposeScreen();
  }

  public Screen getScreen()
  {
    return screen;
  }

  public void disposeScreen()
  {
    screen.dispose();
    screen = null;
  }

  public void createScreen(Location location, int width, int height)
  {
    screen = new Screen(this, location, width, height);
  }
}
