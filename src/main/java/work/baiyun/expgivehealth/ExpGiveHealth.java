package work.baiyun.expgivehealth;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ExpGiveHealth extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new ChangeHealth(), this);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {

        // Plugin shutdown logic
    }

    class ChangeHealth implements Listener {
        @EventHandler
        public void ChangeHealth(PlayerExpChangeEvent e) {
            Player player = e.getPlayer();
            int level = player.getLevel();
            int health=20;
            if(level<10){
                health+=(int)(level/1.25);
            }else{
                health+=3+(int)((level-10)/2.5);
            }
            int oldhealth=(int)Objects.requireNonNull(((Attributable) player).getAttribute(Attribute.GENERIC_MAX_HEALTH)).getBaseValue();
            if(oldhealth!=health)
            {
                Objects.requireNonNull(((Attributable) player).getAttribute(Attribute.GENERIC_MAX_HEALTH)).setBaseValue(health);
                if(oldhealth/2!=health/2){
                    player.setHealth(health);
                }

            }

        }

    }
}
