package de.mvnuuh.minecraft.survival.commands;

import de.mvnuuh.minecraft.survival.Survival;
import de.mvnuuh.minecraft.survival.utils.Config;
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
        Config config = Survival.getConfiguration();
        Player player;
        if(args.length==0){
            player = (Player) sender;
        }
        else if(Bukkit.getPlayer(args[0]) == null){
            sender.sendMessage(config.getCommandsConfig("broadcast", "error"));
            return false;
        }
        else{
            player = Bukkit.getPlayer(args[0]);
        }
        long level = player.getLevel();
        long minedBlocks = 0;
        long deaths = player.getStatistic(Statistic.DEATHS);
        for(Material m : Material.values()){
            if(m.isSolid()){
                minedBlocks = minedBlocks+player.getStatistic(Statistic.MINE_BLOCK, m);
            }
        }
        sender.sendMessage(config.getCommandsConfig("stats", "prefix")+config.getCommandsConfig("stats", "message").replace("%player%", player.getName()).replace("%blocks%",String.valueOf(minedBlocks)).replace("%level%",String.valueOf(player.getLevel())).replace("%deaths%",String.valueOf(player.getStatistic(Statistic.DEATHS))));
        return true;
    }
}
