import java.util.ArrayList;
import java.util.List;

public class Spieler {
    
    private String name;
    
    private Abteilung aktuelleAbteilung;
    
    private List<Schluessel> inventar;
    
    private List<Stoppersocken> socken;
    
    public Spieler(String name) {
        this.name = name;
        this.inventar = new ArrayList<>();
        this.socken = new ArrayList<>();
    }

    public List<Schluessel> getInventar() {
        return inventar;
    }

    public void setInventar(List<Schluessel> inventar) {
        this.inventar = inventar;
    }

    public Abteilung getAktuelleAbteilung() {
        return aktuelleAbteilung;
    }

    public void setAktuelleAbteilung(Abteilung aktuelleAbteilung) {
        this.aktuelleAbteilung = aktuelleAbteilung;
    }

    public String getName() {
        return name;
    }
    
       
    public List<Stoppersocken> getStoppersocken(){
       return socken;
    }
    
    public void setStoppersocken(List<Stoppersocken> stoppersocken) {
        this.socken = stoppersocken;
    }
    
}
