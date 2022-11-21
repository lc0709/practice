package com.doiche.tools.frame_tool;

import com.doiche.Main;
import com.doiche.utils.EasyRegistry;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class FrameToolCommand implements TabExecutor, EasyRegistry {

    @Override
    public String getKey() {
        return "frametool";
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> list = new ArrayList<>();
        switch (args.length) {
            case 1 -> list.add("set");
            case 2 -> {
                if(args[1].equals("set")){
                    list.add("pos1");
                    list.add("pos2");
                }
            }
        }
        return list;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {
            switch (args.length) {
                case 1 -> {
                    if(args[0].equals("get"))
                        player.sendMessage(FrameToolManager.getLocations(player).toString());
                }
                case 2 -> {
                    if(args[0].equals("set")) {
                        Block targetBlock = player.getTargetBlock(50);
                        if(targetBlock == null) return false;
                        Location loc = targetBlock.getLocation();
                        switch (args[1]) {
                            case "pos1" -> FrameToolManager.setLocation1(player, loc);
                            case "pos2" -> FrameToolManager.setLocation2(player, loc);
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
}
