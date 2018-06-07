import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Klasse Abteilung stellt eine einzelne Abteilung innerhalb
 * des Kaufhauses dar.
 */
class Abteilung 
{
    private String name;
    private Map<Befehlsdetail,Abteilung> durchgaenge;
    private Schluessel schluessel;
    private List<Schluessel> fundsachen;
    private boolean istAußenwelt = false;
    private List<Stoppersocken> socken;
    
    /**
     * Konstruktor der Klasse Abteilung.
     * @param name Name der Abteilung
     */
    public Abteilung(String name) 
    {
        this.name = name;
        durchgaenge = new HashMap<>();
        fundsachen = new ArrayList<>();
        socken = new ArrayList<>();
    }
    
    /**
     * Methode setzt den Schlüssel der Abteilung
     * @param key neuer Schlüssel
     */
    public void setzeSchluessel(Schluessel key) {
        this.schluessel = key;
    }
    

    /**
     * Methode setzt die Liste der gefundenen Stoppersocken neu.
     * @param socken Liste der neuen Stoppersocken
     */    
    public void setzeFundSocken(List<Stoppersocken> socken){
        this.socken = socken;
    }
    
    /**
     * Methode setzt die Liste der gefundenen Schlüssel neu.
     * @param fundsachen Liste der neuen Schlüssel
     */
    public void setzeFundsachen(List<Schluessel> fundsachen) {
        this.fundsachen = fundsachen;
    }

     /**
     * Methode setzt alle Ausgaenge eines bestimmten Raumes, 
     * sowie die anschließenden Räume auf die Gegensätze.
     * @param richtung Ausgangsrichtung
     * @param abteilung Abteilung
     */
    public void setzeAusgang(Befehlsdetail richtung, Abteilung abteilung) 
    {
        durchgaenge.put(richtung, abteilung);
        abteilung.durchgaenge.put(Befehlsdetail.getGegenteil(richtung), this);
    }

    /**
     * Methode gibt den Namen der Abteilung zurück.
     * @return Name der Abteilung
     */
    public String gibName()
    {
        return name;
    }

    /**
     * Methode gibt die lange Beschreibugn der Abteilung zurück.
     * @return lange Beschreibung
     */
    public String gibLangeBeschreibung()
    {
        return "Ihre aktuelle Abteilung: \"" + name + "\"\n" + gibAbteilungenAlsString()+"\n";
    }

    
    private String gibAbteilungenAlsString()
    {
        String ergebnis = "Durchgänge:";
        Set<Befehlsdetail> keys = durchgaenge.keySet();
        for(Iterator<Befehlsdetail> iter = keys.iterator(); iter.hasNext(); )
            ergebnis += " " + iter.next();
        return ergebnis;
    }
    
    /**
     * Methode überprüft ob man sich beim Ausgang befindet.
     * @return Ob man sich am Ausgang befindet
     */
    public boolean getIstAußenwelt() {
        return istAußenwelt;
    }
    
    /**
     * Methode gibt die Liste der Stoppersocken zurück die sich 
     * in dem Raum befinden
     */
    public List<Stoppersocken> getSocken(){
         List<Stoppersocken> var = socken;
         socken = new ArrayList<>();
         return var;
    }
    
    /**
     * Methode verändert ob die Abteilung der Ausgang ist oder nicht.
     * @param istAußenwelt Ob es sich um den Ausgang handelt
     */
    public void setIstAußenwelt(boolean istAußenwelt) {
        this.istAußenwelt = istAußenwelt;
    }
    
    /**
     * Methode gibt zurück ob diese Abteilung abgeschlossen 
     * ist oder nicht
     * @return Abgeschlossen oder nicht
     */
    public boolean istAbgeschlossen() {
        return this.schluessel != null;
    }
    
    /**
     * Methode gibt die Schlüssel die sich in 
     * dieser Abteilung verstecken zurück
     * @return Liste von Schlüsseln
     */
    public List<Schluessel> nehmeFundsachen(){
        List<Schluessel> var = this.fundsachen;
        this.fundsachen = new ArrayList<>();
        return var;
    }
    
    /**
     * 
     */
    public List<Schluessel> zutrittErlaubt(List<Schluessel> key) {
        if(key.contains(schluessel)) {
                key.remove(schluessel);
                this.schluessel = null;
        }
            return key; 
    }
    
    
    /**
     * Methode überprüft ob zu einer bestimmten Richtung eine 
     * Abteilung vorhanden ist.
     * @param richtung Richtung in die überprüft werden soll
     * @return Ob ein Durchgang in der Richtung vorhanden
     */
    public boolean durchgangVorhanden(Befehlsdetail richtung) {
        if(durchgaenge.containsKey(richtung)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Methode gibt die Abteilung zurück, aus der jeweiligen Richtung.
     * @return Abteilung
     * 
     */
    public Abteilung gibDurchgang(Befehlsdetail richtung) 
    {
        return durchgaenge.get(richtung);
    }
}

