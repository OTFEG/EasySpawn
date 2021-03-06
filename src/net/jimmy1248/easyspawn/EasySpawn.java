package net.jimmy1248.easyspawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class EasySpawn extends JavaPlugin{
		
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(sender instanceof Player){
			Player player = (Player)sender;
			if(command.getName().equalsIgnoreCase("spawn")){
				player.teleport(player.getWorld().getSpawnLocation());
				player.sendMessage("You have been teleported to spawn.");
				return true;
			}
			if(command.getName().equalsIgnoreCase("setspawn")){
				player.getWorld().setSpawnLocation(player.getLocation().getBlockX(),
						player.getLocation().getBlockY(),player.getLocation().getBlockZ());
				player.sendMessage("Spawn set.");
				return true;
			}
			if(command.getName().equalsIgnoreCase("bed")){
				if(player.getBedSpawnLocation()!=null){
					player.teleport(player.getBedSpawnLocation());
					player.sendMessage("You have been teleported to your bed.");
				}else sender.sendMessage("Your bed cannot be found.");
				return true;
			}
		}
		return false;
	}

}
