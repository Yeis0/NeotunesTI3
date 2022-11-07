package model;
import java.util.ArrayList;

/**
 * <b>NeoTunesController</b><br>This class is the controller of the program, it is the one that manages the system
 * @author Yeison Antonio Rodriguez Zuluaga
 */
public class NeoTunesController {

    private String name;
    
    private ArrayList<User> users;
    private ArrayList<Audio> audios;
    
    /**
     * <b>NeoTunesController</b><br>This method is the constructor of the class
     * @param name This is the name of the program
     */
    public NeoTunesController(String name){

        this.name=name;
        users = new ArrayList<User>();
        audios = new ArrayList<Audio>();

    }

    
    /** 
     * <b>addUser</b><br>This method adds a producer to the system.
     * @param nickName This is the nickname of the user
     * @param idNumber This is the id of the user
     * @param name This is the name of the user
     * @param url This a url to a picture of the user
     * @param type This is the type of user: artist or producer
     * @return String This returns a message that indicates if the user was added or not
     */
    public String addUser(String nickName, String idNumber, String name, String url, int type){
        String msg = "The user was added successfully";
        User obj = searchUser(nickName);
        if (obj==null){
            if (type==1){
                obj = new Artist(nickName, idNumber, name, url);
            }else if (type==2){
                obj = new ContentCreator(nickName, idNumber, name, url);
            }
            users.add(obj);
        }else{
            msg = "The user already exists";
        }
        return msg;
    }

    
    /** 
     * <b>addUser</b><br>This method adds a Consumer to the system.
     * @param nickName This is the nickname of the user.
     * @param idNumber This is the id of the user.
     * @param type This is the type of user: premium or standard
     * @return String This returns a message that indicates if the user was added or not
     */
    public String addUser(String nickName, String idNumber, int type){
        String msg="The user was added successfully";
        User obj = searchUser(nickName);
        if (obj==null){
            if (type==1){
                obj = new Premium(nickName, idNumber);
            }else if(type==2){
                obj = new Estandar(nickName, idNumber);
            }
            users.add(obj);
        }else{
            msg = "The user already exists";
        }

        return msg;

    }

    
    /** 
     * <b>addAudio</b><br>This method adds a song to the system.
     * @param name This is the name of the song
     * @param h This is the duration of the song in hours
     * @param m This is the duration of the song in minutes
     * @param s This is the duration of the song in seconds
     * @param url This is the url to the album's cover of the song
     * @param nickname This is the nickname of the producer of the song
     * @param album This is the name of the album of the song
     * @param price This is the price of the song
     * @param genre This is the genre of the song: rock, pop, etc.
     * @return String This returns a message that indicates if the song was added or not
     */
    public String addAudio(String name, int h,int m,int s, String url,String nickname,String album, double price,int genre){
        String msg = "The audio was added successfully";
        Audio obj = searchAudio(name);
        User autor = searchUser(nickname);
        int duration = toSeconds(h,m,s);  
        if (autor!=null){

            if (autor instanceof Artist){
                if (obj==null){
                    obj = new Song(name, duration, url, autor, album, price, genre);
                    audios.add(obj);
                    autor.addAudio((Song)obj);
                }else{
                    msg = "The audio already exists";
                }
            }else if (autor instanceof ContentCreator){
                msg = "The user is not an artist";
            }
            
        }else{
            msg = "The user does not exist";
        }
        return msg;

    }

    
    /** 
     * <b>addAudio</b><br>This method adds a podcast to the system.
     * @param name This is the name of the podcast
     * @param h This is the duration of the podcast in hours
     * @param m This is the duration of the podcast in minutes
     * @param s This is the duration of the podcast in seconds
     * @param url This is the url to the album's cover of the podcast
     * @param nickname This is the nickname of the producer of the podcast
     * @param description This is the description of the podcast
     * @param category This is the category of the podcast
     * @return String This returns a message that indicates if the podcast was added or not
     */
    public String addAudio(String name, int h,int m , int s, String url,String nickname, String description, int category){
        String msg = "The audio was added successfully";
        Audio obj = searchAudio(name);
        User autor = searchUser(nickname);
        int duration = toSeconds(h,m,s);
        if (autor!=null){
            if (autor instanceof ContentCreator){
                if (obj==null){
                    obj = new Podcast(name, duration, url, autor, description, category);
                    audios.add(obj);
                    autor.addAudio((Podcast)obj);
                }else{
                    msg = "The audio already exists";
                }
            }else if (autor instanceof Artist){
                msg = "The user is not a content creator";
            }
        }else{
            msg = "The user does not exist";
        }
        return msg;
    }

    
    /** 
     * <b>addAudioToPlaylist</b><br>This method adds an audio to a playlist.
     * @param nameSong This is the name of the song
     * @param namePlaylist  This is the name of the playlist
     * @param nickname This is the nickname of the user that owns the playlist
     * @return String This returns a message that indicates if the song was added to the playlist or not
     */
    public String addAudioToPlaylist(String nameSong, String namePlaylist, String nickname){
        String msg = "";
        User obj = searchUser(nickname);
        Audio song = searchAudio(nameSong);
        if (obj!=null){
            if (song!=null){
                if (obj instanceof Consumer){
                    msg = ((Consumer)obj).addAudioToPlaylist(namePlaylist, song);
                    
                }
            }else{
                msg = "The audio does not exist";
            }    
        }else{
            msg = "The user does not exist";
        }
        return msg;
    }

    
    /** 
     * <b>addPlaylistToConsumer</b><br>This method adds a playlist to a consumer user.
     * @param name This is the name of the playlist
     * @param nickname This is the nickname of the user that owns the playlist
     * @return String This returns a message that indicates if the playlist was added to the user or not
     */
    public String addPlaylistToConsumer(String name, String nickname){
        String msg = "";
        User obj = searchUser(nickname);
        if (obj!=null){
            if (obj instanceof Premium){
                msg = ((Premium)obj).addPlaylist(name);
            }else if (obj instanceof Estandar){
                msg = ((Estandar)obj).addPlaylist(name);
            }
        }else{
            msg = "The user does not exist";
        }

        return msg;

    }

    
    /** 
     * <b>searchUser</b><br>This method searches a user in the system.
     * @param nickName This is the nickname of the user to search
     * @return User This returns the user if it exists or null if it does not
     */
    public User searchUser(String nickName){
        User obj = null;
        boolean found = false;
        for(int i=0; i<users.size() && !found; i++){
            if(users.get(i).getNickName().equals(nickName)){
                obj = users.get(i);
                found = true;
            }
        }
        return obj;
    }

    
    /** 
     * <b>searchAudio</b><br>This method searches an audio in the system.
     * @param name This is the name of the audio to search
     * @return Audio This returns the audio if it exists or null if it does not
     */
    public Audio searchAudio(String name){
        Audio obj = null;
        boolean found = false;
        for(int i=0; i<audios.size() && !found; i++){
            if(audios.get(i).getName().equals(name)){
                obj = audios.get(i);
                found = true;
            }
        }
        return obj;
    }

    
    /** 
     * <b>searchContentCreator</b><br>This method searches a content creator in the system.
     * @param nickname This is the nickname of the content creator to search
     * @return User This returns the content creator if it exists or null if it does not
     */
    public User searchContentCreator(String nickname ){

        User obj = null;
        boolean found = false;
        for(int i=0; i<users.size() && !found; i++){
            if(users.get(i) instanceof ContentCreator && users.get(i).getNickName().equals(nickname)){
                obj = users.get(i);
                found = true;
            }
        }
        return obj;

    }

    
    /** 
     * <b>searchArtist</b><br>This method searches an artist in the system.
     * @param nickname This is the nickname of the artist to search
     * @return User This returns the artist if it exists or null if it does not
     */
    public User searchArtist(String nickname ){

        User obj = null;
        boolean found = false;
        for(int i=0; i<users.size() && !found; i++){
            if(users.get(i) instanceof Artist && users.get(i).getNickName().equalsIgnoreCase(nickname)){
                obj = users.get(i);
                found = true;
            }
        }
        return obj;

    }

    
    /** 
     * <b>existProducers</b><br>This method checks if  exists at least one producer in the system.
     * @return boolean This returns true if there is at least one producer in the system or false if there is not
     */
    public boolean existProducers(){

        boolean exist = false;
        for(int i=0; i<users.size() && !exist; i++){
            if(users.get(i) instanceof Productor){
                exist = true;
            }
        }
        return exist;
        
    }

    
    /** 
     * <b>existArtist</b><br>This method checks if  exists at least one artist in the system.
     * @return boolean This returns true if there is at least one artist in the system or false if there is not
     */
    public boolean existArtist(){

        boolean exist = false;
        for(int i=0; i<users.size() && !exist; i++){
            if(users.get(i) instanceof Artist){
                exist = true;
            }
        }
        return exist;
    }

    
    /** 
     * <b>existContentCreator</b><br>This method checks if  exists at least one content creator in the system.
     * @return boolean This returns true if there is at least one content creator in the system or false if there is not
     */
    public boolean existContentCreator(){
        boolean exist = false;
        for(int i=0; i<users.size() && !exist; i++){
            if(users.get(i) instanceof ContentCreator){
                exist = true;
            }
        }
        return exist;
    }

    
    /** 
     * <b>existConsumer</b><br>This method checks if  exists at least one consumer in the system.
     * @return boolean This returns true if there is at least one consumer in the system or false if there is not
     */
    public boolean existConsumer(){
            
        boolean exist = false;
        for(int i=0; i<users.size() && !exist; i++){
            if(users.get(i) instanceof Consumer){
                exist = true;
            }
        }
        return exist;    
    }

    
    /** 
     * <b>existAudio</b><br>This method checks if  exists at least one audio in the system.
     * @return boolean This returns true if there is at least one audio in the system or false if there is not
     */
    public boolean existAudios(){
        boolean exist = false;
        for(int i=0; i<audios.size() && !exist; i++){
            if(audios.get(i) instanceof Song){
                exist = true;
            }
        }
        return exist;
    }

    
    /** 
     * <b>existPlaylists</b><br>This method checks if  exists at least one playlist registerd to the user.
     * @param nickname This is the nickname of the consumer to search
     * @return boolean This returns true if there is at least one playlist register to an user or false if there is not
     */
    public boolean existPlaylist(String nickname){
        boolean exist = false;
        User obj = searchUser(nickname);
        if (obj!=null){
            if (obj instanceof Consumer){
                
                exist= ((Consumer)obj).existPlaylists();

            }
        }
        return exist;
    }

    
    /** 
     * <b>showArtist</b><br>This method shows the artist in the system.
     * @return String This returns the list of artists in the system
     */
    public String showArtist(){
        String msg = "";
        for(int i=0; i<users.size(); i++){
            if(users.get(i) instanceof Artist){
                msg += users.get(i).getNickName()+"\n";
            }
        }
        return msg;
    }

    
    /** 
     * <b>showContentCreator</b><br>This method shows the content creators in the system.
     * @return String This returns the list of content creators in the system
     */
    public String showContentCreator(){
        String msg = "";
        for(int i=0; i<users.size(); i++){
            if(users.get(i) instanceof ContentCreator){
                msg += users.get(i).getNickName()+"\n";
            }
        }
        return msg;
    }

    
    /** 
     * <b>showConsumer</b><br>This method shows the consumers in the system.
     * @return String This returns the list of consumers in the system
     */
    public String showConsumer(){
        String msg = "";
        for(int i=0; i<users.size(); i++){
            if(users.get(i) instanceof Consumer){
                msg += users.get(i).getNickName()+"\n";
            }
        }
        return msg;
    }
    
