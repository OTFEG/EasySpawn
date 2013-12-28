package net.jimmy1248.easyspawn;

import org.bukkit.plugin.java.JavaPlugin;

public class EasySpawn extends JavaPlugin{
	@Override
	public void onEnable() {
		new CommandListener(this);
		new PlayerListener(this);
		saveDefaultConfig();
	}
	
	

}
	
