 public enum Befehlsdetail {
	oben, unten, vorne, hinten, rechts, links;
	
	public static Befehlsdetail getGegenteil(Befehlsdetail detail) {
		switch(detail) {
		case oben: return unten;
		case unten: return oben;
		case vorne: return hinten;
		case hinten: return vorne;
		case links: return rechts;
		case rechts: return links;
		default: return null;
		}
	}
}