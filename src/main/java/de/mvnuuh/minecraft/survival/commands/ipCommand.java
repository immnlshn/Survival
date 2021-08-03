package de.mvnuuh.minecraft.survival.commands;

import de.mvnuuh.minecraft.survival.Survival;
import de.mvnuuh.minecraft.survival.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ipCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Config config = Survival.getConfiguration();
        Player player;
        if(args.length == 0){
            player = (Player) sender;
        }
        else{
            player = Bukkit.getPlayerExact(args[0]);
        }
        if(player == null){
            sender.sendMessage(config.getCommandsConfig("ip", "error"));
            return true;
        }
        sender.sendMessage(config.getCommandsConfig("ip", "prefix")+config.getCommandsConfig("ip", "message").replace("%player%", player.getName()).replace("%ip%",player.getAddress().getHostName().toString()));
        return true;
    }
}
