package me.giverplay.doomfire;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;

public class DoomFireCommand implements CommandExecutor
{
  private final DoomFire PLUGIN;

  public DoomFireCommand(DoomFire plugin)
  {
    this.PLUGIN = plugin;
    PluginCommand command = plugin.getCommand("doomfire");

    if(command == null)
    {
      plugin.getLogger().warning("O comando `/doomfire` não foi registrado no plugin.yml!");
      return;
    }

    command.setExecutor(this);
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    if(!(sender instanceof Player))
    {
      sender.sendMessage(ChatColor.RED + "Esse comando só pode ser executado por jogadores.");
      return true;
    }

    Player player = (Player) sender;

    if(args.length == 0)
    {
      player.sendMessage(ChatColor.GREEN + "Sub-comandos: create, dispose");
      return true;
    }

    if(args[0].equalsIgnoreCase("create"))
    {
      create(player, args);
      return true;
    }

    if(args[0].equalsIgnoreCase("dispose"))
    {
      dispose(player);
      return true;
    }

    return true;
  }

  private void create(Player player, String[] args)
  {
    if(args.length < 3)
    {
      player.sendMessage(ChatColor.RED + "Uso correto do comando:");
      player.sendMessage(ChatColor.RED + "/doomfire create <largura> <altura>");
      return;
    }

    int width;
    int height;

    try
    {
      width = Integer.parseInt(args[1]);
      height = Integer.parseInt(args[2]);
    }
    catch(NumberFormatException exception)
    {
      player.sendMessage("A largura e a altura devem ser números inteiros!");
      return;
    }

    PLUGIN.createScreen(player.getLocation(), width, height);
    player.sendMessage(ChatColor.GREEN + "O fogo foi criado!");
  }

  private void dispose(Player player)
  {
    if(PLUGIN.getScreen() == null)
    {
      player.sendMessage(ChatColor.RED + "O fogo não está ativo no momento, não é possível dispor.");
      return;
    }

    PLUGIN.disposeScreen();
    player.sendMessage(ChatColor.GREEN + "O fogo foi disposto com sucesso!");
  }
}
