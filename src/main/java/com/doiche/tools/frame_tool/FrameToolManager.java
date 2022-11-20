package com.doiche.tools.frame_tool;

import com.doiche.utils.Scheduler;
import com.doiche.worlds.WorldManager;
import net.minecraft.util.Tuple;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import oshi.util.tuples.Pair;

import java.util.HashMap;
import java.util.Map;

public class FrameToolManager {
    private static final Map<Player, Tuple<Location, Location>> locations = new HashMap<>();
    private static final Particle particle = Particle.DRIPPING_DRIPSTONE_LAVA;
    private static final int count = 1;

    public static void registerPlayer(Player player){
        if(!locations.containsKey(player)) locations.put(player, new Tuple<>(null, null));
    }
    public static void unRegisterPlayer(Player player) {
        locations.remove(player);
    }

    public static void setLocation1(Player player, Location loc1){
        locations.get(player).a(loc1);
    }
    public static void setLocation2(Player player, Location loc2){
        locations.get(player).b(loc2);
    }
    public static Tuple<Location, Location> getLocations(Player player){
        return locations.get(player);
    }

    public static void showFrame(Player player){
        Scheduler.getPersonal(player).async("show_frame", () -> {
            Location pos1 = getLocations(player).a();
            Location pos2 = getLocations(player).b();
            if(pos1 == null || pos2 == null || pos1.equals(pos2)) return;
            int deltaX = pos1.getBlockX() - pos2.getBlockX();
            int deltaY = pos1.getBlockY() - pos2.getBlockY();
            int deltaZ = pos1.getBlockZ() - pos2.getBlockZ();
            if(deltaX == 0 || deltaY == 0 || deltaZ == 0) return;
            Location locX = deltaX > 0 ? pos2 : pos1 ;
            Location locY = deltaY > 0 ? pos2 : pos1 ;
            Location locZ = deltaZ > 0 ? pos2 : pos1 ;
            for(int i = 0; i < 16; i++){
                WorldManager.OVERWORLD.spawnParticle(particle, locX.clone().add(i / 16f,0.0, 0.0), count);
                WorldManager.OVERWORLD.spawnParticle(particle, locY.clone().add(0.0,i / 16f, 0.0), count);
                WorldManager.OVERWORLD.spawnParticle(particle, locZ.clone().add(0.0,0.0, i / 16f), count);
            }

            locX = locX.equals(pos1) ? pos2 : pos1 ;
            locY = locY.equals(pos1) ? pos2 : pos1 ;
            locZ = locZ.equals(pos1) ? pos2 : pos1 ;
            for(int i = 16; i > 0; i--){
                WorldManager.OVERWORLD.spawnParticle(particle, locX.clone().add(i / 16f,0.0, 0.0), count);
                WorldManager.OVERWORLD.spawnParticle(particle, locY.clone().add(0.0,i / 16f, 0.0), count);
                WorldManager.OVERWORLD.spawnParticle(particle, locZ.clone().add(0.0,0.0, i / 16f), count);
            }
        });
    }
}
