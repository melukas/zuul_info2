import java.util.ArrayList;
import java.util.List;

/**
 * Klasse Spieler stellt den aktuellen Spieler da
 */
public class Spieler {
    
    private String name;
    
    private Abteilung aktuelleAbteilung;
    
    private List<Schluessel> inventar;
    
    private List<Stoppersocken> socken;
    
    /**
     * Konstruktor der Klasse Spieler
     * @param name Name des Spielers
     */
    public Spieler(String name) {
        this.name = name;
        this.inventar = new ArrayList<>();
        this.socken = new ArrayList<>();
    }

    /**
     * Methode gibt alle Schlüssel die sich 
     * im Inventar des Spielers befinden zurück.
     * @return Liste von Schlüsseln
     */
    public List<Schluessel> getInventar() {
        return inventar;
    }

    /**
     * Methode setzt das Inventar der Schlüssel beim
     * Spieler auf das übergebene Inventar.
     */
    public void setInventar(List<Schluessel> inventar) {
        this.inventar = inventar;
    }

    /**
     * Methode gibt die Abteilung zurück, in der sich der Spieler gerade befindet,
     * @return aktuelle Abteilung
     */
    public Abteilung getAktuelleAbteilung() {
        return aktuelleAbteilung;
    }

    /**
     * Methode setzt die Abteilung in der sich der Spieler befindet
     * auf die übergebene Abteilung.
     * @param aktuelleAbteilung neue Abteilung
     */
    public void setAktuelleAbteilung(Abteilung aktuelleAbteilung) {
        this.aktuelleAbteilung = aktuelleAbteilung;
    }

    /**
     * Methode gibt den Namen des Spielers zurück.
     * @return Name des Spielers
     */
    public String getName() {
        return name;
    }
    
    /**
     * Methode gibt das Stoppersocken-Inventar des Spielers zurück.
     * @return Liste aus Stoppersocken
     */
    public List<Stoppersocken> getStoppersocken(){
       return socken;
    }
    
    public void setStoppersocken(List<Stoppersocken> stoppersocken) {
        this.socken = stoppersocken;
    }
    
}
