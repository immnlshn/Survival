package de.mvnuuh.minecraft.survival.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StatsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player;
        if(args.length==0){
            player = (Player) sender;
        }
        else if(Bukkit.getPlayer(args[0]) == null){
            sender.sendMessage("§7[§cError§7] §fDer Spieler wurde nicht gefunden.");
            return false;
        }
        else{
            player = Bukkit.getPlayer(args[0]);
        }
        long level = player.getLevel();
        long minedBlocks = 0;
        for(Material m : Material.values()){
            if(m.isSolid()){
                minedBlocks = minedBlocks+player.getStatistic(Statistic.MINE_BLOCK, m);
            }
        }
        sender.sendMessage(
                "§7[§cStats§7] §fDie Statistiken von §9"+player.getName()+"§7:\n" +
                        "§7- §fAbgebaute Blöcke: §6"+minedBlocks+"\n"+
                        "§7- §fLevel: §6"+level
        );
        return true;
    }
}