    /**<b>showAudios</b><br>This method shows the audios in the system. 
     * @return String This returns the list of audios in the system
     */
    public String showAudios(){
        String msg = "";
        for(int i=0; i<audios.size(); i++){
            if(audios.get(i) instanceof Song){
                msg += audios.get(i).getName()+"\n";
            }
        }
        return msg;
    }
    
    /** 
     * <b>editPlaylist</b><br>This method edits the name of a playlist.
     * @param nickname This is the nickname of the consumer that owns the playlist
     * @param name This is the name of the playlist to edit
     * @param newName This is the new name of the playlist
     * @return String This returns a message that indicates if the playlist was edited or not
     */
    public String editPlaylist(String nickname, String name, String newName){
        String msg = "The playlist was edited successfully";
        User obj = searchUser(nickname);
        if (obj!=null){
            if (obj instanceof Consumer){
                msg = ((Consumer)obj).editPlaylist(name, newName);
            }else{
                msg = "The user is not a consumer";
            }
        }else{
            msg = "The user does not exist";
        }

        return msg;
    }

    
    /** 
     * <b>showPlaylist</b><br>This method shows the list of a playlist of an user.
     * @param nickname This is the nickname of the consumer that owns the playlist
     * @return String This returns the list of a playlist of an user
     */
    public String showPlaylist(String nickname){
        String msg = "";
        User obj = searchUser(nickname);
        if (obj!=null){
            if (obj instanceof Consumer){
                msg = ((Consumer)obj).showPlaylists();
            }else{
                msg = "The user is not a consumer";
            }
        }else{
            msg = "The user does not exist";
        }

        return msg;
    }

    
    /** 
     * <b>showPlaylistAudios</b><br>This method shows the list of audios on a playlist.
     * @param nickname This is the nickname of the consumer that owns the playlist
     * @param name This is the name of the playlist
     * @return String This returns the list of audios on a playlist
     */
    public String showPlaylistAudios(String nickname, String name){
        String msg = "";
        User obj = searchUser(nickname);
        if (obj!=null){
            if (obj instanceof Consumer){
                msg = ((Consumer)obj).showPlaylistAudios(name);
            }else{
                msg = "The user is not a consumer";
            }
        }else{
            msg = "The user does not exist";
        }

        return msg;
    }

    
    /** 
     * <b>removeAudioFromPlaylist</b><br>This method removes an audio from a playlist.
     * @param name This is the name of the playlist 
     * @param nickname This is the nickname of the consumer that owns the playlist
     * @param songName This is the name of the audio to remove
     * @return String This returns a message that indicates if the audio was removed or not
     */
    public String removeAudioFromPlaylist(String name, String nickname, String songName){
        String msg = "The song was removed successfully";
        User obj = searchUser(nickname);
        Audio song = searchAudio(songName);
        if (obj!=null&&song!=null){
            if (obj instanceof Consumer){
                msg = ((Consumer)obj).removeAudioFromPlaylist(name, song);
            }else{
                msg = "The user is not a consumer ";
            }
        }else{
            msg = "The user or the song does not exist";
        }

        return msg;

    }

