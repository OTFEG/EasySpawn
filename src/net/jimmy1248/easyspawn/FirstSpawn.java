package net.jimmy1248.easyspawn;

import net.jimmy1248.easyspawn.commandhandlers.Sender;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class FirstSpawn {

	public static boolean firstSpawn(EasySpawn plugin, CommandSender sender,
			String[] args) {
		Player player = Sender.isPlayer(sender);
		if(player==null) return true;
		FileConfiguration config = plugin.getConfig();
		if(config.getBoolean("firstspawn.enabled")){
			World world = plugin.getServer().getWorld((config.getString("firstspawn.world")));
			Location location = new Location(world, config.getInt("firstspawn.x"),
					config.getInt("firstspawn.y"), config.getInt("firstspawn.z"), 
					config.getInt("firstspawn.yaw"),
					config.getInt("firstspawn.pitch"));
			player.teleport(location);
		}
		return true;
	}

	public static boolean setFirstSpawn(EasySpawn plugin, CommandSender sender,
			String[] args) {
		Player player = Sender.isPlayer(sender);
		if(player==null) return true;
		FileConfiguration config = plugin.getConfig();
		//setspawn
		if(args.length==0){
			Location location = player.getLocation();
			config.set("firstspawn.enabled", true);
			config.set("firstspawn.world", location.getWorld());
			config.set("firstspawn.x",location.getBlockX());
			config.set("firstspawn.y",location.getBlockY());
			config.set("firstspawn.z",location.getBlockY());
			config.set("firstspawn.yaw",location.getYaw());
			config.set("firstspawn.pitch",location.getPitch());
			player.sendMessage("Spawn set.");
			return true;
		}
		return false;
	}

}
