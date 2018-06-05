import java.util.ArrayList;
import java.util.List;

public class Spieler {
	
	private String name;
	
	private Abteilung aktuelleAbteilung;
	
	private List<Schlüssel> inventar;
	
	public Spieler(String name) {
		this.name = name;
		this.inventar = new ArrayList<>();
	}

	public List<Schlüssel> getInventar() {
		return inventar;
	}

	public void setInventar(List<Schlüssel> inventar) {
		this.inventar = inventar;
	}

	public Abteilung getAktuelleAbteilung() {
		return aktuelleAbteilung;
	}

	public void setAktuelleAbteilung(Abteilung aktuelleAbteilung) {
		this.aktuelleAbteilung = aktuelleAbteilung;
	}

	public String getName() {
		return name;
	}
	
	
	

}
