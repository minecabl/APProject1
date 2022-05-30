/*
    Name: Session.java
    Erstellt am: 15.05.2022
    Zuletzt geändert: 15.05.2022
    Author: Kapsreiter
    Beschreibung: Session Klasse zur Verknüpfung von normalen Bukkit-Spielern und Jobs-Spielern
*/

package jobsplugin.jobs.core;

import jobsplugin.jobs.Jobs;
import jobsplugin.jobs.core.JobsPlayer;
import org.bukkit.entity.Player;

import java.util.UUID;
import java.util.HashMap;

public class Session {
    //UUID des Spielers wird mit JobsPlayer Objekt verknüpft, so ist eine zuweisung möglich ohne diese dauerhaft während des betriebs aus der Datenbank auszulesen
    private HashMap<UUID, JobsPlayer> SESSION;

    public Session()  {
        SESSION = new HashMap<UUID, JobsPlayer>();
    }

    public void addPlayer(Player p){
        this.SESSION.put(p.getUniqueId(), new JobsPlayer(p));
        Jobs.log(p.getName()+" wurde Session hinzugefügt");
    }

    public void removePlayer(Player p){
        //TODO: Möglicherweiße hier direkt das Speichern des Spielers?
        SESSION.remove(p.getUniqueId());
        Jobs.log(p.getName()+" wurde aus der Session entfernt");
    }

}
