import java.util.Random;

public class Schlüssel extends Gegenstand {
	
	private long key;
	
	public Schlüssel() {
	    super("Schlüssel");
		Random rar = new Random();
		this.key = rar.nextLong();
		
	}
	
	public long getKey() {
		return key;
	}
}
