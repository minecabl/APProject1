package jobsplugin.jobs;

import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import jobsplugin.jobs.core.Session;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Jobs extends JavaPlugin {

    //Jobs-Objekt um auf das gesamte Plugin zugreifen zu können
    public static Jobs INSTANCE;

    //Prefix zur Kennzeichnung von allen Plugin-Related dingen
    public static final String PREFIX = "[§aJOBS]§7 : ";



    @Override
    public void onEnable() {
        // Plugin startup logic

        this.register();

        //Instanz wird gesetzt, sobald Plugin geladen wird.
        INSTANCE = this;

        //Session instanz zum Speichern und Managen von Daten erstellen
        Session jplayers = new Session();

        //DB Verbindung herstellen WIP
        establishDBConnection();

        log("Plugin wurde geladen");

    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log("Plugin wurde entladen");
    }


    //Zum senden von Nachrichten an die Konsole
    public static void log(String nachricht) {
        Bukkit.getConsoleSender().sendMessage(PREFIX+nachricht);
    }

    //Registrieren von Events und Commands
    private void register() {
        PluginManager PM = Bukkit.getPluginManager();
    }

    public static void establishDBConnection(){
        String uri = "mongodb://181.214.231.116:27017";

        MongoClient mongoClient = MongoClients.create(uri);

        MongoDatabase database = mongoClient.getDatabase("usersDB");

        database.createCollection("users");
    }
}

