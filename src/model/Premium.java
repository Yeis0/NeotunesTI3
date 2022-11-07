package model;

import java.util.ArrayList;

/**
 * <b>Premium</b> <br>This class represents a premium user. <br>
 * @author Yeison Antonio Rodriguez Zuluaga.
 */
public class Premium extends Consumer {

    private ArrayList<Song> songs;
    private ArrayList<PlayList> playlists;

    /**
     * <b>Constructor</b> allows to create a Premium's object.
     * @param nickName is the user's nickname.
     * @param idNumber is the user's identification number.
     */
    public Premium(String nickName, String idNumber) {
        super(nickName, idNumber);

        songs = new ArrayList<Song>();
        playlists = new ArrayList<PlayList>();
    }

    
    /** 
     * <b>addAudio</b> allows to add an audio to the user's list of audios.
     * @param audio is the audio to be added.
     * @return String the message that indicates if the audio was added successfully or not.
     */
    public String addAudio(Audio audio) {

        String msg= "The audio was added successfully";
        Audio obj = searchAudio(audio.getName());
        if (obj==null){
            songs.add((Song)audio);
        }else{
            msg = "The audio already exists";
        }
        return msg;
        
    }

    
    /** 
     * <b>addPlaylist</b> allows to add a playlist to the user's list of playlists.
     * @param name is the name of the playlist to be added.
     * @return String the message that indicates if the playlist was added successfully or not.
     */
    public String addPlaylist(String name){
            
            String msg = "Playlist added successfully";
            PlayList obj = searchPlaylist(name);
            if (obj==null){
                playlists.add(new PlayList(name));
            }else{
                msg = "The playlist already exists";
            }
            return msg;
    }

    
    /** 
     * <b>addAudioToPlaylist</b> allows to add an audio to a playlist.
     * @param name is the name of the playlist.
     * @param audio is the audio to be added.
     * @return String the message that indicates if the audio was added successfully or not.
     */
    public String addAudioToPlaylist(String name, Audio audio){

        String msg = "The audio was added successfully";
        PlayList obj = searchPlaylist(name);
        if (obj!=null){
            msg = obj.addAudio(audio);
        }else{
            msg = "The playlist does not exist";
        }
        return msg;

    }

    
    /** 
     * <b>searchPlaylist</b> allows to search a playlist by its name.
     * @param name is the name of the playlist to be searched.
     * @return PlayList the playlist found.
     */
    public PlayList searchPlaylist(String name) {

        PlayList obj = null;
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
     * <b>searchAudio</b> allows to search an audio by its name.
     * @param name is the name of the audio to be searched.
     * @return Audio the audio found.
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
     * <b>existPlaylists</b> allows to know if the user has playlists.
     * @return boolean true if the user has playlists, false if not.
     */
    public boolean existPlaylists(){
            
        boolean exists = false;
        if (playlists != null) {
            if (playlists.size() > 0) {
                exists = true;
            }
        }            
        return exists;
    }

    
    /** 
     * <b>editPlaylist</b> allows to change the name of a playlist.
     * @param name is the name of the playlist to be edited.
     * @param newName is the new name of the playlist.
     * @return String the message that indicates if the playlist was edited successfully or not.
     */
    public String editPlaylist(String name, String newName){
            
            String msg = "The playlist was edited successfully";
            PlayList obj = searchPlaylist(name);
            if (obj!=null){
                obj.setName(newName);
            }else{
                msg = "The playlist does not exist";
            }
            return msg;
    
    }

    
    /** 
     * <b>showPlaylistAudios</b> allows to show the audios of a playlist.
     * @param name is the name of the playlist.
     * @return the list of audios of the playlist.
     */
    public String showPlaylistAudios(String name){
            
            String msg = "The playlist does not exist";
            PlayList obj = searchPlaylist(name);
            if (obj!=null){
                msg = obj.showAudios();
            }
            return msg;
    
    }

    
    /** 
     *<b>removeAudioFromPlaylist</b> allows to remove an audio from a playlist. 
     * @param name is the name of the playlist.
     * @param audio is the audio to be removed.
     * @return String the message that indicates if the audio was removed successfully or not.
     */
    public String removeAudioFromPlaylist(String name, Audio audio){
            
        String msg = "The audio was removed successfully";
        PlayList obj = searchPlaylist(name);
        if (obj!=null){
            msg = obj.removeAudio(audio);
        }else{
            msg = "The playlist does not exist";
        }
        return msg;
    
    }

    
    /** 
     * <b>showPlaylists</b> allows to show the user's playlists.
     * @return String the list of the user's playlists.
     */
    public String showPlaylists(){
                
            String msg = "There are no playlists";
            if (existPlaylists()){
                msg = "Playlists: ";
                for (int i = 0; i < playlists.size(); i++) {
                    msg += playlists.get(i).getName() + "\n";
                }
            }
            return msg;
        
    }

    
    /** 
     * <b>sharePlaylist</b> allows to share a playlist with another user.
     * @param name is the name of the playlist.
     * @return String the message that indicates if the playlist was shared successfully or not.
     */
    public String sharePlaylist(String name){
                
                String msg = "The playlist does not exist";
                PlayList obj = searchPlaylist(name);
                if (obj!=null){
                    msg = obj.share();
                }
                return msg;
        
    }
    
    
    /** 
     * <b>getSongs</b> allows to get the list of audios of the user.
     * @return ArrayList the list of audios of the user.
     */
    public ArrayList<Song> getSongs() {
        return songs;
    }

    
    /** 
     * <b>setSongs</b> allows to set the list of audios of the user.
     * @param songs is the list of audios of the user.
     */
    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    
    /** 
     * <b>getPlaylists</b> allows to get the list of playlists of the user.
     * @return ArrayList the list of playlists of the user.
     */
    public ArrayList<PlayList> getPlaylists() {
        return playlists;
    }

    
    /** 
     * <b>setPlaylists</b> allows to set the list of playlists of the user.
     * @param playlists is the list of playlists of the user.
     */
    public void setPlaylists(ArrayList<PlayList> playlists) {
        this.playlists = playlists;
    }
    
}
