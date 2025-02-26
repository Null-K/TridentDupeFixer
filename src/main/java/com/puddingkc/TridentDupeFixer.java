package com.puddingkc;

import com.puddingkc.events.InventoryClickEvent;
import com.puddingkc.events.PlayerEvent;
import com.puddingkc.events.ProjectilEvent;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class TridentDupeFixer extends JavaPlugin implements Listener {

    public final Set<UUID> readyThrow = new HashSet<>();

    @Override
    public void onEnable() {
        getLogger().info("Author: PuddingKC");
        this.listen(
                new InventoryClickEvent(this),
                new PlayerEvent(this),
                new ProjectilEvent(this)
        );
    }

    private void listen(final Listener... listeners) {
        final PluginManager pluginManager = getServer().getPluginManager();
        for (final Listener listener : listeners) {
            pluginManager.registerEvents(listener, this);
        }
    }
}

