import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * Abgeleitete Klasse Hausmeister von der Klasse NPC.
 * @author Lukas Kiffmeyer, Marie Hölscher
 * @version 1
 */
public class Hausmeister extends NPC
{
    private String antwort;
    
     /**
     * Konstruktor der Klasse Hausmeister
     * @param name Name des Hausmeisters
     * @param aktuelleAbteilung Abteilung des Hausmeisters
     * @param spielverwaltung Spielverwaltung
     */
    public Hausmeister(String name, Abteilung aktuelleAbteilung,Spielverwaltung spielverwaltung) {
        super(name, aktuelleAbteilung, spielverwaltung);
    }

    
    /**
     * Methode die Aktion ausführt wenn der Spiele auf den Hausmeister getroffen ist.
     * Der Spieler muss eine Frage richtig beantworten um in die Abteilung eintreten zu können.
     * @param sp Spieler
     */
    public String treffeSpieler(Spieler sp) {
        StringBuilder st = new StringBuilder();
        st.append("*** *** ***\n");
        
        st.append("Moooooooin!!!\n");
        st.append("Sie sind auf den Hausmeister "+getName()+" getroffen!\n\n");
        st.append("Um hier durch zu kommen, musst du mir eine Frage beantworten!\n");
        st.append("Was ist Fu Fu?\n");
        st.append("a: Türkischer Milchreis\n");
        st.append("b: Suppe aus Vietnam\n");
        st.append("c: Afrikanische Beilage\n");
        
        
        System.out.println(st.toString());
        st = new StringBuilder();
        BufferedReader eingabe = new BufferedReader(new InputStreamReader(System.in));
        try {
            antwort = eingabe.readLine();
        }
        catch(Exception e) {
            return("Es ist folgender ein Fehler aufgetreten: "+e.getMessage());
        }

        if(antwort.equals("c")){
            st.append("Richtige Antwort!\nSuper, du hast es geschafft, der Hausmeister lässt dich vorbei.");
            getSpielverwaltung().npcLoeschen(this);
            return st.toString();
        }else{
            if(sp.getVorherigeAbteilung()!=null){
                sp.setAktuelleAbteilung(sp.getVorherigeAbteilung());
            }
            st.append("Das war leider die falsche Antwort! \nSo lässt dich der Hausmeister nicht vorbei.");
            return st.toString();
        }
    }    
}