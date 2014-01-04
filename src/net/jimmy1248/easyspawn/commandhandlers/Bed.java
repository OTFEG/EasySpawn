package net.jimmy1248.easyspawn.commandhandlers;

import net.jimmy1248.easyspawn.EasySpawn;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Bed {
	public static boolean bed(EasySpawn plugin,CommandSender sender){
		Player player = Sender.isPlayer(sender); 
		if(player==null) return true;
			if(player.getBedSpawnLocation()!=null){
				player.teleport(player.getBedSpawnLocation());
				player.sendMessage("You have been teleported to your bed.");
			}else sender.sendMessage("Your bed cannot be found.");
			return true;
	}

}
