package com.doiche;

import com.doiche.biomes.BiomeListener;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {
    private static Main plugin;
    private static final Server server = Bukkit.getServer();
    private static final Logger log = server.getLogger();

    @Override
    public void onEnable(){
        Main.plugin = this;
        registerEvents(new Listener[]{
            new BiomeListener()
        });
    }

    @Override
    public void onDisable(){
        for(Player player : getServer().getOnlinePlayers()){
            player.kick(Component.text("리로드 중! 재접속하세요."));
        }
    }

    public static Main inst(){
        return plugin;
    }
    public static void info(String msg){ log.info(msg); }
    public static void warn(String msg) { log.warning(msg); }

    private void registerEvents(Listener[] listeners){
        PluginManager manager = server.getPluginManager();
        for(Listener listener : listeners){
            manager.registerEvents(listener, this);
        }
    }
}
