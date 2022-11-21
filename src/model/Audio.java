package model;

/**
 * <b>Audio</b><br>
 * is a class that represents an audio of the application.
 * 
 * @author Yeison Antonio Rodriguez Zuluaga.
 */
public abstract class Audio implements Playable {

    private String name;
    private int duration;
    private String url;
    private int totalPlays;

    private Productor autor;

    /**
     * <b>Constructor</b><br>
     * allows to create an Audio's object.
     * 
     * @param name     is the audio's name.
     * @param duration is the audio's duration.
     * @param url      is the audio's url.
     * @param autor    is the audio's autor.
     */
    public Audio(String name, int duration, String url, User autor) {
        this.name = name;
        this.duration = duration;
        this.url = url;

        this.autor = (Productor )autor;
        totalPlays = 0;
    }

    /**
     * <b>getName</b><br>
     * allows to get the audio's name.
     * 
     * @return String the audio's name.
     */
    public String getName() {
        return name;
    }

    /**
     * <b>plays</b><br>
     * allows to play the audio.<br>
     * <b>pre:</b> the audio has been created.<br>
     * <b>post:</b> the audio has been played.
     * @return String a message that indicates that the audio is playing.
     */
    public String plays(){
        totalPlays+=1;
        autor.setAccumulatedPlayback(autor.getAccumulatedPlayback() + 1);
        return "The audio " + name + " is playing";


    }

    /**
     * <b>setName</b><br>
     * allows to set the audio's name.
     * 
     * @param name is the audio's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <b>getDuration</b><br>
     * allows to get the audio's duration.
     * 
     * @return int the audio's duration.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * <b>setDuration</b><br>
     * allows to set the audio's duration.
     * 
     * @param duration is the audio's duration.
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * <b>getTotalPlays</b><br>
     * allows to get the audio's total plays.
     * 
     * @return int the audio's total plays.
     */
    public int getTotalPlays() {
        return totalPlays;
    }

    /**
     * <b>setTotalPlays</b><br>
     * allows to set the audio's total plays.
     * 
     * @param totalPlays is the audio's total plays.
     */
    public void setTotalPlays(int totalPlays) {
        this.totalPlays = totalPlays;
    }

    /**
     * <b>getUrl</b><br>
     * allows to get the audio's url.
     * 
     * @return String the audio's url.
     */
    public String getUrl() {
        return url;
    }

    /**
     * <b>setUrl</b><br>
     * allows to set the audio's url.
     * 
     * @param url is the audio's url.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * <b>getAutor</b><br>
     * allows to get the audio's autor.
     * 
     * @return User the audio's autor.
     */
    public Productor getAutor() {
        return autor;
    }

    /**
     * <b>setAutor</b><br>
     * allows to set the audio's autor.
     * 
     * @param autor is the audio's autor.
     */
    public void setAutor(User autor) {
        this.autor = (Productor) autor;
    }

}
