package model;

import java.util.ArrayList;

public class Consumer extends User {

    private double totalPlayedTime;
    private int[] genrePlayback;
    private ArrayList<Integer> artistPlayback;
    private int[] CategoryPlayback;

    public Consumer(String nickName, String idNumber, int d, int m, int y) {
        super(nickName, idNumber, d, m, y);
    }

    public double getTotalPlayedTime() {
        return totalPlayedTime;
    }

    public void setTotalPlayedTime(double totalPlayedTime) {
        this.totalPlayedTime = totalPlayedTime;
    }

    public int[] getGenrePlayback() {
        return genrePlayback;
    }

    public void setGenrePlayback(int[] genrePlayback) {
        this.genrePlayback = genrePlayback;
    }

    public ArrayList<Integer> getArtistPlayback() {
        return artistPlayback;
    }

    public void setArtistPlayback(ArrayList<Integer> artistPlayback) {
        this.artistPlayback = artistPlayback;
    }

    public int[] getCategoryPlayback() {
        return CategoryPlayback;
    }

    public void setCategoryPlayback(int[] CategoryPlayback) {
        this.CategoryPlayback = CategoryPlayback;
    }    
    
}
