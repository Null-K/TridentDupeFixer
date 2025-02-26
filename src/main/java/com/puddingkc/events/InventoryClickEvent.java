package com.puddingkc.events;

import com.puddingkc.TridentDupeFixer;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class InventoryClickEvent implements Listener {

    private final TridentDupeFixer plugin;

    public InventoryClickEvent(TridentDupeFixer plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onInventoryClick(org.bukkit.event.inventory.InventoryClickEvent event) {
        HumanEntity humanEntity = event.getWhoClicked();
        if (plugin.readyThrow.contains(humanEntity.getUniqueId())) {
            event.setCancelled(true);
        }
    }
}
