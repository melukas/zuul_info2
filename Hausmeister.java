public class Hausmeister extends NPC
{
    public Hausmeister(Abteilung aktuelleAbteilung,Spielverwaltung spielverwaltung) {
        super(aktuelleAbteilung, spielverwaltung);
    }

    public boolean treffeSpieler(Spieler sp) {
        return false;
        
    }    
}