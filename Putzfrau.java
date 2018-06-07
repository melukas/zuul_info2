
import java.util.Random;

/**
 * Klasse Putzfrau als Unterklasse des NPC.
 * @author Lukas Kiffmeyer, Marie Hölscher
 * @version 1
 */
public class Putzfrau extends NPC
{
    /**
     * Konstruktor der Klasse Putzfrau.
     * @param name Name der Putzfrau
     * @param aktuelleAbteilung Abteilung der Putzfrau
     * @param befehlsverarbeitung Spielverwaltung
     */
    public Putzfrau(String name, Abteilung aktuelleAbteilung,Spielverwaltung befehlsverarbeitung) {
    super(name, aktuelleAbteilung, befehlsverarbeitung);
    }

    /**
     * Methode die Aktion auslöst, wenn der Spieler auf die Putzfrau trifft. 
     * Wenn der Spieler keinen Stoppersocken hat, wird er in einen beliebigen 
     * Raum katapultiert. Ansonsten verschwindet die Putzfrau.
     * @param sp Spieler
     */
    public String treffeSpieler(Spieler sp) {
                StringBuilder st = new StringBuilder();
                st.append("*** *** ***\n");
		st.append("Muhahaha!!!\n");
		st.append("Fusse weg - musse putzen!\n");
		st.append("Sie sind auf die Putzfrau "+getName()+" getroffen!\n\n");
		
		if(sp.getStoppersocken().size() == 0) {
			Random rar = new Random();
			st.append("Leider sind Sie auf ihrem frisch gewischten Boden ausgerutscht");
			sp.setAktuelleAbteilung(getSpielverwaltung().getAbteilungen().get(rar.nextInt(getSpielverwaltung().getAbteilungen().size())));
			st.append(" und in der ");
			st.append(sp.getAktuelleAbteilung().gibName());
			st.append(" gelandet!");
			
		}
		else {
			st.append("Gut, dass sie Stoppersocken dabei hatten!\n");
			st.append("Sie sind nicht ausgerutscht und die Putzfrau ist verschwunden!\n");
			sp.setStoppersocken(null);
			getSpielverwaltung().npcLoeschen(this);
		}
		st.append("*** *** ***\n");
		return st.toString();
		
    }
}
