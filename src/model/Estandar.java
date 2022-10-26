package model;

public class Estandar extends Consumer {

    private int[] audios;
    private int[] playlists;

    public Estandar(String nickName, String idNumber, int d, int m, int y) {
        super(nickName, idNumber, d, m, y);
    }
    
    
    public int[] getAudios() {
        return audios;
    }

    public void setAudios(int[] audios) {
        this.audios = audios;
    }

    public int[] getPlaylists() {
        return playlists;
    }

    public void setPlaylists(int[] playlists) {
        this.playlists = playlists;
    }

}
