package com.puddingkc.events;

import com.puddingkc.TridentDupeFixer;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Trident;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

public class ProjectilEvent implements Listener {

    private final TridentDupeFixer plugin;

    public ProjectilEvent(TridentDupeFixer plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        if (event.getEntity() instanceof Trident && event.getEntity().getShooter() instanceof Player) {
            Player player = (Player) event.getEntity().getShooter();
            plugin.readyThrow.remove(player.getUniqueId());
        }
    }
}
