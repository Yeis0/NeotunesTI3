package model;

import java.util.ArrayList;

/**
 * <b>Premium</b> <br>
 * This class represents a premium user. <br>
 * 
 * @author Yeison Antonio Rodriguez Zuluaga.
 */
public class Premium extends Consumer {

    private ArrayList<Shop> songs;
    private ArrayList<Playlist> playlists;

    /**
     * <b>Constructor</b> allows to create a Premium's object.
     * 
     * @param nickName is the user's nickname.
     * @param idNumber is the user's identification number.
     */
    public Premium(String nickName, String idNumber) {
        super(nickName, idNumber);

        songs = new ArrayList<Shop>();
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
        Playlist obj = searchPlaylist(name);
        if (obj == null) {
            playlists.add(new Playlist(name));
        } else {
            msg = "The playlist already exists";
        }
        return msg;
    }

    /**
     * <b>addAudioToPlaylist</b><br>
     * allows to add an audio to a playlist.<br>
     * <b>pre:</b> the audio must be already created.<br>
     * <b>post:</b> the audio will be added to the playlist.<br>
     * 
     * @param name  is the name of the playlist.
     * @param audio is the audio to be added.
     * @return String the message that indicates if the audio was added successfully
     *         or not.
     */
    public String addAudioToPlaylist(String name, Audio audio) {

        String msg = "The audio was added successfully";
        Playlist obj = searchPlaylist(name);
        if (obj != null) {
            msg = obj.addAudio(audio);
        } else {
            msg = "The playlist does not exist";
        }
        return msg;

    }

    /**
     * <b>searchPlaylist</b><br>
     * allows to search a playlist by its name.<br>
     * <b>pre:</b> the playlist must be already created.<br>
     * <b>post:</b> the playlist will be searched.<br>
     * 
     * @param name is the name of the playlist to be searched.
     * @return PlayList the playlist found.
     */
    public Playlist searchPlaylist(String name) {

        Playlist obj = null;
        boolean search = false;
        if (playlists != null) {
            for (int i = 0; i < playlists.size() && !search; i++) {
                if (playlists.get(i).getName().equalsIgnoreCase(name)) {
                    obj = playlists.get(i);
                    search = true;
                }
            }
        }

        return obj;

    }

    /**
     * <b>editPlaylist</b><br>
     * allows to change the name of a playlist.<br>
     * <b>pre:</b> the playlist must be already created.<br>
     * <b>post:</b> the playlist will be edited.<br>
     * 
     * @param name    is the name of the playlist to be edited.
     * @param newName is the new name of the playlist.
     * @return String the message that indicates if the playlist was edited
     *         successfully or not.
     */
    public String editPlaylist(String name, String newName) {

        String msg = "The playlist was edited successfully";
        Playlist obj = searchPlaylist(name);
        if (obj != null) {
            obj.setName(newName);
        } else {
            msg = "The playlist does not exist";
        }
        return msg;

    }

    /**
     * <b>removeAudioFromPlaylist</b><br>
     * allows to remove an audio from a playlist.<br>
     * <b>pre:</b> the audio must be already created.<br>
     * <b>post:</b> the audio will be removed from the playlist.<br>
     * 
     * @param name  is the name of the playlist.
     * @param audio is the audio to be removed.
     * @return String the message that indicates if the audio was removed
     *         successfully or not.
     */
    public String removeAudioFromPlaylist(String name, Audio audio) {

        String msg = "The audio was removed successfully";
        Playlist obj = searchPlaylist(name);
        if (obj != null) {
            msg = obj.removeAudio(audio);
        } else {
            msg = "The playlist does not exist";
        }
        return msg;

    }

    /**
     * <b>sharePlaylist</b><br>
     * allows to share a playlist with another user.<br>
     * <b>pre:</b> the playlist must be already created.<br>
     * <b>post:</b> the playlist will be shared.<br>
     * 
     * @param name is the name of the playlist.
     * @return String the message that indicates if the playlist was shared
     *         successfully or not.
     */
    public String sharePlaylist(String name) {

        String msg = "The playlist does not exist";
        Playlist obj = searchPlaylist(name);
        if (obj != null) {
            msg = obj.share();
        }
        return msg;

    }

    /**
     * <b>getShops</b><br>
     * allows to get the list of shops of the user.
     * 
     * @return ArrayList the list of shops of the user.
     */
    public ArrayList<Shop> getShops() {
        return songs;
    }

    /**
     * <b>setShops</b><br>
     * allows to set the list of shops of the user.
     * 
     * @param songs is the list of shops of the user.
     */
    public void setShops(ArrayList<Shop> songs) {
        this.songs = songs;
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
