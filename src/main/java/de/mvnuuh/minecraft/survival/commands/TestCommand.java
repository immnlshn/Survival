package de.mvnuuh.minecraft.survival.commands;

import de.mvnuuh.minecraft.survival.Survival;
import de.mvnuuh.minecraft.survival.entities.ShopVillager;
import de.mvnuuh.minecraft.survival.inventories.Item;
import de.mvnuuh.minecraft.survival.inventories.ShopInventory;
import de.mvnuuh.minecraft.survival.inventories.ShopInventoryBuilder;
import de.mvnuuh.minecraft.survival.scoreboard.Nametag;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collections;

public class TestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("Ich lebe.");
        Player p = ((Player) sender);
        new ShopVillager(p.getLocation());
        return true;
    }
}
