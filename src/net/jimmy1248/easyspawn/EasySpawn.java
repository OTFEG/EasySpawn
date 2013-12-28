package net.jimmy1248.easyspawn;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class EasySpawn extends JavaPlugin{
	@Override
	public void onEnable() {
		getCommand("spawn").setExecutor(this);
		getCommand("setspawn").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(sender instanceof Player){
			Player player = (Player)sender;
			if(command.getName().equalsIgnoreCase("spawn")){
				if(args.length==0){
					player.teleport(player.getWorld().getSpawnLocation());
					player.sendMessage("You have been teleported to spawn.");
					return true;
				}else if(args.length==1){
					World world = getServer().getWorld(args[0]);
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
			if(command.getName().equalsIgnoreCase("setspawn")){
				Location location;
				if(args.length==0){
					player.getWorld().setSpawnLocation(arg0, arg1, arg2)
					player.sendMessage("Spawn set.");
				}else if (args.length==3) {
					player.getWorld().setSpawnLocation(Integer.parseInt(args[0]),
							Integer.parseInt(args[1]),Integer.parseInt(args[2]));
				}else if (args.length==4) {
					World world = getServer().getWorld(args[0]);
					if(world==null){
						player.sendMessage("World does not exist.");
						return true;
					}				
				}
			}
			if(command.getName().equalsIgnoreCase("bed")){
				if(player.getBedSpawnLocation()!=null){
					player.teleport(player.getBedSpawnLocation());
					player.sendMessage("You have been teleported to your bed.");
				}else player.sendMessage("Your bed cannot be found.");
			}
		}
		return false;
	}

}
