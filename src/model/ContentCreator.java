package model;

import java.util.ArrayList;

/**
 * <b>ContentCreator</b> <br>This class represents a content creator. <br>
 * @author Yeison Antonio Rodriguez Zuluaga.
 */
public class ContentCreator extends Productor {

    private ArrayList <Podcast> podcasts;

    /**
     * <b>Constructor</b> allows to create a ContentCreator's object.
     * @param nickName is the user's nickname.
     * @param idNumber is the user's identification number.
     * @param name is the productor's name.
     * @param url is the productor's url.
     */
    public ContentCreator(String nickName, String idNumber, String name, String url){
        super(nickName, idNumber, name, url);
        podcasts = new ArrayList <Podcast>();
    }

    
    /** 
     * <b>addAudio</b> allows to add a podcast to the user's list of podcasts.
     * @param audio is the podcast to be added.
     * @return String the message of the operation.
     */
    public String addAudio(Audio audio){

        String msg="The podcast was added successfully";
        Audio obj = searchAudio(audio.getName());
        if (obj==null){
            podcasts.add((Podcast) audio);
        }else{
            msg = "The audio already exists";
        }
        return msg;
    }

    /** 
     * <b>searchAudio</b> allows to search an audio in the user's list of audios.
     * @param name is the name of the audio to be searched.
     * @return Audio the audio found.
     */
    public Audio searchAudio(String name){

        Audio obj = null;
        boolean search = false;
        if (podcasts != null) {
            for (int i = 0; i < podcasts.size() && !search; i++) {
                if (podcasts.get(i).getName().equalsIgnoreCase(name)) {
                    obj = podcasts.get(i);
                    search = true;
                }
            }
        }

        return obj;

    }

    /** 
     * <b>getPodcasts</b> allows to get the user's list of podcasts.
     * @return ArrayList the user's list of podcasts.
     */
    public ArrayList<Podcast> getPodcasts() {
        return podcasts;
    }

    /** 
     * <b>setPodcasts</b> allows to set the user's list of podcasts.
     * @param podcasts is the user's list of podcasts.
     */
    public void setPodcasts(ArrayList<Podcast> podcasts) {
        this.podcasts = podcasts;
    }
    
    
}
