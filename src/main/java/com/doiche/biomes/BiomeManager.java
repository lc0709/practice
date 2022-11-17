package com.doiche.biomes;

import com.doiche.Main;
import com.doiche.biomes.events.PlayerChangeBiomeEvent;
import com.doiche.utils.Scheduler;
import org.bukkit.Location;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import java.util.Collection;
import java.util.HashMap;

public class BiomeManager{
    private static final Main plugin = Main.inst();
    private static final HashMap<Player, Biome> oldBiomes = new HashMap<>();

    public static void setup(Player player){
        Location loc = player.getLocation();
        Biome biome = loc.getWorld().getBiome(loc);
        oldBiomes.putIfAbsent(player, biome);
    }

    /**
     * 플레이어의 바이옴이 바뀌었는지 검사합니다.
     */
    public static void detectPlayerChangeBiome(Collection<? extends Player> players, Long period){
        Main.info("Biome Detect Start!");
        Scheduler.asyncLoop(period, () -> {
            for(Player player: players){
                Location loc = player.getLocation();
                Biome old = oldBiomes.get(player);
                Biome biome = loc.getWorld().getBiome(loc);
                if(!old.equals(biome)){
                    player.sendMessage(old.name() + ", " + biome.name());
                    Scheduler.sync(() -> new PlayerChangeBiomeEvent(player, old, biome).callEvent());
                    oldBiomes.put(player, biome);
                }
            }
        });
    }
}
