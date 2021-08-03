package de.mvnuuh.minecraft.survival.utils;


import de.mvnuuh.minecraft.survival.Survival;

import java.util.HashMap;

public class Config{

    private HashMap<String, String> mongo = new HashMap<>();
    private HashMap<String, HashMap<String, String>> commands = new HashMap<>();

    public Config(){
        initMongo();
        initCommands();

    }
    public Config(HashMap<String, String> mongo, HashMap<String, HashMap<String, String>> commands){
        this.mongo = mongo;
        this.commands = commands;

    }

    private void initMongo(){
        mongo.put("host","127.0.0.1");
        mongo.put("port","27017");
        mongo.put("username","user");
        mongo.put("password","password");
        mongo.put("database","database");
    }

    private void initCommands(){
        HashMap<String, String> broadcast = new HashMap<>();
        broadcast.put("prefix", "&9Broadcast &7| ");
        broadcast.put("message", "&c&l%message%");
        broadcast.put("error", "&cError &7| &r Verwendung: &6/bc &a<Nachricht>&r");
        commands.put("broadcast", broadcast);
        HashMap<String, String> ip = new HashMap<>();
        ip.put("prefix", "&eIP &7| ");
        ip.put("message", "&7Die IP-Adresse von &6%player% &7lautet &9%ip%&7.");
        ip.put("error", "&cError &7| &r Spieler nicht gefunden.");
        commands.put("ip", ip);
        HashMap<String, String> stats = new HashMap<>();
        stats.put("prefix", "&6Stats &7| ");
        stats.put("message", "&7Die Statistiken von &9%player%&7:\n&6- &7Abgebaute Blöcke: &6%blocks%\n&6- &7Level: &6%level%\n&6- &7Tode: &6%deaths%");
        stats.put("error", "&cError &7| &r Spieler nicht gefunden.");
        commands.put("stats", stats);
        HashMap<String, String> scoreboard = new HashMap<>();
        scoreboard.put("prefix", "&eScoreboard &7| ");
        scoreboard.put("message", "&7Das Scoreboard wurde %status%&7.");
        commands.put("scoreboard", scoreboard);
        HashMap<String, String> reload = new HashMap<>();
        reload.put("prefix", "&4Reload &7| ");
        reload.put("message", "&7Die Konfiguration wurde neu geladen.");
        commands.put("reload", reload);
    }

    public HashMap<String, String> getMongoConfig(){return mongo;}
    public String getCommandsConfig(String command, String key){
        return commands.get(command).get(key).replace("&","§");
    }
}
