package de.mvnuuh.minecraft.survival.commands;

import de.mvnuuh.minecraft.survival.Survival;
import de.mvnuuh.minecraft.survival.scoreboard.Scoreboard;
import de.mvnuuh.minecraft.survival.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ToggleScoreboardCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Config config = Survival.getConfiguration();
        Player player = (Player) sender;
        String status;
        if(player.getScoreboard().equals(Bukkit.getScoreboardManager().getMainScoreboard())){
            new Scoreboard(player);
            status = "§2aktiviert";
        }
        else{
            player.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
            status = "§4deaktiviert";

        }
        sender.sendMessage(config.getCommandsConfig("scoreboard", "prefix")+config.getCommandsConfig("scoreboard", "message").replace("%status%", status));
        return true;
    }
}
