package de.mvnuuh.minecraft.survival.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0){
            sender.sendMessage("§7[§cError§7]§r Verwendung: §6/bc §a<Nachricht>§r");
            return true;
        }
        for(Player p : sender.getServer().getOnlinePlayers()){
            p.sendMessage("§3[§9Broadcast§7]§r "+String.join(" ",args));
        }
        return true;
    }
}
