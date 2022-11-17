package com.doiche.tools.frame_tool;

import com.doiche.worlds.WorldManager;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import oshi.util.tuples.Pair;

import java.util.HashMap;
import java.util.Map;

public class FrameToolManager {
    private static final Map<Player, Pair<Location, Location>> locations = new HashMap<>();
    private static final Location ZERO = new Location(WorldManager.OVERWORLD,0.0f,0.0f,0.0f);
    private static final Pair<Location, Location> PAIR = new Pair<>(ZERO, ZERO);

    public static void registerPlayer(Player player){
        if(!locations.containsKey(player)) locations.put(player, PAIR);
    }

    public static void setLocationPair(Player player, Location loc1, Location loc2){
        locations.put(player, new Pair<>(loc1, loc2));
    }

    public static Pair<Location, Location> getLocationPair(Player player){
        return locations.get(player);
    }

}
