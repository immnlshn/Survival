package de.mvnuuh.minecraft.survival.entities;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;

public class ShopVillager{

    public static final String customName = "§6SHOP";
    public ShopVillager(Location loc){
        Villager villager = (Villager) Bukkit.getWorld("world").spawnEntity(loc, EntityType.VILLAGER);
        villager.setCustomName(customName);
        villager.setAI(false);
        villager.setCustomNameVisible(true);
        villager.setCanPickupItems(false);
    }
}
