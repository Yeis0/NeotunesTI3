package model;

import java.util.ArrayList;
import java.util.Random;

public class PlayList {

    public static Random random = new Random();

    private ArrayList<Audio> audioList;
    private String name;
    private int[][] code;

    public PlayList(String name) {
        this.name = name;
        audioList = new ArrayList<Audio>();
        code = new int[6][6];
    }

    public void generateCode(){

        for (int i=0;i<6;i++){
            for (int j=0;j<6;j++){
                code[i][j]=random.nextInt(6);
            }
        }

    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Audio> getAudioList() {
        return audioList;
    }

    public void setAudioList(ArrayList<Audio> audioList) {
        this.audioList = audioList;
    }

    public int[][] getCode() {
        return code;
    }

    public void setCode(int[][] code) {
        this.code = code;
    }
    
}
