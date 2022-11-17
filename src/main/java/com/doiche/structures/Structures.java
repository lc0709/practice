package com.doiche.structures;

import com.doiche.Main;
import io.netty.channel.local.LocalAddress;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.structure.Structure;
import org.bukkit.structure.StructureManager;

import java.util.ArrayList;
import java.util.Objects;

public class Structures {
    private static final Main plugin = Main.inst();
    private static final StructureManager structManager = plugin.getServer().getStructureManager();

    public void setup(){

    }

    public static ArrayList<Structure> getAllStructures(){
        return new ArrayList<>(structManager.getStructures().values());
    }

    public void saveStructure(Location loc1, Location loc2, boolean include){
        try {
            Structure structure = structManager.createStructure();
            structure.fill(loc1, loc2, include);
            NamespacedKey key = Objects.requireNonNull(NamespacedKey.fromString("test"));
            structManager.registerStructure(key, structure);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
