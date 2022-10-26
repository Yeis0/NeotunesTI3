package model;

import java.util.ArrayList;



public class ContentCreator extends Productor {

    private ArrayList <Podcast> podcasts;

    public ContentCreator(String nickName, String idNumber, int d, int m, int y, String name, String url){
        super(nickName, idNumber, d, m, y, name, url);
    }

    public ArrayList<Podcast> getPodcasts() {
        return podcasts;
    }

    public void setPodcasts(ArrayList<Podcast> podcasts) {
        this.podcasts = podcasts;
    }
    
    
}
