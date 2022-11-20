package com.doiche.tools.frame_tool;

import com.doiche.utils.Scheduler;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class FrameToolListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        FrameToolManager.registerPlayer(event.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerJoinEvent event){
        FrameToolManager.unRegisterPlayer(event.getPlayer());
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e){
        if(e.getItem() == null || !e.getItem().getType().equals(Material.NETHERITE_HOE)) return;
        if(e.getClickedBlock() == null) return;
        Scheduler.async(() -> {
            Player player = e.getPlayer();
            if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                Location pos = e.getClickedBlock().getLocation();
                FrameToolManager.setLocation1(player, pos);
                player.sendMessage("pos 1 : [" + pos.toVector() + "] saved.");
            } else if (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
                Location pos = e.getClickedBlock().getLocation();
                FrameToolManager.setLocation2(player, pos);
                player.sendMessage("pos 2 : [" + pos.toVector() + "] saved.");
            }
        });
    }
}
