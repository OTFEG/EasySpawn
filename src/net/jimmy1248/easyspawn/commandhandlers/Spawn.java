package net.jimmy1248.easyspawn.commandhandlers;

import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.jimmy1248.easyspawn.EasySpawn;

public class Spawn {

	public static boolean spawn(EasySpawn plugin,CommandSender sender,String[] args) {
		Player player = Sender.isPlayer(sender); 
		if(player!=null){
			//spawn
			if(args.length==0){
				player.teleport(player.getWorld().getSpawnLocation());
				player.sendMessage("You have been teleported to spawn.");
				return true;
			//spawn [world]
			}else if(args.length==1){
				World world = plugin.getServer().getWorld(args[0]);
				if(world==null){
					player.sendMessage("World does not exist.");
					return true;
				}
				player.teleport(world.getSpawnLocation());
				player.sendMessage("You have been teleported to " 
				+ world.getName() + " spawn.");
				return true;
				
			}
		}
		return false;
		
		
	}

	public static boolean setspawn(EasySpawn plugin, CommandSender sender, String[] args) {
		Player player = Sender.isPlayer(sender); 
			if(player!=null){
				//setspawn
				if(args.length==0){
					player.getWorld().setSpawnLocation(player.getLocation().getBlockX(),
							player.getLocation().getBlockY(),player.getLocation().getBlockZ());
					sender.sendMessage("Spawn set.");
					return true;
				//setspawn x y z
				}else if (args.length==3) {
					try{
						player.getWorld().setSpawnLocation(Integer.parseInt(args[0]),
							Integer.parseInt(args[1]),Integer.parseInt(args[2]));
					}catch(NumberFormatException e){
						player.sendMessage("Invalid location.");
						return false;
					}
					player.sendMessage("Spawn set.");
					return true;
				}
			}
			if (args.length==4) {
				World world = plugin.getServer().getWorld(args[0]);
				if(world==null){
					sender.sendMessage("World does not exist.");
					return true;
				}
				try{
					world.setSpawnLocation(Integer.parseInt(args[0]),
						Integer.parseInt(args[1]),Integer.parseInt(args[2]));
				}catch(NumberFormatException e){
					sender.sendMessage("Invalid location.");
					return false;
				}
				sender.sendMessage(world.getName() + " spawn has been set.");
				return true;
			}
		return false;
		
	}
	
}
