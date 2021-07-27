package de.mvnuuh.minecraft.survival.utils;

import de.mvnuuh.minecraft.survival.Survival;
import org.bukkit.plugin.java.JavaPlugin;

import java.beans.JavaBean;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class StorageHandler {
    private final JavaPlugin plugin = Survival.getInstance();
    private final String filename = "config.json";
    private final File file = new File(plugin.getDataFolder(), filename);


    public StorageHandler(){
        if(!file.exists()){
            file.getParentFile().mkdirs();
            if (plugin.getResource(filename) == null) {
                try {
                    file.createNewFile();
                } catch (IOException err) {
                    err.printStackTrace();
                }
            }

        }
    }
}
