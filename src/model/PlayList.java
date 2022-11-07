package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * <b>PlayList</b> <br>This class represents a playlist. <br>
 * @author Yeison Antonio Rodriguez Zuluaga.
 */
public class PlayList {

    /**
     * a global variable that allows to generate a random number.
     */
    public static Random random = new Random();

    private ArrayList<Audio> audioList;
    private String name;
    private int[][] code;

    /**
     * <b>Constructor</b> allows to create a PlayList's object.
     * @param name is the playlist's name.
     */
    public PlayList(String name) {
        this.name = name;
        audioList = new ArrayList<Audio>();
        code = new int[6][6];
        generateMatrizCode();
    }

    /**
     * <b>generateMatrizCode</b> allows to generate a random code.
     */
    public void generateMatrizCode(){
        for (int i=0;i<6;i++){
            for (int j=0;j<6;j++){
                code[i][j]=random.nextInt(10);
            }
        }

    }

    /**
     * <b>generateCode</b> allows to generate a code based on the matriz code.
     */
    public void generateCode(){
        for (int i=0;i<audioList.size();i++){
        }
    }

    
    /** 
     * <b>share</b> allows to share the playlist.
     * @return String the playlist's code.
     */
    public String share(){
        String msg = "The code is: ";
        for (int i=0;i<6;i++){
            for (int j=0;j<6;j++){     
                msg += code[i][j];   
            }   
            msg += "";
        }   
        return msg;
    }

    
    /** 
     * <b>addAudio</b> allows to add an audio to the playlist.
     * @param audio is the audio to be added.
     * @return String the message that indicates if the audio was added successfully or not.
     */
    public String addAudio(Audio audio) {

        String msg = "The audio was added successfully";
        Audio obj = searchAudio(audio.getName());
        if (obj == null) {
            audioList.add(audio);
        } else {
            msg = "The audio already exists";
        }
        return msg;

    }

    
    /** 
     * <b>searchAudio</b> allows to search an audio in the playlist.
     * @param name is the name of the audio to be searched.
     * @return Audio the audio that was searched.
     */
    public Audio searchAudio(String name) {

        Audio obj = null;
        boolean search = false;
        if (audioList != null) {
            for (int i = 0; i < audioList.size() && !search; i++) {
                if (audioList.get(i).getName().equalsIgnoreCase(name)) {
                    obj = audioList.get(i);
                    search = true;
                }
            }
        }
        return obj;
    }

    
    /** 
     * <b>showAudios</b><br> allows to show the audios in the playlist.
     * @return String the audios in the playlist.
     */
    public String showAudios(){
        String msg = "";  
        for (int i=0;i<audioList.size();i++){
            msg += audioList.get(i).getName() + "\n";
        }    
        return msg;
    }

    
    /** 
     * <b>removeAudio</b> <br>allows to remove an audio from the playlist.
     * @param audio is the audio to be removed.
     * @return String the message that indicates if the audio was removed successfully or not.
     */
    public String removeAudio(Audio audio){
            
            String msg = "The audio was removed successfully";
            Audio obj = searchAudio(audio.getName());
            if (obj != null) {
                audioList.remove(audio);
            } else {
                msg = "The audio doesn't exist";
            }
            return msg;
    }

    
    
    /** 
     * <b>getName</b> allows to get the playlist's name.
     * @return String the playlist's name.
     */
    public String getName() {
        return name;
    }

    
    /** 
     * <b>setName</b> allows to set the playlist's name.
     * @param name  is the playlist's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** <b>getAudioList</b> allows to get the audios in the playlist.
     * @return ArrayList the audios in the playlist.
     */
    public ArrayList<Audio> getAudioList() {
        return audioList;
    }

    
    /** 
     * <b>setAudioList</b> allows to set the audios in the playlist.
     * @param audioList is the audios in the playlist.
     */
    public void setAudioList(ArrayList<Audio> audioList) {
        this.audioList = audioList;
    }

    
    /** 
     * <b>getCode</b> allows to get the playlist's code.
     * @return int[][] the playlist's code.
     */
    public int[][] getCode() {
        return code;
    }

    
    /** 
     * <b>setCode</b> allows to set the playlist's code.
     * @param code is the playlist's code.
     */
    public void setCode(int[][] code) {
        this.code = code;
    }
    
}
