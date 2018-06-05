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
    private Schlüssel schlüssel;
    private List<Schlüssel> fundsachen;
    private boolean istAußenwelt = false;
    
    public Abteilung(String name) 
    {
        this.name = name;
        durchgaenge = new HashMap<>();
    }
    
    public void setzeSchlüssel(Schlüssel key) {
    	this.schlüssel = key;
    }
    
    public void setzeFundsachen(List<Schlüssel> fundsachen) {
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
        String ergebnis = "Durchgänge:";
        Set<Befehlsdetail> keys = durchgaenge.keySet();
        for(Iterator<Befehlsdetail> iter = keys.iterator(); iter.hasNext(); )
            ergebnis += " " + iter.next();
        return ergebnis;
    }
    
    public boolean getIstAußenwelt() {
    	return istAußenwelt;
    }
    
    public void setIstAußenwelt(boolean istAußenwelt) {
    	this.istAußenwelt = istAußenwelt;
    }
    
    public boolean istAbgeschlossen() {
    	return this.schlüssel != null;
    }
    
    public List<Schlüssel> nehmeFundsachen(){
    	List<Schlüssel> var = fundsachen;
    	fundsachen = new ArrayList<>();
    	return var;
    }
    
    public List<Schlüssel> zutrittErlaubt(List<Schlüssel> key) {
    	if(schlüssel!=null) {
    		if(key.contains(schlüssel)) {
    			key.remove(schlüssel);
    			this.schlüssel = null;
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

