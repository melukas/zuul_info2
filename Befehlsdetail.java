/**
 * Darstellung von Möglichen Befehlsdetails von Befehlen
 */
public enum Befehlsdetail {
	oben, unten, sueden, norden, osten, westen;
	
	/**
	 * Gibt zu einem gegebenen Befehlsdetail (explizit Himmelsrichtungen)
	 * das gegenteilige Befehlsdetail.
	 */
	public static Befehlsdetail getGegenteil(Befehlsdetail detail) {
		switch(detail) {
		case oben: return unten;
		case unten: return oben;
		case sueden: return norden;
		case norden: return sueden;
		case westen: return osten;
		case osten: return westen;
		default: return null;
		}
	}
}