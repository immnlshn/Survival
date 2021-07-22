package de.mvnuuh.minecraft.survival.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class NametagBuilder {

    protected final Scoreboard scoreboard;
    protected final Objective objective;

    protected final Player player;



    public NametagBuilder(Player player, String displayName) {
        this.player = player;
        this.scoreboard = this.player.getScoreboard();
        if(this.scoreboard.getObjective("nametag") != null){
            this.scoreboard.getObjective("nametag").unregister();
        }
        this.objective = this.scoreboard.registerNewObjective("nametag","dummy",displayName);
        this.objective.setDisplaySlot(DisplaySlot.BELOW_NAME);
    }

    public void setDisplayName(String displayName){
        this.objective.setDisplayName(displayName);
    }
}
