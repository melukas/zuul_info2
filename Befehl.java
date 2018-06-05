 import java.util.List;
import java.util.Map;

class Befehl
{
    private Grundbefehl grundbefehl;
    private Befehlsdetail detail;
    
    private static Map<Grundbefehl, List<Befehlsdetail>> befehlListe;
    
    public static void setBefehle(Map<Grundbefehl, List<Befehlsdetail>> befehle) {
    	befehlListe = befehle;
    }

    public Befehl(Grundbefehl grundbefehl, Befehlsdetail detail)
    {
    	this.grundbefehl = grundbefehl;
        this.detail = detail;
    }
    

    public Grundbefehl getGrundbefehl()
    {
        return grundbefehl;
    }

    public Befehlsdetail getBefehlsdetail()
    {
        return detail;
    }
    
    public static Map<Grundbefehl, List<Befehlsdetail>> getBefehlListe(){
        return befehlListe;
    }
    
    public boolean istGueltigerBefehl() {
    	if(befehlListe.containsKey(grundbefehl)) {
    		if(detail!=null) {
    			if(befehlListe.get(grundbefehl).contains(detail)) {
    				return true;
    			}
    		} else {
    			return true;
    		}
    	}
    	return false;
    }
    
    

}

