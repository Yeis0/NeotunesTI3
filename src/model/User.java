package model;

import java.util.GregorianCalendar;

public abstract class User {

    private String nickName;
    private String idNumber;
    private GregorianCalendar vinculationDate;
    

    public User(String nickName, String idNumber, int d,int m,int y){

        this.nickName=nickName;
        this.idNumber=idNumber;
        vinculationDate=new GregorianCalendar(y,m,d);

    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public GregorianCalendar getVinculationDate() {
        return vinculationDate;
    }

    public void setVinculationDate(GregorianCalendar vinculationDate) {
        this.vinculationDate = vinculationDate;
    }

    public String toString(){
        return "Nickname: "+nickName+"\nID: "+idNumber+"\nVinculation date: "+vinculationDate.toString();
    }
    
}
