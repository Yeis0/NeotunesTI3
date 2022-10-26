package model;

public class Productor extends User{

    private String name;
    private String url;
    private int accumulatedPlayback;
    private double timePlayed;

    public Productor(String nickName, String idNumber, int d, int m, int y, String name, String url) {
        super(nickName, idNumber, d, m, y);
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public int getAccumulatedPlayback() {
        return accumulatedPlayback;
    }

    public void setAccumulatedPlayback(int accumulatedPlayback) {
        this.accumulatedPlayback = accumulatedPlayback;
    }

    public double getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(double timePlayed) {
        this.timePlayed = timePlayed;
    }
}
