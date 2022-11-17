package com.doiche.worlds;

import com.doiche.Main;
import net.minecraft.world.level.biome.BiomeBase;
import net.minecraft.world.level.biome.BiomeFog;
import net.minecraft.world.level.biome.BiomeSettingsGeneration;
import net.minecraft.world.level.biome.BiomeSettingsMobs;

public class WorldSetupManager {
    public static final Main plugin = Main.inst();
    public static void setup(){
        BiomeBase.a biomeBuilder = new BiomeBase.a();
        BiomeBase biomeBase;
        /*
                = biomeBuilder
                .a(BiomeBase.Precipitation.a)             // precipitation
                .a(0.5f)                                  // temp
                .a(BiomeBase.TemperatureModifier.a)       // temp mod
                .b(0.5f)                                  // downfall
                .a(new BiomeFog())                      // fog
                .a(new BiomeSettingsMobs())             // mob settings
                .a(new BiomeSettingsGeneration())       // setting gen
                .a();                                   // getter
        */
    }
}
