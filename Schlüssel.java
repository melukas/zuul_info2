 import java.util.Random;

public class Schlüssel {
	
	private long key;
	
	public Schlüssel() {
		Random rar = new Random();
		this.key = rar.nextLong();
	}
	
	public long getKey() {
		return key;
	}

}
