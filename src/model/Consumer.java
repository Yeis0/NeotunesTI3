package model;

import java.util.ArrayList;

/**
 * <b>Consumer</b> is a class that represents a consumer of the application.
 * 
 * @author Yeison Antonio Rodriguez Zuluaga.
 */
public abstract class Consumer extends User {

    private ArrayList<Playlist> playlists;
    private ArrayList<Shop> shops;
    private ArrayList<Playback> playbacks;
    
    /**
     * <b>Constructor</b> allows to create a Consumer's object.
     * 
     * @param nickName is the user's nickname.
     * @param idNumber is the user's identification number.
     */
    
    public Consumer(String nickName, String idNumber) {
        
        super(nickName, idNumber);
        playlists = new ArrayList<Playlist>();
        shops = new ArrayList<Shop>();
        playbacks = new ArrayList<Playback>();
    }

    /**
     * <b>playAudio</b><br>
     * allows to play an audio.<br>
     * <b>pre:</b> the audio must be already created.<br>
     * <b>post:</b> the audio will be played.<br>
     * 
     * @param audio is the audio that will be played.
     * @return String the message that indicates if the audio was played.
     */
    public String playAudio(Audio audio) {
        String msg = "";
        msg += audio.plays();
        Playback obj = searchPlayback(audio.getName());
        if (obj == null) {
            playbacks.add(new Playback(audio));
        } else {
            obj.updateInfo();
        }

        return msg;

    }

    /**
     * <b>mostHearedGenre</b><br>
     * allows to get the most heared genre.<br>
     * <b>pre:</b> the playbacks must be already created.<br>
     * <b>post:</b> the most heared genre will be returned.<br>
     * 
     * @return String the most heared genre.
     */
    public String mostHearedGenre() {

        String msg = "";
        int[] genres = playbackPerGenre();
        for (int i=0;i<genres.length;i++){
            genres [i]=playbackPerGenre()[i];
        }
        int max = 0;
        int pos = -1;
        for (int i = 0; i < genres.length; i++) {
            if (genres[i] > max) {
                max = genres[i];
                pos = i;
            }
        }
        switch (pos) {
            case 0:
                msg = "The most heared genre is: Pop, with " + max + " plays.";
                break;
            case 1:
                msg = "The most heared genre is: Rock, with " + max + " plays.";
                break;
            case 2:
                msg = "The most heared genre is: trap, with " + max + " plays.";
                break;
            case 3:
                msg = "The most heared genre is: house, with " + max + " plays.";
                break;
            default:
                msg = "no songs have been played.";
                break;
        }
        return msg;
    }

    /**
     * <b>playbackPerGenre</b><br>
     * allows to get the number of playbacks per genre.<br>
     * <b>pre:</b> the playbacks must be already created.<br>
     * <b>post:</b> the number of playbacks per genre will be returned.<br>
     * 
     * @return int[] the number of playbacks per genre.
     */
    public int[] playbackPerGenre() {
        int[] playbacksG = new int[4];
        for (int i = 0; i < playbacks.size(); i++) {
            if (playbacks.get(i).getAudio() instanceof Song) {
                Song s = (Song) playbacks.get(i).getAudio();
                if (s.getGenre().equals(Genre.POP)) {
                    playbacksG[0] += playbacks.get(i).getPlayback();
                } else if (s.getGenre().equals(Genre.ROCK)) {
                    playbacksG[1] += playbacks.get(i).getPlayback();
                } else if (s.getGenre().equals(Genre.TRAP)) {
                    playbacksG[2] += playbacks.get(i).getPlayback();
                } else if (s.getGenre().equals(Genre.HOUSE)) {
                    playbacksG[3] += playbacks.get(i).getPlayback();
                }
            }
        }
        return playbacksG;
    }

