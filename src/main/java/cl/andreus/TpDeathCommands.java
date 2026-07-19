package cl.andreus;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class TpDeathCommands implements BasicCommand {
    private final TpDeath plugin;
    private final PlayerDeathListener listener;

    //constructor
    public TpDeathCommands(TpDeath plugin, PlayerDeathListener listener){
        this.plugin = plugin;
        this.listener = listener;
    }

    @Override
    public void execute(CommandSourceStack source,String[] args){
        //guardar al que ejecutó el comando
        CommandSender sender = source.getSender();
        //guardar la entidad que ejecutó el comando
        Entity executor = source.getExecutor();

        //si ejecuta el comando desde la consola
        if(!(executor instanceof Player player)){
            sender.sendPlainMessage("Solo los jugadores pueden volver a su lugar de muerte");
            return;
        }

        //si no es la consola, es un jugador
        //si ejecutó solo /tpdeath
        if(args.length == 0){
            //obtener la ubicación de muerte del jugador
            Location deathlocation = listener.getLocationDeath(player);

            //solo si murió hazle tp
            if(deathlocation!=null) {
                //hacerle tp a donde murió
                player.teleport(deathlocation);
                //transformar a String las coordenadas de muerte
                String coordsx = Integer.toString(deathlocation.getBlockX());
                String coordsy = Integer.toString(deathlocation.getBlockY());
                String coordsz = Integer.toString(deathlocation.getBlockZ());
                String coords = "X: " + coordsx + " Y: " + coordsy + " Z: " + coordsz;
                //mostrar mensaje de TP
                sender.sendPlainMessage("TP a tu ultima ubicación de muerte: "+ coords);
                return;
            }

            //si no murió indicarle con un mensaje
            sender.sendPlainMessage("No tienes ninguna muerte registrada");
        }
    }
}
