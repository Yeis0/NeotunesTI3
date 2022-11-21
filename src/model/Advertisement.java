package model;

/**
 * <b>Advertisement</b> is a class that represents a advertisement of the
 * application.
 * 
 * @author Yeison Antonio Rodriguez Zuluaga.
 */
public enum Advertisement implements Playable {

    /**
     * <b>NIKE</b><br>
     * represent a nike advertisement.
     */
    NIKE("Nike, Just do it"),
    /**
     * <b>COKE</b><br>
     * represent a coca-cola advertisement.
     */
    COKE("Coca-cola, open happiness"),
    /**
     * <b>MyM</b><br>
     * represents a MyM advertisement.
     */
    MyM("M&M, Melts in your mouth, not in your hands");

    private String message;

    /**
     * <b>Constructor</b><br>
     * allows to create a Advertisement's object.
     * 
     * @param message is the advertisement's message.
     */
    Advertisement(String message) {
        this.message = message;
    }

    /**
     * <b>plays</b><br>
     * allows to play the advertisement.
     * 
     * @return String a message that indicates that the advertisement is playing.
     */
    public String plays() {
        String msg = "Sponsored by: " + message;
        return msg;
    }

    /**
     * <b>getMessage</b><br>
     * allows to get the advertisement's message.
     * 
     * @return String the advertisement's message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * <b>setMessage</b><br>
     * allows to set the advertisement's message.
     * 
     * @param message The message of the advertisment
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
