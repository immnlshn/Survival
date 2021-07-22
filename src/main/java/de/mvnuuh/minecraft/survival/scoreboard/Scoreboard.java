package de.mvnuuh.minecraft.survival.scoreboard;

import de.mvnuuh.minecraft.survival.Survival;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Scoreboard extends ScoreboardBuilder{
    public Scoreboard(Player p) {
        super(p, "§c✖ §5§n"+p.getName()+" §r§c✖");
        run();
    }

    @Override
    public void createScoreboard() {
        setScore("      ",10);
        setScore("§7Tode:",9);
        setScore("§c"+player.getStatistic(Statistic.DEATHS),8);
        setScore("     ",7);
        setScore("§7Insgesamt abgebaute Blöcke:", 6);
        long i = 0;
        for(Material m : Material.values()){
            if(m.isSolid()){
                i = i+player.getStatistic(Statistic.MINE_BLOCK, m);
            }
        }
        setScore("§e"+String.valueOf(i),5);
        setScore("    ",4);
        setScore("   ",3);
        setScore("  ",2);
        setScore("§c⤛ §fHosted by §9noga§7.§9one §c⤜",1);
        setScore(" ",0);

    }

    public void updateBlocks(Player player){
        long i = 0;
        for(Material m : Material.values()){
            if(m.isSolid()){
                i = i+player.getStatistic(Statistic.MINE_BLOCK, m);
            }
        }
        setScore("§e"+String.valueOf(i),5);
    }

    @Override
    public void update() {

    }

    private void run(){
        new BukkitRunnable(){
            @Override
            public void run(){
                long i = 0;
                for(Material m : Material.values()){
                    if(m.isSolid()){
                        i = i+player.getStatistic(Statistic.MINE_BLOCK, m);
                    }
                }
                setScore("§e"+String.valueOf(i),5);
                setScore("§c"+player.getStatistic(Statistic.DEATHS),8);
            }
        }.runTaskTimer(Survival.getInstance(), 20,20);
    }

}
