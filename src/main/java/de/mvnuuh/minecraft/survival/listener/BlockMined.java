package de.mvnuuh.minecraft.survival.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.scoreboard.Scoreboard;

public class BlockMined implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        Player p = event.getPlayer();
        p.sendMessage("Hah du hast einen Block zerstört.\nDiese Nachricht wird dich so lange nerven, bis ich das Scoreboard updaten kann.");

    }
}
