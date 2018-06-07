/**
 * Abstrakte Klasse Gegenstand. Gegenstände können
 * innerhalb des Kaufhauses gefunden werden.
 */
public abstract class Gegenstand
{
    private String art;
    
    /**
     * Konstruktor der Klasse Gegenstand.
     */
    public Gegenstand(String art){
        this.art = art;
    }

    
}
