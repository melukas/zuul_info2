public class Putzfrau extends NPC
{
    public Putzfrau(Abteilung aktuelleAbteilung,Spielverwaltung befehlsverarbeitung) {
    super(aktuelleAbteilung, befehlsverarbeitung);
    }

    public boolean treffeSpieler(Spieler sp) {
        return false;
    }
}
