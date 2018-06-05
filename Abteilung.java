import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Abteilung 
{
    private String name;
    private Map<Befehlsdetail,Abteilung> durchgaenge;
    private Schluessel schluessel;
    private List<Schluessel> fundsachen;
    private boolean istAußenwelt = false;
    private List<Stoppersocken> socken;
    
    public Abteilung(String name) 
    {
        this.name = name;
        durchgaenge = new HashMap<>();
    }
    
    public void setzeSchluessel(Schluessel key) {
        this.schluessel = key;
    }
    
    public void setzeFundSocken(List<Stoppersocken> socken){
        this.socken = socken;
    }
    
    public void setzeFundsachen(List<Schluessel> fundsachen) {
        this.fundsachen = fundsachen;
    }

    public void setzeAusgang(Befehlsdetail richtung, Abteilung abteilung) 
    {
        durchgaenge.put(richtung, abteilung);
        abteilung.durchgaenge.put(Befehlsdetail.getGegenteil(richtung), this);
    }

    public String gibName()
    {
        return name;
    }

    public String gibLangeBeschreibung()
    {
        return "Ihre aktuelle Abteilung: \"" + name + "\"\n" + gibAbteilungenAlsString()+"\n";
    }

    private String gibAbteilungenAlsString()
    {
        String ergebnis = "Durchg�nge:";
        Set<Befehlsdetail> keys = durchgaenge.keySet();
        for(Iterator<Befehlsdetail> iter = keys.iterator(); iter.hasNext(); )
            ergebnis += " " + iter.next();
        return ergebnis;
    }
    
    public boolean getIstAußenwelt() {
        return istAußenwelt;
    }
    
    public List<Stoppersocken> getSocken(){
         List<Stoppersocken> var = socken;
         socken = new ArrayList<>();
         return var;
    }
    
    public void setIstAußenwelt(boolean istAußenwelt) {
        this.istAußenwelt = istAußenwelt;
    }
    
    public boolean istAbgeschlossen() {
        return this.schluessel != null;
    }
    
    public List<Schluessel> nehmeFundsachen(){
        List<Schluessel> var = fundsachen;
        fundsachen = new ArrayList<>();
        return var;
    }
    
    public List<Schluessel> zutrittErlaubt(List<Schluessel> key) {
        if(schluessel!=null) {
            if(key.contains(schluessel)) {
                key.remove(schluessel);
                this.schluessel = null;
            }
            return key;
        }
        return null;
        
    }
    
    
    
    public boolean durchgangVorhanden(Befehlsdetail richtung) {
        if(durchgaenge.containsKey(richtung)) {
            return true;
        }
        else {
            return false;
        }
    }

    public Abteilung gibDurchgang(Befehlsdetail richtung) 
    {
        return durchgaenge.get(richtung);
    }
}

