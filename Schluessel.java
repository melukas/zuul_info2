import java.util.Random;

/**
 * Klasse Schlüssel, abgeleitet von Gegenstand. 
 * Schlüssel werden benötigt um in Abteilung zu gelingen.
 * @author Lukas Kiffmeyer, Marie Hölscher
 * @version 1
 */
public class Schluessel extends Gegenstand {
	
	private long key;
	
	/**
	 * Konstruktor der Klasse Schluessel
	 */
	public Schluessel() {
	    super("Schluessel");
		Random rar = new Random();
		this.key = rar.nextLong();
		
	}
	
	/**
	 * Methode gibt den Key des Schluesssel zurück.
	 * @return Key
	 */
	public long getKey() {
		return key;
	}
}
