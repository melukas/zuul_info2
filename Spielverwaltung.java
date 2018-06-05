import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Spielverwaltung {

    private Befehlsverarbeitung verarbeitung;
    private boolean quitBefehl;
    private Spieler spieler;
    private List<NPC> npcs;
    private List<Abteilung> abteilungen;


    public Spielverwaltung(String name) {
        quitBefehl = false;
        spieler = new Spieler(name);
        verarbeitung = new Befehlsverarbeitung();
        abteilungen = new ArrayList<>();
        npcs = new ArrayList<>();
        kaufhausAnlegen();
        befehlsSetup();
    }

    private void kaufhausAnlegen(){
        //Hauptsache weiblicher Artikel
        Abteilung a = new Abteilung("Aussichtsplattform");
        Abteilung b = new Abteilung("Sportartikelabteilung");
        Abteilung c = new Abteilung("Fernsehabteilung");
        Abteilung d = new Abteilung("Aufzugskammer");
        Abteilung e = new Abteilung("Musikabteilung");
        Abteilung f = new Abteilung("Feinkostabteilung");
        Abteilung g = new Abteilung("Restaurantplattform");
        Abteilung h = new Abteilung("Videothek");
        Abteilung i = new Abteilung("Besenkammer");
        Abteilung j = new Abteilung("Aufzugkammer");
        Abteilung k = new Abteilung("Damenmodeabteilung");
        Abteilung l = new Abteilung("Aufzugkammer");
        Abteilung m = new Abteilung("Spielwarenabteilung");
        Abteilung n = new Abteilung("Aufzugkammer");
        Abteilung o = new Abteilung("Kindermodeabteilung");
        Abteilung p = new Abteilung("Herrenmodeabteilung");
        Abteilung q = new Abteilung("Aufzugkammer");
        Abteilung r = new Abteilung("Verpackkungsabteilung");
        Abteilung s = new Abteilung("Parfümabteilung");
        Abteilung t = new Abteilung("Reiseabteilung");
        Abteilung u = new Abteilung("Gepäckabteilung");
        Abteilung v = new Abteilung("Tierwarenabteilung");
        Abteilung w = new Abteilung("Eisdiele");
        Abteilung x = new Abteilung("Schwimmbadabteilung");
        Abteilung y = new Abteilung("Ausgang");

        abteilungen.addAll(Arrays.asList(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y));

        spieler.setAktuelleAbteilung(a);

        a.setzeAusgang(Befehlsdetail.vorne, b);
        b.setzeAusgang(Befehlsdetail.links, c);
        c.setzeAusgang(Befehlsdetail.vorne, d);
        d.setzeAusgang(Befehlsdetail.rechts, e);
        e.setzeAusgang(Befehlsdetail.rechts, f);
        f.setzeAusgang(Befehlsdetail.hinten, g);
        g.setzeAusgang(Befehlsdetail.hinten, h);
        h.setzeAusgang(Befehlsdetail.links, b);
        i.setzeAusgang(Befehlsdetail.links, g);
        j.setzeAusgang(Befehlsdetail.hinten, i);
        l.setzeAusgang(Befehlsdetail.oben, j);
        l.setzeAusgang(Befehlsdetail.vorne, m);
        m.setzeAusgang(Befehlsdetail.vorne, o);
        m.setzeAusgang(Befehlsdetail.rechts, p);
        m.setzeAusgang(Befehlsdetail.links, k);
        o.setzeAusgang(Befehlsdetail.links, n);
        n.setzeAusgang(Befehlsdetail.unten, q);
        q.setzeAusgang(Befehlsdetail.vorne,r );
        r.setzeAusgang(Befehlsdetail.links,s );
        s.setzeAusgang(Befehlsdetail.vorne,t );
        t.setzeAusgang(Befehlsdetail.rechts,x );
        t.setzeAusgang(Befehlsdetail.vorne,u );
        u.setzeAusgang(Befehlsdetail.rechts,v );
        v.setzeAusgang(Befehlsdetail.rechts,w );
        x.setzeAusgang(Befehlsdetail.hinten,y );

        y.setIstAußenwelt(true);
        
        Stoppersocken socke = new Stoppersocken();   
        List<Stoppersocken> socken = new ArrayList<>();
        socken.add(socke);
        a.setzeFundSocken(socken);
        
        Schluessel a1 = new Schluessel();
        i.setzeSchluessel(a1);
        
        List<Schluessel> list1 = new ArrayList<>();
        list1.add(a1);
        e.setzeFundsachen(list1);
        
        Putzfrau p1 = new Putzfrau("Ursula", k, this);
	npcHinzufuegen(p1);
	Hausmeister h1 = new Hausmeister("Peter", u, this);
	npcHinzufuegen(h1);
    }

    private void befehlsSetup() {
        Map<Grundbefehl,List<Befehlsdetail>> befehle = new HashMap<>();
        List<Befehlsdetail> richtungen = new ArrayList<>();
        befehle.put(Grundbefehl.beenden, null);
        befehle.put(Grundbefehl.hilfe, null);
        befehle.put(Grundbefehl.suche, null);
        richtungen.addAll(Arrays.asList(Befehlsdetail.values()));
        befehle.put(Grundbefehl.gehe, richtungen);
        Befehl.setBefehle(befehle);
    }

    public void start() {
        spielBeginn();
        while(spielAktiv()) {
            verarbeiteBefehlsanfragen();
            bewegeNPCs();
        }
    }

    private void spielBeginn()
    {
        StringBuilder st = new StringBuilder();
        st.append("Herzlich Willkommen zum Kaufhaus-Spiel!\n\nSie befinden sich in einem Kaufhaus und müssen den Ausgang"+
        " finden. \nLeider wird Ihnen dies nicht so einfach fallen, \ndenn in den vielen verschiedenen Abteilungen gibt es viele Hindernisse. \n"+
        "Ihnen wird immer angezeigt in welchem Raum Sie sich aktuell befinden.\n\nFolgende Eingabebefehle sind erlaubt:\n"+
        "- gehe vorne \n- gehe hinten \n- gehe links\n- gehe rechts\n- gehe oben \n- gehe unten\n- suche \n- hilfe\n- beenden\n\nLos gehts und viel Spaß!\n");
        Spiel.console(st.toString());
    }

    private void verarbeiteBefehlsanfragen() {

        Spiel.console(spieler.getAktuelleAbteilung().gibLangeBeschreibung());
        Spiel.console("Was wollen Sie tun?");
        String benutzereingabe = null;
        BufferedReader eingabe = new BufferedReader(new InputStreamReader(System.in));
        try {
            benutzereingabe = eingabe.readLine();
        }
        catch(Exception e) {
            Spiel.console("Es ist folgender ein Fehler aufgetreten: "+e.getMessage());
        }
        Befehl bh = verarbeitung.liefereBefehl(benutzereingabe);
        if(bh!=null) {
            befehlsAusfuehrung(bh);
        }
        Spiel.console("# # # # # # # # # # # # # \n");

    }

    private boolean befehlsAusfuehrung(Befehl b) {
        switch(b.getGrundbefehl()) {
            case gehe: return wechsleRaum(b.getBefehlsdetail());
            case suche: return suche();
            case hilfe: return gibHilfetext();
            case beenden: return quit();
            default: return false;
        }
    }

    private boolean wechsleRaum(Befehlsdetail abteilung) {
        if(spieler.getAktuelleAbteilung().durchgangVorhanden(abteilung)) {
            if(spieler.getAktuelleAbteilung().gibDurchgang(abteilung).istAbgeschlossen()) {
                List<Schluessel> schluessel = new ArrayList<>(spieler.getInventar());
                spieler.setInventar(spieler.getAktuelleAbteilung().gibDurchgang(abteilung).zutrittErlaubt(spieler.getInventar()));
                if(spieler.getInventar().equals(schluessel)) {
                    Spiel.console("Sie haben den passenden Schluessel leider nicht dabei!");
                    return false;
                }else{
                    
                spieler.setInventar(schluessel);
                Spiel.console("Sie haben den Raum erfolgreich aufgeschlossen.\n");
            }
            }
            if(spieler.getAktuelleAbteilung().gibDurchgang(abteilung).getIstAußenwelt()) {
                ausgangGefunden();
            }
            fuehreKollisionskontrolleDurch();
            spieler.setAktuelleAbteilung(spieler.getAktuelleAbteilung().gibDurchgang(abteilung));
            return true;
        }
        else {
            Spiel.console("Hier geht es nicht lang.\n");
            return false;
        }
    }
    
    private String fuehreKollisionskontrolleDurch() {
    	for(NPC npc : npcs) {
			if(npc.getAktuelleAbteilung().equals(spieler.getAktuelleAbteilung())) {
				return npc.treffeSpieler(spieler);
			}
		}
    	return "\n";
    }
    
    private void bewegeNPCs() {
    	for(NPC npc : npcs) {
			npc.wechsleAbteilung();
		}
    }

    private boolean suche() {
        List<Schluessel> funde;
        List<Stoppersocken> socken;
        if((funde = spieler.getAktuelleAbteilung().nehmeFundsachen()).size()!=0) {

            spieler.getInventar().addAll(funde);
            Spiel.console("Sie haben einen Schlüssel gefunden!\n");
            
            return true;
        }
        
      
        if((socken = spieler.getAktuelleAbteilung().getSocken()).size()!=0){

                spieler.getStoppersocken().addAll(socken);
                Spiel.console("Sie haben einen Stoppersocken gefunden!\n");
                return true;
        }

        Spiel.console("Hier liegt leider nichts.\n");
        return false;
    }

    private boolean gibHilfetext() {
        Spiel.console("Folgende Befehle können eingegeben werden:\n- gehe vorne \n- gehe hinten \n- gehe links\n- gehe rechts\n- gehe oben \n- gehe unten\n"+
        "- suche\n");
        return true;
    }

    private boolean quit() {
        this.quitBefehl = true;
        Spiel.console("Sie haben soeben das Spiel beendet.\n");
        return true;
    }

    private void ausgangGefunden() {
        Spiel.console("*** Herzlichen Glückwunsch ***\n");
        Spiel.console("Sie haben den Ausgang gefunden!\n");
        this.quitBefehl = true;
    }

    private boolean spielAktiv() {
        if(quitBefehl) {
            Spiel.console("Viel Spaß noch und bis zum nächsten Mal!");
            return false;
        }
        return true;
    }

    private void npcHinzufuegen(NPC npc) {
	this.npcs.add(npc);
    }
	
    public void npcLoeschen(NPC npc) {
	this.npcs.remove(npc);
    }
    
    public List<Abteilung> getAbteilungen(){
    	return this.abteilungen;
    }
}
