package de.mvnuuh.minecraft.survival;

import de.mvnuuh.minecraft.survival.commands.*;
import de.mvnuuh.minecraft.survival.database.DatabaseHandler;
import de.mvnuuh.minecraft.survival.listener.BedSleepListener;
import de.mvnuuh.minecraft.survival.listener.JoinQuitListener;
import de.mvnuuh.minecraft.survival.listener.ShopHandler;
import de.mvnuuh.minecraft.survival.utils.Config;
import de.mvnuuh.minecraft.survival.utils.StorageHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public final class Survival extends JavaPlugin {
    private static Survival instance;
    private static StorageHandler storageHandler;
    private static Config config;
    private static DatabaseHandler databaseHandler;



    @Override
    public void onLoad(){
        instance = this;
        storageHandler = new StorageHandler(Survival.getInstance().getDataFolder(),"config.json");
        config = (Config) storageHandler.get();
        databaseHandler = new DatabaseHandler();
    }

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§7--------------------------------------------------------");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§7[§dSurvival§7]§r Coded by "+ChatColor.GOLD+"maaanuuuuu");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§7--------------------------------------------------------");
        Bukkit.getConsoleSender().sendMessage("§7[§dSurvival§7]§r Initializing configuration file.");
        Bukkit.getConsoleSender().sendMessage("§7[§dSurvival§7]§r Initializing listeners.");
        ListenerRegistration();
        Bukkit.getConsoleSender().sendMessage("§7[§dSurvival§7]§r Initializing commands.");
        getCommand("ip").setExecutor(new ipCommand());
        getCommand("test").setExecutor(new TestCommand());
        getCommand("bc").setExecutor(new BroadcastCommand());
        getCommand("stats").setExecutor(new StatsCommand());
        getCommand("togglescoreboard").setExecutor(new ToggleScoreboardCommand());
        getCommand("spawnvillager").setExecutor(new SpawnVillagerCommand());
        getCommand("sreload").setExecutor(new reloadCommand());
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§7[§eSurvival§7]§r Good Night!");
    }

   private void ListenerRegistration(){
        PluginManager pluginmanager = Bukkit.getPluginManager();
        pluginmanager.registerEvents(new JoinQuitListener(), this);
        pluginmanager.registerEvents(new ShopHandler(), this);
        pluginmanager.registerEvents(new BedSleepListener(), this);
    }

    public static Survival getInstance() {
        return instance;
    }
    public static StorageHandler getStorageHandler() {
        return storageHandler;
    }
    public static Config getConfiguration() {
        return config;
    }
    public static void reloadConfiguration(){
        storageHandler.open();
        config = (Config) storageHandler.get();
    }
}
