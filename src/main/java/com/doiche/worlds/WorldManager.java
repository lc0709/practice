package com.doiche.worlds;

import com.doiche.Main;
import org.bukkit.World;

public class WorldManager {
    private static final Main plugin = Main.inst();
    public static final World OVERWORLD = plugin.getServer().getWorlds().get(0);
}
