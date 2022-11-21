package model;

import java.util.ArrayList;

/**
 * <b>Artist</b><br>
 * This class represents an artist. <br>
 * 
 * @author Yeison Antonio Rodriguez Zuluaga.
 */
public class Artist extends Productor {

    private ArrayList<Song> songs;

    /**
     * <b>Constructor</b><br>
     * allows to create an Artist's object.
     * 
     * @param nickName is the user's nickname.
     * @param idNumber is the user's identification number.
     * @param name     is the artist's name.
     * @param url      is the artist's url.
     */
    public Artist(String nickName, String idNumber, String name, String url) {
        super(nickName, idNumber, name, url);
        songs = new ArrayList<Song>();
    }

    /**
     * <b>addAudio</b><br>
     * allows to add a song to the artist's list of songs.<br>
     * <b>pre:</b> the song must be not added before.<br>
     * <b>post:</b> the song will be added to the artist's list of songs.<br>
     * 
     * @param audio is the song to be added.
     * @return String the message that indicates if the song was added successfully
     *         or not.
     */
    public String addAudio(Audio audio) {

        String msg = "The was added successfully";
        Audio obj = searchAudio(audio.getName());
        if (obj == null) {
            songs.add((Song) audio);
            return "Audio added";
        } else {
            msg = "The audio already exists";
        }
        return msg;
    }

    /**
     * <b>searchAudio</b><br>
     * allows to search an audio in the artist's list of audios.<br>
     * <b>pre:</b> the audio must be added before.<br>
     * <b>post:</b> the audio will be searched in the artist's list of audios.<br>
     * 
     * @param name is the name of the audio to be searched.
     * @return Audio the audio that was searched.
     */
    public Audio searchAudio(String name) {

        Audio obj = null;
        boolean search = false;
        if (songs != null) {
            for (int i = 0; i < songs.size() && !search; i++) {
                if (songs.get(i).getName().equalsIgnoreCase(name)) {
                    obj = songs.get(i);
                    search = true;
                }
            }
        }

        return obj;

    }

    /**
     * <b>getSongs</b><br>
     * allows to get the artist's list of songs.
     * 
     * @return ArrayList the artist's list of songs.
     */
    public ArrayList<Song> getSongs() {
        return songs;
    }

    /**
     * <b>setSongs</b><br>
     * allows to set the artist's list of songs.
     * 
     * @param songs is the artist's list of songs.
     */
    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

}
