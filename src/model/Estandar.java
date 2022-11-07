package model;

/**
 * <b>Consumer</b> <br>This class represents a standar consumer of the application.
 * @author Yeison Antonio Rodriguez Zuluaga.
 */
public  class Estandar extends Consumer {

    private Audio[] audios;
    private PlayList[] playlists;

    /**
     * <b>Constructor</b> allows to create a Consumer's object.
     * @param nickName is the user's nickname.
     * @param idNumber is the user's identification number.
     */
    public Estandar(String nickName, String idNumber) {
        super(nickName, idNumber);
        audios = new Audio[100];
        playlists = new PlayList[20];
    }
    
    
    /** 
     * <b>addAudio</b> allows to add an audio to the user's list of audios.
     * @param audio is the audio to be added.
     * @return String the message that indicates if the audio was added successfully or not.
     */
    public String addAudio(Audio audio){
        String msg="Song Added succesfully";
        Audio obj = searchAudio(audio.getName());
        boolean available = isAvailableSong();
        if (obj==null){
            if (available){
                for (int i=0; i<audios.length && obj==null; i++){
                    if (audios[i]==null){
                        audios[i]=audio;
                        obj=audio;
                    }
                }
            }else{
                msg="The user has reached the maximum number of songs";
            }
        }else{
            msg="The song already exists";
        } 

        return msg;

    }

    
    /** 
     * <b>addPlaylist</b> allows to add a playlist to the user's list of playlists.
     * @param name is the name of the playlist to be added.
     * @return String the message that indicates if the playlist was added successfully or not.
     */
    public String addPlaylist(String name){

        String msg="Playlist Added succesfully";
        PlayList obj = searchPlaylist(name);
        boolean available = isAvailablePlaylist();
        if (obj==null){
            if (available){
                for (int i=0; i<playlists.length && obj==null; i++){
                    if (playlists[i]==null){
                        playlists[i]=new PlayList(name);
                        obj=playlists[i];
                    }
                }
            }else{
                msg="The user has reached the maximum number of playlists";
            }
        }else{
            msg="The playlist already exists";
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

        String msg="The audio was added succesfully";
        PlayList obj = searchPlaylist(name);
        if (obj!=null){
            msg=obj.addAudio(audio);
        }else{
            msg="The playlist does not exist";
        }
            
            return msg;
    }

    
    /** 
     * <b>searchPlaylist</b> allows to search a playlist by its name.
     * @param name is the name of the playlist to be searched.
     * @return PlayList the playlist found.
     */
    public PlayList searchPlaylist(String name){
            
            PlayList obj = null;
            boolean search = false;
            if (playlists != null) {
                for (int i = 0; i < playlists.length && !search; i++) {
                    if (playlists[i]!=null && playlists[i].getName().equalsIgnoreCase(name)) {
                        obj = playlists[i];
                        search = true;
                    }
                }
            }
    
            return obj;
    
    }

    /** 
     * <b>isAvailablePlaylist</b> allows to know if the user can add more playlists.
     * @return boolean true if can, false if not.
     */
    public boolean isAvailablePlaylist(){
        boolean available = false;
        for (int i=0; i<playlists.length && !available; i++){
            if (playlists[i]==null){
                available=true;
            }
        }
        return available;
    }

    
    /** 
     * <b>searchAudio</b> allows to search an audio by its name.
     * @param name is the name of the audio to be searched.
     * @return Audio the audio found.
     */
    public Audio searchAudio(String name){
        Audio audio=null;
        boolean search=false;
        if (audios!=null) {
            for (int i = 0; i < audios.length&&!search; i++) {
                if (audios[i].getName().equalsIgnoreCase(name)) {
                    audio=audios[i];
                    search=true;
                }
            }
        }
        return audio;
    }

    
    /** 
     * <b>isAvailableSong</b> allows to know if the user can add more audios.
     * @return boolean true if can, false if not.
     */
    public boolean isAvailableSong(){
        boolean available=false;

        for (int i = 0; i < audios.length&&!available; i++) {
            if (audios[i]==null) {
                available=true;
            }
        }
        return available;
    }

    
    /** 
     * <b>existPlaylist</b> allows to know if a playlist exists.
     * @return boolean true if exists, false if not.
     */
    public boolean existPlaylists(){
        boolean exist=false;
        for (int i = 0; i < playlists.length&&!exist; i++) {
            if (playlists[i]!=null) {
                exist=true;
            }
        }
        return exist;
    }

    
    /** 
     * <b>editPlaylist</b> allows to edit a playlist.
     * @param name is the name of the playlist to be edited.
     * @param newName is the new name of the playlist.
     * @return String the message that indicates if the playlist was edited successfully or not.
     */
    public String editPlaylist(String name, String newName){
        String msg="The playlist was edited succesfully";
        PlayList obj = searchPlaylist(name);
        if (obj!=null){
            obj.setName(newName);
        }else{
            msg="The playlist does not exist";
        }
        return msg;
    }

    
    /** 
     * <b>showPlaylistAudios</b> allows to show the audios of a playlist.
     * @param name is the name of the playlist.
     * @return String the list of audios of the playlist.
     */
    public String showPlaylistAudios(String name){
        String msg="The playlist does not exist";
        PlayList obj = searchPlaylist(name);
        if (obj!=null){
            msg=obj.showAudios();
        }
        return msg;
    }

    
    /** 
     * <b>removeAudioFromPlaylist</b> allows to remove an audio from a playlist.
     * @param name is the name of the playlist.
     * @param audio is the audio to be removed.
     * @return String the message that indicates if the audio was removed successfully or not.
     */
    public String removeAudioFromPlaylist(String name, Audio audio){
        String msg="The audio was removed succesfully";
        PlayList obj = searchPlaylist(name);
        if (obj!=null){
            msg=obj.removeAudio(audio);
        }else{
            msg="The playlist does not exist";
        }
        return msg;
    }

    
    /** 
     * <b>showPlaylists</b> allows to show the playlists of the user.
     * @return String the list of playlists.
     */
    public String showPlaylists(){
        String msg="The user has no playlists";
        if (existPlaylists()){
            msg="Playlists: ";
            for (int i = 0; i < playlists.length; i++) {
                if (playlists[i]!=null) {
                    msg+=playlists[i].getName()+"\n";
                }
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
        String msg="The playlist was shared succesfully";
        PlayList obj = searchPlaylist(name);
        if (obj!=null){
            obj.share();
        }else{
            msg="The playlist does not exist";
        }
        return msg;
    }

    
    
    /** 
     * <b>getAudios</b> allows to get the audios of the user.
     * @return Audio[] the audios of the user.
     */
    public Audio[] getAudios() {
        return audios;
    }

    
    /** 
     * <b>setAudios</b> allows to set the audios of the user.
     * @param audios is the audios of the user.
     */
    public void setAudios(Audio[] audios) {
        this.audios = audios;
    }

    
    /** <b>getPlaylists</b> allows to get the playlists of the user.
     * @return PlayList[] the playlists of the user.
     */
    public PlayList[] getPlaylists() {
        return playlists;
    }

    
    /** 
     * <b>setPlaylists</b> allows to set the playlists of the user.
     * @param playlists is the playlists of the user.
     */
    public void setPlaylists(PlayList[] playlists) {
        this.playlists = playlists;
    }

}
