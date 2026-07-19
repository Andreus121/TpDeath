package cl.andreus;

import org.bukkit.plugin.java.JavaPlugin;

public final class TpDeath extends JavaPlugin {

    @Override
    public void onEnable() {
        //lógica cuando el plugin inicia

        //registrar el listener
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
