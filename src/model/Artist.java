package model;

import java.util.ArrayList;

public class Artist extends ContentCreator {

    private ArrayList <Song> songs;

    public Artist(String nickName, String idNumber, int d, int m, int y, String name, String url){
        super(nickName, idNumber, d, m, y, name, url);
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
    

    
}