    /**
     * <b>mostHearedCategory</b><br>
     * allows to get the most heared category.<br>
     * <b>pre:</b> the playbacks must be already created.<br>
     * <b>post:</b> the most heared category will be returned.<br>
     * 
     * @return String the most heared category.
     */
    public String mostHearedCategory() {

        String msg = "";
        int[] category = playbackPerCategory();
        int max = 0;
        int pos = -1;
        for (int i = 0; i < category.length; i++) {
            if (category[i] > max) {
                max = category[i];
                pos = i;
            }
        }
        switch (pos) {
            case 0:
                msg = "The most heared genre is: Policy, with " + max + " plays.";
                break;
            case 1:
                msg = "The most heared genre is: Entertainment, with " + max + " plays.";
                break;
            case 2:
                msg = "The most heared genre is: Videogames, with " + max + " plays.";
                break;
            case 3:
                msg = "The most heared genre is: Fashion, with " + max + " plays.";
                break;
            default:
                msg = "no songs have been played.";
                break;
        }
        return msg;
    }

    /**
     * <b>playbackPerCategory</b><br>
     * allows to get the number of playbacks per category.<br>
     * <b>pre:</b> the playbacks must be already created.<br>
     * <b>post:</b> the number of playbacks per category will be returned.<br>
     * 
     * @return int[] the number of playbacks per category.
     */
    public int[] playbackPerCategory() {
        int[] playbacksC = new int[4];
        for (int i = 0; i < playbacks.size(); i++) {
            if (playbacks.get(i).getAudio() instanceof Podcast) {
                Podcast p = (Podcast) playbacks.get(i).getAudio();
                if (p.getCategory().equals(Category.POLICY)) {
                    playbacksC[0] += playbacks.get(i).getPlayback();
                } else if (p.getCategory().equals(Category.ENTERTAINMENT)) {
                    playbacksC[1] += playbacks.get(i).getPlayback();
                } else if (p.getCategory().equals(Category.VIDEOGAMES)) {
                    playbacksC[2] += playbacks.get(i).getPlayback();
                } else if (p.getCategory().equals(Category.FASHION)) {
                    playbacksC[3] += playbacks.get(i).getPlayback();
                }
            }
        }
        return playbacksC;
    }

    /**
     * <b>searchPlayback</b><br>
     * allows to search a playback.<br>
     * <b>pre:</b> the playbacks must be already created.<br>
     * <b>post:</b> the playback will be returned.<br>
     * 
     * @param name is the name of the audio that will be searched.
     * @return Playback the playback that was searched.
     */
    public Playback searchPlayback(String name) {
        Playback obj = null;
        boolean search = false;
        for (int i = 0; i < playbacks.size() && !search; i++) {
            if (playbacks.get(i).getAudio().getName().equalsIgnoreCase(name)) {
                obj = playbacks.get(i);
                search = true;
            }
        }
        return obj;
    }

    /**
     * <b>addPlaylist</b><br>
     * allows to add a playlist.<br>
     * <b>pre:</b> the playlists must be already created.<br>
     * <b>post:</b> the playlist will be added.<br>
     * 
     * @param name is the playlist's name.
     * @return String the message of the operation.
     */
    public abstract String addPlaylist(String name);

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
        String msg = "";
        Playlist obj = searchPlaylist(name);
        if (obj != null) {
            msg=obj.share();
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
     * @param playlistName is the name of the playlist.
     * @param audio       is the audio to be removed.
     * @return String the message that indicates if the audio was removed
     */
    public String removeAudioFromPlaylist(String playlistName, Audio audio) {
        String msg = "The audio was removed successfully";
        Playlist obj = searchPlaylist(playlistName);
        if (obj != null) {
            msg = obj.removeAudio(audio);
        } else {
            msg = "The playlist does not exist";
        }
        return msg;
    }

    /**
     * <b>getPlaylist</b><br>
     * allows to get a playlist.<br>
     * 
     * @return ArrayList the playlists.
     */
    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    /**
     * <b>setPlaylist</b><br>
     * allows to set a playlist.<br>
     * 
     * @param playlists is the playlist to be set.
     */
    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    /**
     * <b>getShop</b><br>
     * allows to get the shops.<br>
     * 
     * @return ArrayList the shops of an user.
     */
    public ArrayList<Shop> getShops() {
        return shops;
    }

    /**
     * <b>setShop</b><br>
     * allows to set the shops.<br>
     * 
     * @param shops is the shop to be set.
     */
    public void setShops(ArrayList<Shop> shops) {
        this.shops = shops;
    }
}
