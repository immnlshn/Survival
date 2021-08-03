package de.mvnuuh.minecraft.survival.commands;

import de.mvnuuh.minecraft.survival.Survival;
import de.mvnuuh.minecraft.survival.utils.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class reloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Config config = Survival.getConfiguration();
        Survival.reloadConfiguration();
        config = Survival.getConfiguration();
        sender.sendMessage(config.getCommandsConfig("reload", "prefix")+config.getCommandsConfig("reload", "message"));
        return true;
    }
}
