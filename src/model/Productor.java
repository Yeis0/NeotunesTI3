package model;

/**
 * <b>Productor</b> <br>
 * This class represents a productor of the application.
 * 
 * @author Yeison Antonio Rodriguez Zuluaga.
 */
public abstract class Productor extends User {

    private String name;
    private String url;
    private int accumulatedPlayback;
    private double timePlayed;

    /**
     * <b>Constructor</b> allows to create a Productor's object.
     * 
     * @param nickName is the user's nickname.
     * @param idNumber is the user's identification number.
     * @param name     is the productor's name.
     * @param url      is the productor's url.
     */
    public Productor(String nickName, String idNumber, String name, String url) {
        super(nickName, idNumber);
        this.name = name;
        this.url = url;
        accumulatedPlayback=0;
        timePlayed=0;

    }

    public void updateSoldInfo(int duration){
        accumulatedPlayback++;
        timePlayed+=duration;
    }

    /**
     * <b>getName</b> allows to get the productor's name.
     * 
     * @return String the productor's name.
     */
    public String getName() {
        return name;
    }

    /**
     * <b>setName</b> allows to set the productor's name.
     * 
     * @param name is the productor's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <b>getUrl</b> allows to get the productor's url.
     * 
     * @return String the productor's url.
     */
    public String getUrl() {
        return url;
    }

    /**
     * <b>setUrl</b> allows to set the productor's url.
     * 
     * @param url is the productor's url.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * <b>getAccumulatedPlayback</b> allows to get the productor's accumulated
     * playback.
     * 
     * @return int the productor's accumulated playback.
     */
    public int getAccumulatedPlayback() {
        return accumulatedPlayback;
    }

    /**
     * <b>setAccumulatedPlayback</b> allows to set the productor's accumulated
     * playback.
     * 
     * @param accumulatedPlayback is the productor's accumulated playback.
     */
    public void setAccumulatedPlayback(int accumulatedPlayback) {
        this.accumulatedPlayback = accumulatedPlayback;
    }

    /**
     * <b>getTimePlayed</b> allows to get the productor's time played.
     * 
     * @return double the productor's time played.
     */
    public double getTimePlayed() {
        return timePlayed;
    }

    /**
     * <b>setTimePlayed</b> allows to set the productor's time played.
     * 
     * @param timePlayed is the productor's time played.
     */
    public void setTimePlayed(double timePlayed) {
        this.timePlayed = timePlayed;
    }
}
