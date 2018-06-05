import java.util.Random;

public class Schluessel extends Gegenstand {
	
	private long key;
	
	public Schluessel() {
	    super("Schluessel");
		Random rar = new Random();
		this.key = rar.nextLong();
		
	}
	
	public long getKey() {
		return key;
	}
}