    /** 
     * <b>sharePlaylist</b><br>This method shares a playlist with another user.
     * @param nickname This is the nickname of the consumer that owns the playlist
     * @param name This is the name of the playlist
     * @return String This returns a message with the code of the playlist
     */
    public String sharePlaylist(String nickname,String name){
        String msg = "The playlist was shared successfully";
        User obj = searchUser(nickname);
        if (obj!=null){
            if (obj instanceof Consumer){
                msg = ((Consumer)obj).sharePlaylist(name);
            }else{
                msg = "The user is not a consumer";
            }
        }else{
            msg = "The user does not exist";
        }

        return msg;
    }

    /** 
     * <b>toSeconds</b><br>This method converts a time in seconds.
     * @param h This is the hours of the time
     * @param m This is the minutes of the time
     * @param s This is the seconds of the time
     * @return int This returns the time in seconds
     */
    public int toSeconds(int h,int m,int s){
        int seconds = 0;
        seconds+=(h*3600)+m*60+s;
        return seconds;
    }

    /** 
     * <b>getName</b><br>This method gets the name of the system.
     * @return String This returns the name of the system
     */
    public String getName() {
        return name;
    }
    
    /** 
     * <b>setName</b><br>This method sets the name of the system.
     * @param name This is the name of the system
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * <b>getUsers</b><br>This method gets the list of users in the system.
     * @return ArrayList This returns the list of users in the system
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    
    /** 
     * <b>setUsers</b><br>This method sets the list of users in the system.
     * @param users This is the list of users in the system
     */
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    
    /** 
     * <b>getAudios</b><br>This method gets the list of audios in the system.
     * @return ArrayList This returns the list of audios in the system
     */
    public ArrayList<Audio> getAudios() {
        return audios;
    }

    
    /** 
     * <b>setAudios</b><br>This method sets the list of audios in the system.
     * @param audios This is the list of audios in the system
     */
    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
    }
    
}
