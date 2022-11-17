package com.doiche.biomes.events;

import com.doiche.Main;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerChangeBiomeEvent extends PlayerEvent {
    static HandlerList handlers = new HandlerList();
    public final Biome oldBiome;
    public final Biome newBiome;
    //static final Main plugin = Main.inst();

    public PlayerChangeBiomeEvent(@NotNull Player who, Biome oldBiome, Biome newBiome) {
        super(who);
        this.oldBiome = oldBiome;
        this.newBiome = newBiome;
    }

    public static HandlerList getHandlerList(){
        return handlers;
    }
    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }
}
