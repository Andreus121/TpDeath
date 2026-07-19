package cl.andreus;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.HashMap;
import java.util.UUID;

public class PlayerDeathListener implements Listener {
    //hash con las muertes de los jugadores
    private final HashMap<UUID, Location> deaths;

    //constructor
    public PlayerDeathListener(){
        this.deaths = new HashMap<>();
    }

    //listener
    @EventHandler
    public void playerDeath(PlayerDeathEvent event){
        //guardar el jugador que murió
        Player player = event.getPlayer();
        //guardar su ubicación de muerte con su UUID
        this.deaths.put(player.getUniqueId(),player.getLocation());
    }

    public Location getLocationDeath(Player player){
        return deaths.get(player.getUniqueId());
    }
}
