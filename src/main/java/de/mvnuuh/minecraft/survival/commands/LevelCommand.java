package de.mvnuuh.minecraft.survival.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LevelCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0){
            sender.sendMessage("§7[§bLevel§7]§r Dein Level beträgt §6"+((Player) sender).getLevel()+"§r.");
            return true;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if(target==null) {
            sender.sendMessage("§7[§cError§7]§r Der Spieler wurde nicht gefunden.");
            return true;
        }
        sender.sendMessage("§7[§bLevel§7]§r Das Level von §6"+target.getName()+"§r beträgt §6"+target.getLevel()+"§r.");
        return true;

    }
}
