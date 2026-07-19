package cl.andreus;

import org.bukkit.plugin.java.JavaPlugin;

public final class TpDeath extends JavaPlugin {
    public PlayerDeathListener listener;

    @Override
    public void onEnable() {
        //lógica cuando el plugin inicia
        //crear el listener de las muertes
        this.listener = new PlayerDeathListener();
        //registrar el listener
        getServer().getPluginManager().registerEvents(this.listener, this);
        //registrar el comando
        registerCommand("tpdeath", new TpDeathCommands(this, this.listener));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
