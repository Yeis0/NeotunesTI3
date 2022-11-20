package model;

import java.time.*;

/**
 * <b>User</b><br>
 * is a class that represents a user of the application.
 * 
 * @author Yeison Antonio Rodriguez Zuluaga.
 */
public abstract class User {

    private String nickName;
    private String idNumber;
    private LocalDate vinculationDate;

    /**
     * <b>Constructor</b> allows to create an User's object.
     * 
     * @param nickName is the user's nickname.
     * @param idNumber is the user's identification number.
     */
    public User(String nickName, String idNumber) {

        this.nickName = nickName;
        this.idNumber = idNumber;
        vinculationDate = LocalDate.now();
    }

    /**
     * <b>getNickName</b> allows to get the user's nickname.
     * 
     * @return String the user's nickname.
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * <b>setNickName</b> allows to set the user's nickname.
     * 
     * @param nickName is the user's nickname.
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * <b>getIdNumber</b> allows to get the user's identification number.
     * 
     * @return String the user's identification number.
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * <b>setIdNumber</b> allows to set the user's identification number.
     * 
     * @param idNumber is the user's identification number.
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * <b>getVinculationDate</b> allows to get the user's vinculation date.
     * 
     * @return LocalDate the user's vinculation date.
     */
    public LocalDate getVinculationDate() {
        return vinculationDate;
    }

    /**
     * <b>setVinculationDate</b> allows to set the user's vinculation date.
     * 
     * @param vinculationDate is the user's vinculation date.
     */
    public void setVinculationDate(LocalDate vinculationDate) {
        this.vinculationDate = vinculationDate;
    }

    /**
     * <b>toString</b> allows to get the user's information.
     * 
     * @return String the user's information.
     */
    public String toString() {
        return "Nickname: " + nickName + "\nID: " + idNumber + "\nVinculation date: " + vinculationDate.toString();
    }

}
