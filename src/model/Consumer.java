package model;

/**
 * <b>Consumer</b> is a class that represents a consumer of the application.
 * @author Yeison Antonio Rodriguez Zuluaga.
 */
public abstract class Consumer extends User {

    /**
     * <b>Constructor</b> allows to create a Consumer's object.
     * @param nickName is the user's nickname.
     * @param idNumber is the user's identification number.
     */
    public Consumer(String nickName, String idNumber) {
        super(nickName, idNumber);  
    }
    
    /**
     * <b>addPlaylist</b> allows to add a playlist.
     * @param name is the playlist's name.
     * @return String the message of the operation.
     */
    public abstract String addPlaylist(String name);
    /**
     * <b>addAudioToPlaylist</b> allows to add an audio to a playlist.
     * @param name is the playlist's name.
     * @param audio is the audio to be added.
     * @return String the message of the operation.
     */
    public abstract String addAudioToPlaylist(String name, Audio audio); 
    /**
     * <b>existPlaylist</b> allows to verify if a playlist exists.
     * @return boolean true if the playlist exists, false if not.
     */
    public abstract boolean existPlaylists(); 
    /**
     * <b>editPlaylist</b> allows to edit a playlist's name.
     * @param name is the playlist's name.
     * @param newName is the new playlist's name.
     * @return String the message of the operation.
     */
    public abstract String editPlaylist(String name, String newName);  
    /**
     * <b>showPlaylistAudios</b> allows to show the audios of a playlist.
     * @param name is the playlist's name.
     * @return String the message of the operation.
     */
    public abstract String showPlaylistAudios(String name);
    /**
     * <b>removeAudioFromPlaylist</b> allows to remove an audio from a playlist.
     * @param name is the playlist's name.
     * @param audio is the audio to be removed.
     * @return String the message of the operation.
     */
    public abstract String removeAudioFromPlaylist(String name, Audio audio);
    /**
     * <b>showPlaylists</b> allows to show the playlists.
     * @return String the message of the operation.
     */
    public abstract String showPlaylists();
    /**
     * <b>sharePlaylist</b> allows to share a playlist.
     * @param name is the playlist's name.
     * @return String the message of the operation.
     */
    public abstract String sharePlaylist(String name);   
    
}
