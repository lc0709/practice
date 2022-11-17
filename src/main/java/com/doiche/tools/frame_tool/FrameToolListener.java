package com.doiche.tools.frame_tool;

import com.doiche.utils.Scheduler;
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
    public void onClick(PlayerInteractEvent e){
        Scheduler.async(() -> {
            if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

            } else if (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {

            }
        });
    }
}
