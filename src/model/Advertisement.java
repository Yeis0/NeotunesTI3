package model;

/**
 * <b>Advertisement</b> is a class that represents a advertisement of the application.
 * @author Yeison Antonio Rodriguez Zuluaga.
 */
public class Advertisement implements Playable{

    private String message;

    /**
     * <b>Constructor</b> allows to create a Advertisement's object.
     * @param message is the advertisement's message.
     */
    public Advertisement(String message){
        this.message = message;
    }

    /**
     * <b>plays</b> allows to play the advertisement.
     * @return String a message that indicates that the advertisement is playing.
     */
    public String plays(){
        message = "Sponsored by: " + message;
        return message;
    }


}
