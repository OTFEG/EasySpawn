package net.jimmy1248.easyspawn;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener {
	
	private EasySpawn plugin;

	public PlayerListener(EasySpawn plugin) {
		this.plugin = plugin;
	}
	@EventHandler
	void playerJoinEvent(PlayerJoinEvent event){
		Player player = event.getPlayer();
		if(!player.hasPlayedBefore()){
			FileConfiguration config = plugin.getConfig();
			if(config.getBoolean("firstspawn.enabled")){
				World world = plugin.getServer().getWorld((config.getString("firstspawn.world")));
				Location location = new Location(world, config.getInt("firstspawn.x"),
						config.getInt("firstspawn.y"), config.getInt("firstspawn.z"), 
						config.getInt("firstspawn.yaw"),
						config.getInt("firstspawn.pitch"));
				player.teleport(location);
			}
		}
		
	}
}
