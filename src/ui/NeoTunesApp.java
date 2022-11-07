package ui;

import model.NeoTunesController;
import java.util.Scanner;

/**
 * <b>NeoTunesApp</b><br>Is the main class of the application. It is responsible for interacting with the user.<br>
 * @author Yeison Antonio Rodriguez Zuluaga.
 */
public class NeoTunesApp {
    /**
     * A Global variable that allows to read the user's input.
     */
    public static Scanner reader = new Scanner(System.in);
    private NeoTunesController neoTunesController;
    
    /**
     * <b>NeoTunesApp</b> is the constructor of the class NeoTunesApp.
     */
    public NeoTunesApp(){
        neoTunesController = new NeoTunesController("NeoTunes");
    }

    
    /** 
     * This is the main method of the application.<br>
     * @param args The arguments of the main method
     */
    public static void main(String[] args){
        
        NeoTunesApp neoTunesApp = new NeoTunesApp();
        int option;
        System.out.println("Welcome to NeoTunes");
        do{
            neoTunesApp.showMenu();
            option = reader.nextInt();
            reader.nextLine();
            neoTunesApp.executeOption(option);
        }while(option != 0);

    }

    /** 
     *<b>showMenu</b><br> shows the menu of the application.<br>
     *This method shows the menu of the application.
     */
    public void showMenu (){
        System.out.println("Type a number to select an option");
        System.out.println("1.add a new Productor\n2.add a new Consumer\n3.add a new audio(Song-Podcast)\n4.Create a playlist");
        System.out.println("5.Edit a playList\n6.Share a playList\n7.Plays a song or a podcast\n8.Buy a song\n9.Show the total playback for audio type");
        System.out.println("10.Show the most heared genre\n11.Show the most heared podcast category\n12.Show the top 5 artists or producer\n13.Show the top 5 podcast or songs");
        System.out.println("14.Show the total sales for all genres\n15.Show the most saled song\n0.Exit");
        
    }

    
    /** 
     * <b>executeOption</b><br> executes the option selected by the user.<br>
     * @param option the option that the user selected.
     */
    public void executeOption(int option){
        switch(option){
            case 1:
                addProductor();
                break;
            case 2:
                addConsumer();
                break;
            case 3:
                addAudio();
                break;
            case 4:
                createPlayList();
                break;
            case 5:
                editPlaylist();
                break;
            case 6:
                
                break;
            case 7:
                
                break;
            case 8:
                
                break;
            case 9:
                
                break;
            case 10:
                
                break;
            case 11:
                
                break;
            case 12:
                
                break;
            case 13:
                
                break;
            case 14:
                
                break;
            case 15:
                
                break;
            case 0:
                System.out.println("Bye bye\n");
                break;
            default:
                System.out.println("Invalid option\n");
                break;
        }
    }

    /**
     * <b>addProductor</b><br> adds a new productor to the application.<br>
     */
    public void addProductor(){
        
        System.out.println("Type the nickname of the Producer");
        String nickName = reader.nextLine();
        System.out.println("Type the id number of the producer");
        String idNumber = reader.nextLine();
        System.out.println("Type the name of the producer");
        String name = reader.nextLine();
        System.out.println("Type the url of the producer");
        String url = reader.nextLine();
        int type;
        do{
            System.out.println("Type the type of the producer:\n 1.Artist\n 2.ContentCreator");
            type = reader.nextInt();
            reader.nextLine();
            if (type!=1 && type!=2){
                System.out.println("Invalid option");
            }
        }while(type!=1 && type!=2);
        
        System.out.println(neoTunesController.addUser(nickName, idNumber, name,url,type));
    }

    /**
     * <b>addConsumer</b><br> adds a new consumer to the application.<br>
     */
    public void addConsumer(){

        System.out.println("Type the nickname of the User ");
        String nickName = reader.nextLine();
        System.out.println("Type the id number of the user");
        String idNumber = reader.nextLine();
        int type;
        do{
            System.out.println("Type the type of the user:\n 1.Premium\n 2.Standard");
            type = reader.nextInt();
            reader.nextLine();
            if (type!=1 && type!=2){
                System.out.println("Invalid option");
            }
        }while (type!=1 && type!=2);
        System.out.println(neoTunesController.addUser(nickName, idNumber, type));
    
    }

