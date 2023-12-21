package nl.officialfox.zalm;

import org.bukkit.plugin.java.JavaPlugin;

public class Zalm extends JavaPlugin{

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new ZalmListener(), this);
    }

    @Override
    public void onDisable() {

    }
}
