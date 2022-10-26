package ui;

import model.NeoTunesController;
import java.util.Scanner;

public class NeoTunesApp {

    private NeoTunesController neoTunesController;
    
    public NeoTunesApp(){

        neoTunesController = new NeoTunesController("NeoTunes");
        
    }

    public static void main(String[] args){
        
        NeoTunesApp neoTunesApp = new NeoTunesApp();
        neoTunesApp.showMenu();
        
            

    }

    public void showMenu (){


    }

}
