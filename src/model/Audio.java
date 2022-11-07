package model;

/**
 * <b>Audio</b> is a class that represents an audio of the application.
 * @author Yeison Antonio Rodriguez Zuluaga.
 */
public class Audio {

    private String name;
    private int duration;
    private String url;
    private int totalPlays;

    private User autor;

    /**
     * <b>Constructor</b> allows to create an Audio's object.
     * @param name  is the audio's name.
     * @param duration is the audio's duration.
     * @param url is the audio's url.
     * @param autor is the audio's autor.
     */
    public Audio(String name, int duration, String url, User autor) {
        this.name = name;
        this.duration = duration;
        this.url = url;
        this.autor = autor;
    }

    
    /** 
     * <b>getName</b> allows to get the audio's name.
     * @return String the audio's name.
     */
    public String getName() {
        return name;
    }

    
    /** 
     * <b>setName</b> allows to set the audio's name.
     * @param name is the audio's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * <b>getDuration</b> allows to get the audio's duration.
     * @return int the audio's duration.
     */
    public int getDuration() {
        return duration;
    }

    
    /** 
     * <b>setDuration</b> allows to set the audio's duration.
     * @param duration is the audio's duration.
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    
    /** 
     * <b>getTotalPlays</b> allows to get the audio's total plays.
     * @return int the audio's total plays.
     */
    public int getTotalPlays() {
        return totalPlays;
    }

    
    /** 
     * <b>setTotalPlays</b> allows to set the audio's total plays.
     * @param totalPlays is the audio's total plays.
     */
    public void setTotalPlays(int totalPlays) {
        this.totalPlays = totalPlays;
    }

    
    /** 
     * <b>getUrl</b> allows to get the audio's url.
     * @return String the audio's url.
     */
    public String getUrl() {
        return url;
    }

    
    /** 
     * <b>setUrl</b> allows to set the audio's url.
     * @param url is the audio's url.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    
    /** 
     * <b>getAutor</b> allows to get the audio's autor.
     * @return User the audio's autor.
     */
    public User getAutor() {
        return autor;
    }

    
    /** 
     * <b>setAutor</b> allows to set the audio's autor.
     * @param autor is the audio's autor.
     */
    public void setAutor(User autor) {
        this.autor = autor;
    }
    
}
