import java.util.TimerTask;
/**
 * Beschreiben Sie hier die Klasse Zeitsteuerung.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Zeitsteuerung extends TimerTask
{
    
    private Spielverwaltung verwaltung;
    
    public Zeitsteuerung(Spielverwaltung verwaltung){
        
        this.verwaltung = verwaltung;
    }
    public void run(){
        if(verwaltung!=null){
            verwaltung.beendeSpiel();
        }
    }

}
