package de.mvnuuh.minecraft.survival.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.mvnuuh.minecraft.survival.Survival;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.google.gson.Gson;

public class StorageHandler {
    private final JavaPlugin plugin = Survival.getInstance();
    private final Path PATH;
    private Path FILE;
    protected final Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
    private Object object;


    public StorageHandler(File PATH, String FILE){
        this.PATH = PATH.toPath();
        this.FILE = Paths.get(this.PATH+"/"+FILE);

        init();
    }
    private void init(){
        try{
            if(!Files.exists(PATH))
                Files.createDirectory(PATH);
            if(!Files.exists(FILE)){
                Files.createFile(FILE);
                save(new Config());
            }
        }
        catch(Exception e) {e.printStackTrace();}
        open();
    }

    public void open(){
        try {
            object = gson.fromJson(Files.readString(FILE), Config.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void save(Object objct){
        try{
            Writer WRITER = new OutputStreamWriter(new FileOutputStream(FILE.toFile()), StandardCharsets.UTF_8);
            gson.toJson(objct, WRITER);
            WRITER.close();
        }
        catch(Exception e) {e.printStackTrace();}
    }

    public Object get(){
        return object;
    }

}
