package model;

import java.util.ArrayList;

public class Premium extends Consumer {

    private ArrayList<Audio> audios;
    private ArrayList<PlayList> playlists;

    public Premium(String nickName, String idNumber, int d, int m, int y) {
        super(nickName, idNumber, d, m, y);
    }
    
    public ArrayList<Audio> getAudios() {
        return audios;
    }

    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
    }

    public ArrayList<PlayList> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<PlayList> playlists) {
        this.playlists = playlists;
    }
    
}
