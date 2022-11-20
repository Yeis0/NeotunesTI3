package model;

/**
 * <b>Advertisement</b> is a class that represents a advertisement of the
 * application.
 * 
 * @author Yeison Antonio Rodriguez Zuluaga.
 */
public enum Advertisement implements Playable {

    NIKE("Nike, Just do it"),
    COKE("Coca-cola, open happiness"),
    MyM("M&M, Melts in your mouth, not in your hands");

    private String message;

    /**
     * <b>Constructor</b> allows to create a Advertisement's object.
     * 
     * @param message is the advertisement's message.
     */
    Advertisement(String message) {
        this.message = message;
    }

    /**
     * <b>plays</b> allows to play the advertisement.
     * 
     * @return String a message that indicates that the advertisement is playing.
     */
    public String plays() {
        String msg = "Sponsored by: " + message;
        return msg;
    }

}
