package de.mvnuuh.minecraft.survival.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

public class SpawnVillagerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = ((Player) sender);
        Villager villager = ((Villager) player.getWorld().spawnEntity(player.getLocation(), EntityType.VILLAGER));
        villager.setCustomName("§c§lYeetus Maximus");
        villager.setAI(false);
        villager.setCustomNameVisible(true);
        villager.setCanPickupItems(false);
        ItemStack in = new ItemStack(Material.EMERALD, 1);
        ItemStack out = new ItemStack(Material.EMERALD, 64);
        //villager.setRecipe(in,out).finish();

        return false;
    }
}
