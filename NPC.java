import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class NPC {
	
	private Abteilung aktuelleAbteilung;
	private Spielverwaltung spielverwaltung;
	
	public NPC(Abteilung aktuelleAbteilung, Spielverwaltung spielverwaltung) {
		this.aktuelleAbteilung = aktuelleAbteilung;
		this.spielverwaltung = spielverwaltung;
	}
	
	public Abteilung wechsleAbteilung() {
		List<Befehlsdetail> räume = Arrays.asList(Befehlsdetail.values());
		Random rar = new Random();
		Befehlsdetail neueRichtung = räume.get(rar.nextInt(räume.size()));
		if(this.aktuelleAbteilung.durchgangVorhanden(neueRichtung)) {
			this.aktuelleAbteilung = aktuelleAbteilung.gibDurchgang(neueRichtung);
			return this.aktuelleAbteilung;
		}
		else {
			return wechsleAbteilung();
		}
	}
	
	public abstract boolean treffeSpieler(Spieler sp);

}
