package de.mvnuuh.minecraft.survival.listener;

import de.mvnuuh.minecraft.survival.scoreboard.Nametag;
import de.mvnuuh.minecraft.survival.scoreboard.Scoreboard;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuitListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();
        event.setJoinMessage(ChatColor.GRAY+"["+ChatColor.GREEN+"+"+ChatColor.GRAY+"]"+ChatColor.WHITE+" "+p.getName());
        p.sendMessage("§7[§eSurvival§7]§r Willkommen und Viel Spaß.");
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player p = event.getPlayer();
        event.setQuitMessage(ChatColor.GRAY+"["+ChatColor.RED+"-"+ChatColor.GRAY+"]"+ChatColor.WHITE+" "+p.getName());
    }
}
