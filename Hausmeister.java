import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Hausmeister extends NPC
{
    private String antwort;
    public Hausmeister(String name, Abteilung aktuelleAbteilung,Spielverwaltung spielverwaltung) {
        super(name, aktuelleAbteilung, spielverwaltung);
    }

    public String treffeSpieler(Spieler sp) {
        StringBuilder st = new StringBuilder();
        st.append("*** *** ***\n");
        st.append("Muhahaha!!!\n");
        st.append("Hausmeisterspruch!\n");
        st.append("Sie sind auf den Hausmeister "+getName()+" getroffen!\n\n");
        st.append("Um hier durch zu kommen, musst du mir eine Frage beantworten!\n");
        st.append("Welche Birne wird nicht faul?\n");
        System.out.println(st.toString());
        st = new StringBuilder();
        BufferedReader eingabe = new BufferedReader(new InputStreamReader(System.in));
        try {
            antwort = eingabe.readLine();
        }
        catch(Exception e) {
            return("Es ist folgender ein Fehler aufgetreten: "+e.getMessage());
        }

        if(antwort.equals("Glühbirne")){
            st.append("Richtige Antwort!\nSuper, du hast es geschafft, der Hausmeister lässt dich vorbei.");
            getSpielverwaltung().npcLoeschen(this);
            return st.toString();
        }else{
            if(sp.getVorherigeAbteilung()!=null){
                sp.setAktuelleAbteilung(sp.getVorherigeAbteilung());
            }
            st.append("Das war leider die falsche Antwort! \nSo lässt dich der Hausmeister nicht vorbei.");
            return st.toString();
        }
    }    
}