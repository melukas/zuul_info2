 import java.util.List;
import java.util.Map;

/**
 * Klasse Befehl stellt die Eingabe des Spielers dar. 
 * Aufgeteilt in Grundbefehl + eventuell Befehlsdeatil.
 * @author Lukas Kiffmeyer, Marie Hölscher
 * @version 1
 */
class Befehl
{
    private Grundbefehl grundbefehl;
    private Befehlsdetail detail;
    
    private static Map<Grundbefehl, List<Befehlsdetail>> befehlListe;
    
     /**
     * Statische Methode um Befehlskombination der Befehlsliste hinzuzufügen.
     * @param befehle Map aus Grundbefehl + Befehlsdetail
     */
    public static void setBefehle(Map<Grundbefehl, List<Befehlsdetail>> befehle) {
        befehlListe = befehle;
    }

    /**
     * Konstruktor der Klasse Befehl.
     * @param grundbefehl Grundbefehl
     * @param detail Befehlsdetail
     */
    public Befehl(Grundbefehl grundbefehl, Befehlsdetail detail)
    {
        this.grundbefehl = grundbefehl;
        this.detail = detail;
    }
    
    
    /**
     * Methode gibt den Grundbefehl dieses Befehles zurück.
     * @return Grundbefehl
     */
    public Grundbefehl getGrundbefehl()
    {
        return grundbefehl;
    }

    /**
     * Methode gibt das Befehlsdetail zurück.
     * @return Befehlsdetail
     */
    public Befehlsdetail getBefehlsdetail()
    {
        return detail;
    }
    
    /**
     * Methode gibt den Befehl als Map zurück.
     * @return Befehl bestehend aus Grundbefehl, Befehlsdetail
     */
    public static Map<Grundbefehl, List<Befehlsdetail>> getBefehlListe(){
        return befehlListe;
    }
    
    
    /**
     * Methode überprüft ob es sich um einen gültigen Befehl handelt.
     * @return Ob der Befehl gültig ist
     */
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

