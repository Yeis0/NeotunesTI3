package model;

import java.time.*;

/**
 * <b>Shop</b><br>
 * is a class that represents a shop of a song made by a consumer.
 * 
 * @author Yeison Antonio Rodriguez Zuluaga.
 */
public class Shop {

    private Song song;
    private LocalDate operationDate;

    /**
     * <b>Constructor</b> allows to create a Shop's object.
     * 
     * @param audio is the song that the consumer bought.
     */
    public Shop(Song audio) {
        this.song = audio;
        operationDate = LocalDate.now();
    }

    /**
     * <b>getSong</b> allows to get the song that the consumer bought.
     * 
     * @return Song the song that the consumer bought.
     */
    public Song getSong() {
        return song;
    }

    /**
     * <b>setSong</b> allows to set the song that the consumer bought.
     * 
     * @param audio is the song that the consumer bought.
     */
    public void setSong(Song audio) {
        this.song = audio;
    }

    /**
     * <b>getOperationDate</b> allows to get the date of the operation.
     * 
     * @return LocalDate the date of the operation.
     */
    public LocalDate getOperationDate() {
        return operationDate;
    }

    /**
     * <b>setOperationDate</b> allows to set the date of the operation.
     * 
     * @param operationDate is the date of the operation.
     */
    public void setOperationDate(LocalDate operationDate) {
        this.operationDate = operationDate;
    }

}
