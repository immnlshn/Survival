package de.mvnuuh.minecraft.survival.commands;

import de.mvnuuh.minecraft.survival.Survival;
import de.mvnuuh.minecraft.survival.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Config config = Survival.getConfiguration();
        if(args.length == 0){
            sender.sendMessage(config.getCommandsConfig("broadcast", "error"));
            return true;
        }
        for(Player p : sender.getServer().getOnlinePlayers()){
            p.sendMessage(config.getCommandsConfig("broadcast","prefix")+config.getCommandsConfig("broadcast", "message").replace("%message%", String.join(" ",args)));
        }
        return true;
    }
}
