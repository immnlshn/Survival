package de.mvnuuh.minecraft.survival.commands;

import de.mvnuuh.minecraft.survival.scoreboard.Scoreboard;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ToggleScoreboardCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(player.getScoreboard().equals(Bukkit.getScoreboardManager().getMainScoreboard())){
            new Scoreboard(player);
            sender.sendMessage("§7[§eScoreboard§7] §fDas Scoreboard wurde §3aktiviert.");
        }
        else{
            player.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
            sender.sendMessage("§7[§eScoreboard§7] §fDas Scoreboard wurde §4deaktiviert.");
        }
        return true;
    }
}
