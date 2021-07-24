package de.mvnuuh.minecraft.survival.scoreboard;

import de.mvnuuh.minecraft.survival.Survival;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;


public class NametagBuilder {

    protected final ArmorStand entity;

    protected final Player player;



    public NametagBuilder(Player player, String displayName) {
        this.player = player;
        this.entity = ((ArmorStand) this.player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND));
        this.entity.setSilent(true);
        this.entity.setGravity(false);
        this.entity.setCustomNameVisible(true);
        this.entity.setInvulnerable(true);
        this.entity.setVisible(false);
        this.entity.setCustomName(displayName);
    }

    public void setDisplayName(String displayName){
        this.entity.setCustomName(displayName);
    }
}
