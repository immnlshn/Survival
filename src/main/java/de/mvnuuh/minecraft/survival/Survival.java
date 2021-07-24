package de.mvnuuh.minecraft.survival;

import de.mvnuuh.minecraft.survival.commands.*;
import de.mvnuuh.minecraft.survival.listener.JoinQuitListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public final class Survival extends JavaPlugin {
    private static Survival instance;

    @Override
    public void onLoad(){
        instance = this;
    }

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§7[§eSurvival§7]§r Coded by "+ChatColor.GOLD+"maaanuuuuu");
        ListenerRegistration();
        getCommand("ip").setExecutor(new ipCommand());
        getCommand("test").setExecutor(new TestCommand());
        getCommand("bc").setExecutor(new BroadcastCommand());
        getCommand("stats").setExecutor(new StatsCommand());
        getCommand("togglescoreboard").setExecutor(new ToggleScoreboardCommand());
        getCommand("spawnvillager").setExecutor(new SpawnVillagerCommand());
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§7[§eSurvival§7]§r Good Night!");
    }

   private void ListenerRegistration(){
        PluginManager pluginmanager = Bukkit.getPluginManager();
        pluginmanager.registerEvents(new JoinQuitListener(), this);
    }

    public static Survival getInstance() {
        return instance;
    }
}
