package de.mvnuuh.minecraft.survival;

import de.mvnuuh.minecraft.survival.commands.BroadcastCommand;
import de.mvnuuh.minecraft.survival.commands.LevelCommand;
import de.mvnuuh.minecraft.survival.commands.TestCommand;
import de.mvnuuh.minecraft.survival.commands.ipCommand;
import de.mvnuuh.minecraft.survival.listener.BlockMined;
import de.mvnuuh.minecraft.survival.listener.JoinQuitListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public final class Survival extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§7[§eSurvival§7]§r Coded by "+ChatColor.GOLD+"maaanuuuuu");
        ListenerRegistration();
        getCommand("ip").setExecutor(new ipCommand());
        getCommand("test").setExecutor(new TestCommand());
        getCommand("bc").setExecutor(new BroadcastCommand());
        getCommand("level").setExecutor(new LevelCommand());
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§7[§eSurvival§7]§r Good Night!");
    }

   private void ListenerRegistration(){
        PluginManager pluginmanager = Bukkit.getPluginManager();
        pluginmanager.registerEvents(new JoinQuitListener(), this);
        pluginmanager.registerEvents(new BlockMined(), this);
    }
}
