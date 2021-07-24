package de.mvnuuh.minecraft.survival.scoreboard;

import org.bukkit.entity.Player;

public class Nametag extends NametagBuilder{
    public Nametag(Player player) {
        super(player, "Funktioniert noch nicht so.");
    }
    public void teleport(){
        entity.teleport(player.getLocation());
    }
}
