package net.jimmy1248.easyspawn.commandhandlers;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Sender {
	public static Player isPlayer(CommandSender sender) {
		if(sender instanceof Player){
			return (Player)sender;
		}
		sender.sendMessage("This command can only be exectuted by a player.");
		return null;
	}
}

