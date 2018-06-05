public class Hausmeister extends NPC
{
    public Hausmeister(String name, Abteilung aktuelleAbteilung,Spielverwaltung spielverwaltung) {
        super(name, aktuelleAbteilung, spielverwaltung);
    }

    public String treffeSpieler(Spieler sp) {
        return "Du bist auf den Hausmeister getroffen!\n";
        
    }    
}