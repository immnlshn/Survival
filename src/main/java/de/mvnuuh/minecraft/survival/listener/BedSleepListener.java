package de.mvnuuh.minecraft.survival.listener;

import de.mvnuuh.minecraft.survival.Survival;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class BedSleepListener implements Listener {
    private boolean isSycling = false;

    @EventHandler
    public void onPlayerSleep(PlayerBedEnterEvent event){
        Player player = event.getPlayer();
        if(!(player.getWorld().getTime() >=12544) && !(player.getWorld().getTime() <=23461)) return;
        for(Player p : player.getServer().getOnlinePlayers()) p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§fDer Spieler §6"+event.getPlayer().getName()+"§f hat sich schlafen gelegt."));
        if(isSycling)
            return;
        isSycling = true;

        player.getWorld().setStorm(false);
        player.getWorld().setThundering(false);
        player.getWorld().setWeatherDuration(0);
        new BukkitRunnable() {
            @Override
            public void run() {
                int i = 0;
                for(Player p : player.getServer().getOnlinePlayers()){
                    if (p.isSleeping())
                        i++;
                }
                if(i==0){
                    cancel();
                }
                else{
                    player.getWorld().setTime(player.getWorld().getTime()+100);
                }
            }

        }.runTaskTimer(Survival.getInstance(),1,1);
        isSycling = false;
    }
}

