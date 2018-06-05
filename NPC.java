import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class NPC {
	
	private Abteilung aktuelleAbteilung;
	private String name;
	private Spielverwaltung spielverwaltung;
	
	public NPC(String name, Abteilung aktuelleAbteilung, Spielverwaltung spielverwaltung) {
		this.aktuelleAbteilung = aktuelleAbteilung;
		this.spielverwaltung = spielverwaltung;
		this.name = name;
	}
	
	public Abteilung wechsleAbteilung() {
		List<Befehlsdetail> räume = Arrays.asList(Befehlsdetail.values());
		Random rar = new Random();
		Befehlsdetail neueRichtung = räume.get(rar.nextInt(räume.size()));
		if(this.aktuelleAbteilung.durchgangVorhanden(neueRichtung)) {
			this.aktuelleAbteilung = aktuelleAbteilung.gibDurchgang(neueRichtung);
			Spiel.console(getName()+":"+this.aktuelleAbteilung.gibName());
			return this.aktuelleAbteilung;
		}
		else {
			return wechsleAbteilung();
		}
	}

	public abstract String treffeSpieler(Spieler sp);

	public Abteilung getAktuelleAbteilung() {
		return aktuelleAbteilung;
	}

	protected void setAktuelleAbteilung(Abteilung aktuelleAbteilung) {
		this.aktuelleAbteilung = aktuelleAbteilung;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected Spielverwaltung getSpielverwaltung() {
		return spielverwaltung;
	}

	protected void setSpielverwaltung(Spielverwaltung spielverwaltung) {
		this.spielverwaltung = spielverwaltung;
	}
	
	

}
