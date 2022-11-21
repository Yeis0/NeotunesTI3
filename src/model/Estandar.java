package model;

/**
 * <b>Consumer</b> <br>
 * This class represents a standar consumer of the application.
 * 
 * @author Yeison Antonio Rodriguez Zuluaga.
 */
public class Estandar extends Consumer {

    /**
     * A constant that represents the maximum number of songs that a consumer can
     * buy.
     */
    public static final int MAX_AUDIOS = 100;
    /**
     * A constant that represents the maximum number of playlists that a consumer
     * can create.
     */
    public static final int MAX_PLAYLISTS = 20;

    private int currentPlaybacks;

    /**
     * <b>Constructor</b><br>
     * allows to create a Consumer's object.
     * 
     * @param nickName is the user's nickname.
     * @param idNumber is the user's identification number.
     */
    public Estandar(String nickName, String idNumber) {
        super(nickName, idNumber);
        currentPlaybacks = 0;
    }

    /**
     * <b>addAudio</b><br>
     * allows to add an audio to the user's list of audios.<br>
     * <b>pre:</b> the audio must be already created.<br>
     * <b>post:</b> the audio will be added to the user's list of audios.<br>
     * 
     * @param audio is the audio to be added.
     * @return String the message that indicates if the audio was added successfully
     *         or not.
     */
    public String addAudio(Audio audio) {
        String msg = "";
        Shop obj = searchAudio(audio.getName());
        boolean available = isAvailableSong();
        if (obj == null) {
            if (available) {

                if (audio instanceof Song) {
                    Song s = (Song) audio;
                    msg += s.sell();
                    super.getShops().add(new Shop(s));

                } else {
                    msg = "The audio is not a song.";
                }

            } else {
                msg = "The user has reached the maximum number of songs";
            }
        } else {
            msg = "The song already exists";
        }

        return msg;
    }

    /**
     * <b>addPlaylist</b><br>
     * allows to add a playlist to the user's list of playlists.<br>
     * <b>pre:</b> the playlist must not exist.<br>
     * <b>post:</b> the playlist will be added to the user's list of playlists.<br>
     * 
     * @param name is the name of the playlist to be added.
     * @return String the message that indicates if the playlist was added
     *         successfully or not.
     */
    public String addPlaylist(String name) {

        String msg = "Playlist Added succesfully";
        Playlist obj = searchPlaylist(name);
        boolean available = isAvailablePlaylist();
        if (obj == null) {
            if (available) {

                super.getPlaylists().add(new Playlist(name));

            } else {
                msg = "The user has reached the maximum number of playlists";
            }
        } else {
            msg = "The playlist already exists";
        }

        return msg;

    }

    /**
     * <b>isAvailablePlaylist</b><br>
     * allows to know if the user can add more playlists.<br>
     * <b>pre:</b> the playlist list must exist.<br>
     * <b>post:</b> the availability has been found.<br>
     * 
     * @return boolean true if can, false if not.
     */
    public boolean isAvailablePlaylist() {
        boolean available = false;
        if (super.getPlaylists().size() < MAX_PLAYLISTS) {
            available = true;
        }
        return available;
    }

    /**
     * <b>searchAudio</b><br>
     * allows to search an audio by its name.<br>
     * <b>pre:</b> the shop list must be already created.<br>
     * <b>post:</b> the audio will be searched.<br>
     * 
     * @param name is the name of the audio to be searched.
     * @return Audio the audio found.
     */
    public Shop searchAudio(String name) {
        Shop obj = null;
        boolean search = false;
        for (int i = 0; i < super.getShops().size() && !search; i++) {
            if (super.getShops().get(i).getSong().getName().equalsIgnoreCase(name)) {
                obj = super.getShops().get(i);
                search = true;
            }
        }

        return obj;
    }

    /**
     * <b>isAvailableSong</b><br>
     * allows to know if the user can add more audios.<br>
     * <b>pre:</b> the shop list must exist.<br>
     * <b>post:</b> the availability has been found.<br>
     * 
     * @return boolean true if can, false if not.
     */
    public boolean isAvailableSong() {
        boolean available = false;
        if (super.getShops().size() < MAX_AUDIOS) {
            available = true;
        }
        return available;
    }

    /**
     * <b>songAd</b><br>
     * allows to know if an add will be played.<br>
     * <b>pre:</b> the shop list must be already created.<br>
     * <b>post:</b> the instruction about the ad will be give.<br>
     * 
     * @return boolean true if an add will be played, false if not.
     */
    public boolean songAd() {
        boolean ad = false;
        if (currentPlaybacks == 2) {
            ad = true;
            currentPlaybacks = 0;
        } else {
            currentPlaybacks++;
        }
        return ad;
    }

    @Override
    public String playAudio(Audio audio){

        return super.playAudio(audio);

    }

    /**
     * <b>getCurrentPlaybacks</b><br>
     * allows to know the current playbacks.<br>
     * 
     * @return int the current playbacks.
     */
    public int getCurrentPlaybacks() {
        return currentPlaybacks;
    }

    /**
     * <b>setCurrentPlaybacks</b><br>
     * allows to set the current playbacks.<br>
     * 
     * @param currentPlaybacks is the current playbacks to be set.
     */
    public void setCurrentPlaybacks(int currentPlaybacks) {
        this.currentPlaybacks = currentPlaybacks;
    }

}
