/**
 * Abstrakte Klasse Gegenstand. Gegenstände können
 * innerhalb des Kaufhauses gefunden werden.
 */
public abstract class Gegenstand
{
    private String name;
    
    /**
     * Konstruktor der Klasse Gegenstand.
     */
    public Gegenstand(String name){
        this.name = name;
    }
    
    /**
     * Gibt den Namen des aktuellen Gegenstands.
     */
    public String getName(){
        return this.name;
    }

    
}
