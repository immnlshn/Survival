package de.mvnuuh.minecraft.survival.database;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import de.mvnuuh.minecraft.survival.Survival;
import de.mvnuuh.minecraft.survival.utils.Config;

public class DatabaseHandler {
    private final Config config = Survival.getConfiguration();
    private final MongoClient mongo;
    private MongoDatabase database;
    private MongoCollection warps;
    private MongoCollection users;
    public DatabaseHandler() {
        MongoClientURI url = new MongoClientURI("mongodb://" + config.getMongoConfig().get("username") + ":" + config.getMongoConfig().get("password") + "@" + config.getMongoConfig().get("host") + ":" + config.getMongoConfig().get("port"));
        mongo = new MongoClient(url);
        database = mongo.getDatabase("minecraft");
        warps = database.getCollection("warps");
        users = database.getCollection("users");

    }

    public void post(){

    }
}
