package net.jimmy1248.easyspawn;

import net.jimmy1248.easyspawn.commandhandlers.Sender;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Bed {
	static boolean bed(EasySpawn plugin,CommandSender sender){
		Player player = Sender.isPlayer(sender); 
		if(player==null) return true;
			if(player.getBedSpawnLocation()!=null){
				player.teleport(player.getBedSpawnLocation());
				player.sendMessage("You have been teleported to your bed.");
			}else sender.sendMessage("Your bed cannot be found.");
			return true;
	}

}
