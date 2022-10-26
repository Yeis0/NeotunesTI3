package model;

public class Song extends Audio implements Playable {

    private String album;
    private double price;
    private int sellAmount;

    private Genre genre;

    public Song(String name, double duration, String url, String album, double price,int genre) {
        super(name, duration, url);
        this.album = album;
        this.price = price;

        switch(genre){
            case 1:
                this.genre = Genre.ROCK;
                break;
            case 2:
                this.genre = Genre.POP;
                break;
            case 3:
                this.genre = Genre.TRAP;
                break;
            case 4:
                this.genre = Genre.HOUSE;
                break;
        }
    }

    public String playsStandar(){
        return "The song " + getName() + " is playing";
    }

    public String playsPremium(){
        return "The song " + getName() + " is playing";
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(int sellAmount) {
        this.sellAmount = sellAmount;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    
}
