import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Abstrakte klasse der none-player-character. 
 * @author Lukas Kiffmeyer, Marie Hölscher
 * @version 1
 */
public abstract class NPC {
	
	private Abteilung aktuelleAbteilung;
	private String name;
	private Spielverwaltung spielverwaltung;
	
	/**
	 * Konstruktor der Klasse NPC.
	 * @param name Name des NPC
	 * @param aktuelleAbteilung Abteilung in der sich der NPC befindet
	 * @param spielverwaltung Spielverwaltung
	 */
	public NPC(String name, Abteilung aktuelleAbteilung, Spielverwaltung spielverwaltung) {
		this.aktuelleAbteilung = aktuelleAbteilung;
		this.spielverwaltung = spielverwaltung;
		this.name = name;
	}
	
	/**
	 * Methode zum Wechseln der Abteilung eines NPCs.
	 * @return neue Abteilung
	 */
	public Abteilung wechsleAbteilung() {
		List<Befehlsdetail> räume = Arrays.asList(Befehlsdetail.values());
		Random rar = new Random();
		Befehlsdetail neueRichtung = räume.get(rar.nextInt(räume.size()));
		if(aktuelleAbteilung.durchgangVorhanden(neueRichtung)) {
			aktuelleAbteilung = aktuelleAbteilung.gibDurchgang(neueRichtung);
			return aktuelleAbteilung;
		}
		else {
			return wechsleAbteilung();
		}
	}

	/**
	 * Methode zum Überprüfen ob ein Spieler angetroffen wurde.
	 * @param sp Spieler
	 */
	public abstract String treffeSpieler(Spieler sp);

	/**
	 * Methode gibt die aktulle Abteilung, in der sich 
	 * der NPC befindet zurück.
	 * @param Abteilung des NPC
	 */
	public Abteilung getAktuelleAbteilung() {
		return aktuelleAbteilung;
	}

	/**
	 * Methode setzt die aktuelle Abteilung des NPCs auf übergebene 
	 * Abteilung.
	 * @param aktuelleAbteilun neue Abteilung
	 */
	protected void setAktuelleAbteilung(Abteilung aktuelleAbteilun) {
		aktuelleAbteilung = aktuelleAbteilun;
	}

	/**
	 * Methode gibt den Namen des NPC zurück
	 * @return Name des NPC.
	 */
	protected String getName() {
		return name;
	}

	
	/**
	 * Methode zum Setzen des Namen des NPC.
	 * @param nam neuer Name
	 */
	protected void setName(String nam) {
		name = nam;
	}

	/**
	 * Methode gibt die zugehörige Spielverwaltung zurück.
	 * @return Spielverwaltung
	 */
	protected Spielverwaltung getSpielverwaltung() {
		return spielverwaltung;
	}

	
	/**
	 * Methode zum Setzen der zugehörigen Spielverwaltung
	 * @param spielverwaltung neue Spielverwaltung
	 */
	protected void setSpielverwaltung(Spielverwaltung spielverwaltung) {
		this.spielverwaltung = spielverwaltung;
	}
	
	

}
