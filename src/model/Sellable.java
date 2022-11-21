package model;

/**
 * <b>Sellable</b><br>
 * is a interface that represents a sellable of the application.
 * 
 * @author Yeison Antonio Rodriguez Zuluaga.
 */
public interface Sellable {

    /**
     * <b>sell</b><br>
     * allows to sell a song.<br>
     * <b>pre:</b> the song must be created.<br>
     * <b>post:</b> the song will be sold.<br>
     * @return String the information about the sell operation.
     */
    String sell();
    
}
