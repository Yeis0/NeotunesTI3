package model;
import java.util.ArrayList;

public class NeoTunesController {

    private String name;
    
    private ArrayList<User> users;
    
    public NeoTunesController(String name){

        this.name=name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }


    
}
