package de.mvnuuh.minecraft.survival.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ipCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0){
            sender.sendMessage("§7[§eIP§7]§r Deine Ip-Adresse lautet §6"+((Player) sender).getAddress().getHostName().toString()+"§r.");
            return true;
        }
        Player target = Bukkit.getPlayerExact(args[0]);
        if(target == null){
            sender.sendMessage("§7[§cError§7]§r Spieler nicht gefunden.");
            return true;
        }
        sender.sendMessage("§7[§eIP§7]§r Die IP-Adresse von §6"+target.getName()+"§r lautet §6"+target.getAddress().getHostName().toString()+"§r.");
        return true;
    }
}
