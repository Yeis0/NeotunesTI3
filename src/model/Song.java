package model;

/**
 * <b>Song</b> is a class that represents a song of the application.
 * 
 * @author Yeison Antonio Rodriguez Zuluaga.
 */
public class Song extends Audio implements Sellable {

    private String album;
    private double price;
    private int sellAmount;

    private Genre genre;

    /**
     * <b>Constructor</b> allows to create a Song's object.
     * 
     * @param name     is the song's name.
     * @param duration is the song's duration.
     * @param url      is the song's url.
     * @param autor    is the song's autor.
     * @param album    is the song's album.
     * @param price    is the song's price.
     * @param genre    is the song's genre.
     */
    public Song(String name, int duration, String url, User autor, String album, double price, int genre) {
        super(name, duration, url, autor);
        this.album = album;
        this.price = price;
        sellAmount=0;


        switch (genre) {
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

    public String sell(){
        sellAmount++;
        super.getAutor().updateSoldInfo(super.getDuration());
        return "The song " + getName() + " has been sold";
        
    }

    public double totalSell(){
        double totalSells= sellAmount*price;
        return totalSells;
    }

    /**
     * <b>getAlbum</b> allows to get the song's album.
     * 
     * @return String the song's album.
     */
    public String getAlbum() {
        return album;
    }

    /**
     * <b>setAlbum</b> allows to set the song's album.
     * 
     * @param album is the song's album.
     */
    public void setAlbum(String album) {
        this.album = album;
    }

    /**
     * <b>getPrice</b> allows to get the song's price.
     * 
     * @return double the song's price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * <b>setPrice</b> allows to set the song's price.
     * 
     * @param price is the song's price.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * <b>getSellAmount</b> allows to get the song's sell amount.
     * 
     * @return int the song's sell amount.
     */
    public int getSellAmount() {
        return sellAmount;
    }

    /**
     * <b>setSellAmount</b> allows to set the song's sell amount.
     * 
     * @param sellAmount is the song's sell amount.
     */
    public void setSellAmount(int sellAmount) {
        this.sellAmount = sellAmount;
    }

    /**
     * <b>getGenre</b> allows to get the song's genre.
     * 
     * @return Genre the song's genre.
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * <b>setGenre</b> allows to set the song's genre.
     * 
     * @param genre is the song's genre.
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

}
