import java.util.Random;

public class Putzfrau extends NPC
{
    public Putzfrau(String name, Abteilung aktuelleAbteilung,Spielverwaltung befehlsverarbeitung) {
    super(name, aktuelleAbteilung, befehlsverarbeitung);
    }

    public String treffeSpieler(Spieler sp) {
                StringBuilder st = new StringBuilder();
		st.append("Muhahaha!!!\n");
		st.append("Fusse weg - musse putzen!\n");
		st.append("Sie sind auf die Putzfrau "+getName()+" getroffen!\n\n");
		
		if(sp.getStoppersocken() != null) {
			Random rar = new Random();
			st.append("Leider sind Sie auf ihrem firsch gewischten Boden ausgerutscht");
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
		
		return st.toString();
		
    }
}
