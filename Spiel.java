/**
 * Hauptklasse des Kaufhaus-Spiels
 * @author Lukas Kiffmeyer, Marie Hölscher
 * @version 1
 */
public class Spiel 
{
    /**
     * Diese Methode startet ein neues Spiel
     */
    public void start() 
    {   
        Spielverwaltung sp = new Spielverwaltung("Peter",300000l);
        sp.start();
    }

    /**
     * Diese Methode gibt einen Text auf der Console aus
     * @param text Text, der ausgegeben werden soll
     */
    public static void console(String text) {
        System.out.println(text);
    }

}
