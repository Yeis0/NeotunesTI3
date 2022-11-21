package model;

import java.util.ArrayList;

/**
 * <b>Premium</b> <br>
 * This class represents a premium user. <br>
 * 
 * @author Yeison Antonio Rodriguez Zuluaga.
 */
public class Premium extends Consumer {

    private ArrayList<Playlist> playlists;

    /**
     * <b>Constructor</b> allows to create a Premium's object.
     * 
     * @param nickName is the user's nickname.
     * @param idNumber is the user's identification number.
     */
    public Premium(String nickName, String idNumber) {
        super(nickName, idNumber);

        playlists = new ArrayList<Playlist>();
    }

    /**
     * <b>addAudio</b><br>
     * allows to add an audio to the user's list of audios.<br>
     * <b>pre:</b> the audio must be not added before.<br>
     * <b>post:</b> the audio will be added to the user's list of audios.<br>
     * 
     * @param audio is the audio to be added.
     * @return String the message that indicates if the audio was added successfully
     *         or not.
     */
    public String addAudio(Audio audio) {
        String msg = "";
        Shop obj = searchAudio(audio.getName());
        
        if (obj == null) {
                    if (audio instanceof Song) {
                        Song s = (Song) audio;
                        msg+=s.sell();
                        super.getShops().add(new Shop(s));
                    } else {
                        msg = "The audio is not a song.";
                    } 
        } else {
            msg = "The song already exists";
        }

        return msg;
    }

    /**
     * <b>searchAudio</b><br>
     * allows to search a song by its name.<br>
     * <b>pre:</b> the song must be already created.<br>
     * <b>post:</b> the song will be searched.<br>
     * @param name is the name of the song to be searched.
     * @return Shop the shop that contains the song.
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
     * <b>addPlaylist</b><br>
     * allows to add a playlist to the user's list of playlists.<br>
     * <b>pre:</b> the playlist must be not added before.<br>
     * <b>post:</b> the playlist will be added to the user's list of playlists.<br>
     * 
     * @param name is the name of the playlist to be added.
     * @return String the message that indicates if the playlist was added
     *         successfully or not.
     */
    public String addPlaylist(String name) {

        String msg = "Playlist added successfully";
        Playlist obj = super.searchPlaylist(name);
        if (obj == null) {
            super.getPlaylists().add(new Playlist(name));
        } else {
            msg = "The playlist already exists";
        }
        return msg;
    }

    @Override
    public String playAudio(Audio audio){
        return super.playAudio(audio);
    }

    /**
     * <b>getPlaylists</b><br>
     * allows to get the list of playlists of the user.
     * 
     * @return ArrayList the list of playlists of the user.
     */
    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    /**
     * <b>setPlaylists</b><br>
     * allows to set the list of playlists of the user.
     * 
     * @param playlists is the list of playlists of the user.
     */
    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

}
