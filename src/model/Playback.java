package model;

/**
 * <b>Playback</b><br>
 * is a class that represents the playback made by a user.
 * 
 * @author Yeison Antonio Rodriguez Zuluaga.
 */
public class Playback {

    private Audio audio;
    private int playback;

    /**
     * <b>Constructor</b><br>
     * allows to create a Playback's object.
     * 
     * @param audio is the audio that the user played.
     */
    public Playback(Audio audio) {
        this.audio = audio;
        playback = 1;
    }

    /**
     * <b>updateInfo</b><br>
     * allows to update the information of the playback.<br>
     * <b>pre:</b> the playback has been created.<br>
     * <b>post:</b> the playback's information has been updated.
     */
    public void updateInfo(){
        playback++;
    }

    /**
     * <b>getAudio</b><br>
     * allows to get the audio that the user played.
     * 
     * @return Audio the audio that the user played.
     */
    public Audio getAudio() {
        return audio;
    }


    /**
     * <b>setAudio</b><br>
     * allows to set the audio that the user played.
     * 
     * @param audio is the audio that the user played.
     */
    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    /**
     * <b>getPlayback</b><br>
     * allows to get the number of times that the user played the audio.
     * 
     * @return int the number of times that the user played the audio.
     */
    public int getPlayback() {
        return playback;
    }

    /**
     * <b>setPlayback</b><br>
     * allows to set the number of times that the user played the audio.
     * 
     * @param playback is the number of times that the user played the audio.
     */
    public void setPlayback(int playback) {
        this.playback = playback;
    }

}