    /**
     * <b>addAudio</b><br> adds a new audio to the application.<br>
     */
    public void addAudio(){
        if (neoTunesController.existProducers()){
            System.out.println("Type the name of the audio");
            String name = reader.nextLine();
            boolean correct=false;
            String duration;
            int hours=0, minutes=0, seconds=0;

            do{
                System.out.println("Type the duration of the audio, using the format hh:mm:ss, please use two digits for each number");
                duration = reader.nextLine();
                if (duration.substring(2, 3).equals(":")&&duration.substring(5, 6).equals(":")){
                    hours = Integer.parseInt(duration.substring(0, 2));
                    minutes = Integer.parseInt(duration.substring(3, 5));
                    seconds = Integer.parseInt(duration.substring(6, 8));
                    if (hours>=0 && hours<=23 && minutes>=0 && minutes<=59 && seconds>=0 && seconds<=59){
                        correct=true;
                    }else {
                        System.out.println("Invalid duration");
                    }
                }else{
                    System.out.println("Invalid duration");
                }
                
            }while (!correct);
            int kind;
            do{
                System.out.println("Type the kind of audio:\n 1.Song\n 2.Podcast");
                kind = reader.nextInt();
                reader.nextLine();
                if (kind!=1 && kind!=2){
                    System.out.println("Invalid option");
                }
            }while(kind!=1 && kind!=2);
            if (kind==1){
                System.out.println("Select the producer of the song, please select the nickname");
                System.out.println(neoTunesController.showArtist());
                String nickname = reader.nextLine();
                if (neoTunesController.searchArtist(nickname)!=null){
                    System.out.println("Type the album of the song");
                    String album = reader.nextLine();
                    System.out.println("Type the url of the album cover");
                    String url = reader.nextLine();
                    System.out.println("Type the value of the song");
                    double value = reader.nextDouble();
                    reader.nextLine();
                    System.out.println("Select the genre of the song:\n1.Rock\n2.Pop\n3.Trap\n4.House");
                    int genre = reader.nextInt();
                    reader.nextLine();

                    System.out.println(neoTunesController.addAudio(name, hours,minutes,seconds,url, nickname, album,value, genre));
                }else{
                    System.out.println("The Producer doesn't exist or is a content creator");
                }
            }else{
                String nickname;
                do{
                    System.out.println("Select the producer of the podcast, please select the nickname");
                    System.out.println(neoTunesController.showContentCreator());
                    nickname = reader.nextLine();
                    if (nickname.equals("")){
                        System.out.println("Please select a producer");
                    }
                }while(nickname.equals(""));
                if (neoTunesController.searchContentCreator(nickname)!=null){
                    System.out.println("Type the url of the podcast");
                    String url = reader.nextLine();
                    System.out.println("Type the description of the podcast");
                    String description = reader.nextLine();
                    System.out.println("Select the category of the podcast:\n1.Policy\n2.Entertainment\n3.Videogames\n4.Fashion");
                    int category = reader.nextInt();
                    reader.nextLine();
                    System.out.println(neoTunesController.addAudio(name, hours,minutes,seconds,url, nickname, description, category));
                }else{
                    System.out.println("The Producer doesn't exist or is a artist");
                }
            }   
        }else{
            System.out.println("Please, add a producer first");
        }         
    }

    /**
     * <b>createPlaylist</b><br> adds a new playlist to a consumer user.<br>
     */
    public void createPlayList(){
        if (neoTunesController.existConsumer()){
            if (neoTunesController.existAudios()){
                System.out.println("Type the name of the playlist");
                String name = reader.nextLine();

                System.out.println("Write the nickname of the user.\n"+neoTunesController.showConsumer());
                String nickname = reader.nextLine();
                String message=neoTunesController.addPlaylistToConsumer(name,nickname);
                System.out.println(message);
                if (message.equalsIgnoreCase("Playlist added successfully")){
                    String songName;
                    do{
                        System.out.println("Write the name of the audio you want to add to the playlist. if you don't wanna add more audios please press enter.\n"+neoTunesController.showAudios());
                        songName = reader.nextLine();
                        if (!songName.equals("")){
                            System.out.println(neoTunesController.addAudioToPlaylist(songName,name,nickname));
                        }
    
                    }while(!songName.equals(""));
                }    
            }else{
                System.out.println("Please, add an audio first");
            }
        }else{
            System.out.println("Please, add a consumer first");
        }
    }

    /**
     * <b>editPlaylist</b><br> change the state of a playlist.Allows to change the name and add and delete songs.<br>
     */
    public void editPlaylist(){
        if (neoTunesController.existConsumer()){
            System.out.println("Write the nickname of the user.\nif the user is not in the list, please press enter.\n"+neoTunesController.showConsumer());
            String nickname = reader.nextLine();
            if(!nickname.equals("")){
                if (neoTunesController.existPlaylist(nickname)){
                    System.out.println("Write the name of the playlist.\nif the playlist is not in the list, please press enter.\n"+neoTunesController.showPlaylist(nickname));
                    String name = reader.nextLine();
                    if(!name.equals("")){
                        int option;
                        do{
                            System.out.println("Select an option for what you wanna do:\n1.Change playlist name\n2.Add audio\n3.Remove audio\n0.Exit");
                            option = reader.nextInt();
                            reader.nextLine();
                            switch (option){
                                case 1:
                                    System.out.println("Write the new name of the playlist");
                                    String newName = reader.nextLine();
                                    System.out.println(neoTunesController.editPlaylist(nickname,name,newName));
                                    break;
                                case 2:
                                    System.out.println("Write the name of the audio you want to add to the playlist.\n"+neoTunesController.showAudios());
                                    String songName = reader.nextLine();
                                    System.out.println(neoTunesController.addAudioToPlaylist(songName,name,nickname));
                                    break;
                                case 3:
                                    System.out.println("Write the name of the audio you want to remove from the playlist.\n"+neoTunesController.showPlaylistAudios(nickname,name));
                                    songName = reader.nextLine();
                                    System.out.println(neoTunesController.removeAudioFromPlaylist(name,nickname,songName));
                                    break;
                                default:
                                    System.out.println("Invalid option");
                                    break;
                            }
                        }while(option!=0);
                        
                        
                    }else{
                        System.out.println("Please, add the playlist first");
                    }
                }
            }
        }else{
            System.out.println("Please, add a consumer first");
        }
    }

}
