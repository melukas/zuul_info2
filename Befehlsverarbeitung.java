 
import java.util.StringTokenizer;


/**
 * Klasse Befehlsverarbeitung kümmert sich nach Eingabe
 * eines Befehles durch den Spieler um die entsprechende
 * Verarbeitung.
 * @author Lukas Kiffmeyer, Marie Hölscher
 * @version 1
 */
class Befehlsverarbeitung 
{

     /**
     * Methode unterteilt die Eingabe des Benutzers in Grundbefehl und
     * Befehlsdetail und gibt falls vorhanden den richtigen Befehl zurück.
     * @return eingegebener Befehl
     */
    public Befehl liefereBefehl(String benutzereingabe) 
    {
        String grundbefehl = null;
        String befehlsdetail = null;
        Befehl befehl = null;

        StringTokenizer tokenizer = new StringTokenizer(benutzereingabe);

        if(tokenizer.hasMoreTokens()) {
            grundbefehl = tokenizer.nextToken();
            if(tokenizer.hasMoreTokens()) {
                befehlsdetail = tokenizer.nextToken();
                if(tokenizer.hasMoreTokens()){
                  System.out.println("Bitte geben Sie einen gültigen Befehl ein.");
            return null;
                }
            }
            befehl = parseBefehl(grundbefehl, befehlsdetail);
            
             if(befehl!=null && befehl.istGueltigerBefehl()) {
                return befehl;
             }
        }
        System.out.println("Bitte geben Sie einen gültigen Befehl ein.");
            return null;
            

    }

    private Befehl parseBefehl(String grundbefehl, String befehlsdetail) {
        Befehl befehl = null;
        try {
            Grundbefehl g = null;
            Befehlsdetail b = null;
            if(grundbefehl!=null) {
                g = Grundbefehl.valueOf(Grundbefehl.class, grundbefehl);
            }
            if(befehlsdetail!=null) {
                b = Befehlsdetail.valueOf(Befehlsdetail.class, befehlsdetail);
            }
            befehl = new Befehl(g,b);
        }
        catch(IllegalArgumentException e) {};
        
        return befehl;
    }
}
