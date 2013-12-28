package net.jimmy1248.easyspawn;

import net.jimmy1248.easyspawn.commandhandlers.Spawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandListener implements CommandExecutor{
	EasySpawn plugin;
	public CommandListener(EasySpawn plugin) {
		this.plugin = plugin;
		plugin.getCommand("spawn").setExecutor(this);
		plugin.getCommand("setspawn").setExecutor(this);
		plugin.getCommand("bed").setExecutor(this);
		plugin.getCommand("setfirstspawn").setExecutor(this);
		plugin.getCommand("firstspawn").setExecutor(this);
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		switch (command.getName().toLowerCase()) {
		case "spawn": return Spawn.spawn(plugin,sender,args);
		case "bed": return Bed.bed(plugin,sender);
		case "setspawn": return Spawn.setspawn(plugin,sender,args);
		case "firstspawn": return FirstSpawn.firstSpawn(plugin,sender,args);
		case "setfirstspawn": return FirstSpawn.setFirstSpawn(plugin,sender,args);
		}
		return false;
			
			
		
	}
}
