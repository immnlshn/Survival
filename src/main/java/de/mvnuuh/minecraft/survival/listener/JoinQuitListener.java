package de.mvnuuh.minecraft.survival.listener;

import de.mvnuuh.minecraft.survival.Survival;
import de.mvnuuh.minecraft.survival.scoreboard.Nametag;
import de.mvnuuh.minecraft.survival.scoreboard.Scoreboard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitTask;

public class JoinQuitListener implements Listener {
    BukkitTask task;

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();
        event.setJoinMessage("§7[§dSurvival§7] §6"+p.getName()+"§f hat den Server §2betreten§f.");
        p.sendTitle("§dSurvival §7[§e1§7.§e17§7.§e1§7]","§cDiscord§7: §9dc§7.§9noga§7.§9one",35,40,35);
        runSound(p);

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player p = event.getPlayer();
        event.setQuitMessage("§7[§dSurvival§7] §6"+p.getName()+"§f hat den Server §4verlassen§f.");
    }

    private void runSound(Player p){
        final int[] i = {0};
        task = Bukkit.getScheduler().runTaskTimer(Survival.getInstance(), () -> {
            if (i[0]>100) {
                task.cancel();
            } else{
                p.playSound(p.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_CHIME,500,i[0]);
                i[0]= i[0]+10;
            }
        }, 1, 5);
    }
}
