package ui;

import model.NeoTunesController;
import java.util.Scanner;

/**
 * <b>NeoTunesApp</b><br>
 * Is the main class of the application. It is responsible for interacting with
 * the user.<br>
 * 
 * @author Yeison Antonio Rodriguez Zuluaga.
 */
public class NeoTunesApp {

    /**
     * A Global variable that allows to read the user's input.
     */
    public static Scanner reader = new Scanner(System.in);

    private NeoTunesController objectController;

    /**
     * <b>NeoTunesApp</b> is the constructor of the class NeoTunesApp.
     */
    public NeoTunesApp() {
        objectController = new NeoTunesController("NeoTunes");
    }

    /**
     * This is the main method of the application.<br>
     * 
     * @param args The arguments of the main method
     */
    public static void main(String[] args) {

        NeoTunesApp appObject = new NeoTunesApp();
        int option;
        System.out.println("Welcome to NeoTunes");
        do {
            do {
                appObject.showMenu();
                option = reader.nextInt();
                reader.nextLine();
                if (option < 0 || option > 14) {
                    System.out.println("The option is not valid");
                }
                appObject.executeOption(option);
            } while (option < 0 || option > 14);

        } while (option != 0);

    }

    /**
     * <b>showMenu</b><br>
     * shows the menu of the application.<br>
     * This method shows the menu of the application.
     */
    public void showMenu() {
        System.out.println("\n-MENU-");
        System.out.println("1.Add an user\n2.Add an audio\n3.Create a playlist");
        System.out.println(
                "4.Edit a playList\n5.Share a playList\n6.Plays a song or a podcast\n7.Buy a song\n8.Show the total playback for audio type");
        System.out.println(
                "9.Show the most heared song genre\n10.Show the most heared podcast category\n11.Show the top 5 artists or producer\n12.Show the top 5 podcast or songs");
        System.out.println("13.Show the total sales for each genre\n14.Show the most saled song\n0.Exit");
        System.out.print("Select an option : ");
    }

    /**
     * <b>executeOption</b><br>
     * executes the option selected by the user.<br>
     * <b>pre:</b> The option must be a number between 0 and 14.<br>
     * <b>post:</b> The option selected by the user has been executed.<br>
     * 
     * @param option the option that the user selected.
     */
    public void executeOption(int option) {
        switch (option) {
            case 1:
                addUser();
                break;
            case 2:
                addAudio();
                break;
            case 3:
                createPlaylist();
                break;
            case 4:
                editPlaylist();
                break;
            case 5:
                sharePlaylist();
                break;
            case 6:
                playAudio();
                break;
            case 7:
                buyAudio();
                break;
            case 8:
                showTotalPlayback();
                break;
            case 9:
                showMostHearedGenre();
                break;
            case 10:
                showMostHearedCategory();
                break;
            case 11:
                showTop5Producers();
                break;
            case 12:
                showTop10Audios();
                break;
            case 13:
                showTotalSales();
                break;
            case 14:
                showMostSaledSong();
                break;
            case 0:
                System.out.println("\n Bye bye");
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    /**
     * <b>addUser</b><br>
     * reads the info and call the controller to add an user to the application.<br>
     */
    public void addUser() {
        System.out.println("-User adition-");
        System.out.print("Enter the user's nickname : ");
        String nickname = reader.nextLine();
        System.out.print("Enter the user's id : ");
        String id = reader.nextLine();
        int option;
        do {
            System.out.print("Select the User's type:\n1. Producer\n2. Consumer : ");
            option = reader.nextInt();
            reader.nextLine();
            if (option != 1 && option != 2) {
                System.out.println("Invalid option");
            }
        } while (option != 1 && option != 2);
        if (option == 1) {
            System.out.println("Enter the producer's name : ");
            String producerName = reader.nextLine();
            System.out.println("Enter the producer's url : ");
            String producerUrl = reader.nextLine();
            do {
                System.out.print("Select the Producer's type:\n1. Artist\n2. Content creator : ");
                option = reader.nextInt();
                reader.nextLine();
                if (option != 1 && option != 2) {
                    System.out.println("Invalid option");
                }
            } while (option != 1 && option != 2);
            System.out.println(objectController.addUser(nickname, id, producerName, producerUrl, option));
        } else {
            do {
                System.out.print("Select the Consumer's type:\n1. Premium\n2. Standard : ");
                option = reader.nextInt();
                reader.nextLine();
                if (option != 1 && option != 2) {
                    System.out.println("Invalid option");
                }
            } while (option != 1 && option != 2);
            System.out.println(objectController.addUser(nickname, id, option));
        }
    }

    /**
     * <b>addAudio</b><br>
     * reads the info and call the controller to add an audio to the
     * application.<br>
     */
    public void addAudio() {
        System.out.println("\n-Audio adition-");
        System.out.print("Enter the audio's name : ");
        String audioName = reader.nextLine();
        System.out.print("Enter the audio's autor : ");
        String audioAutor = reader.nextLine();
        int option;
        do {
            System.out.println("Select the audio's type:\n1. Song\n2. Podcast : ");
            option = reader.nextInt();
            reader.nextLine();
            if (option != 1 && option != 2) {
                System.out.println("Invalid option");
            }

        } while (option != 1 && option != 2);
        if (option == 1) {
            boolean correct = false;
            int minutes = 0;
            int seconds = 0;
            do {
                System.out.println(
                        "Enter the song's duration in format mm:ss, please enter eacho number with two digits : ");
                String songDuration = reader.nextLine();
                if (songDuration.length() != 5) {
                    System.out.println("Invalid format");
                } else if (songDuration.charAt(2) != ':') {
                    System.out.println("Invalid format");
                } else if (Integer.parseInt(songDuration.substring(0, 2)) > 59
                        || Integer.parseInt(songDuration.substring(3, 5)) > 59) {

                    System.out.println("Invalid format");

                } else {
                    minutes = Integer.parseInt(songDuration.substring(0, 2));
                    seconds = Integer.parseInt(songDuration.substring(3, 5));
                    correct = true;
                }
            } while (!correct);
            System.out.print("Enter the album's cover url : ");
            String albumCoverUrl = reader.nextLine();
            System.out.print("Enter the  album's name : ");
            String albumName = reader.nextLine();
            System.out.print("Enter the song's price : ");
            double songPrice = reader.nextDouble();
            reader.nextLine();
            do {
                System.out.println("Select the song's genre:\n1. Rock\n2. Pop\n3. Trap\n4. House : ");
                option = reader.nextInt();
                reader.nextLine();
                if (option < 1 && option > 4) {
                    System.out.println("Invalid option");
                }
            } while (option < 1 && option > 4);
            System.out.println(objectController.addAudio(audioName, minutes, seconds, albumCoverUrl, audioAutor,
                    albumName, songPrice, option));

        } else {

            boolean correct = false;
            int minutes = 0;
            int seconds = 0;
            int hours = 0;
            do {
                System.out.println(
                        "Enter the song's duration in format hh:mm:ss, please enter each number with two digits : ");
                String songDuration = reader.nextLine();
                if (songDuration.length() != 8) {
                    System.out.println("Invalid format");
                } else if (songDuration.charAt(2) != ':' && songDuration.charAt(5) != ':') {
                    System.out.println("Invalid format");
                } else if (Integer.parseInt(songDuration.substring(0, 2)) > 24
                        || Integer.parseInt(songDuration.substring(3, 5)) > 59
                        || Integer.parseInt(songDuration.substring(6, 8)) > 59) {

                    System.out.println("Invalid format");

                } else {
                    hours = Integer.parseInt(songDuration.substring(0, 2));
                    minutes = Integer.parseInt(songDuration.substring(3, 5));
                    seconds = Integer.parseInt(songDuration.substring(6, 8));
                    correct = true;
                }
            } while (!correct);
            System.out.print("Enter the podcast's image url : ");
            String podcastImageUrl = reader.nextLine();
            System.out.print("Enter the podcast's description : ");
            String podcastDescription = reader.nextLine();
            do {
                System.out.println(
                        "Select the podcast's category :\n1. Policy\n2. Entertainment\n3. Videogames\n4.Fashion");
                option = reader.nextInt();
                reader.nextLine();
                if (option < 1 && option > 4) {
                    System.out.println("Invalid option");
                }
            } while (option < 1 && option > 4);

            System.out.println(objectController.addAudio(audioName, hours, minutes, seconds, podcastImageUrl,
                    audioAutor, podcastDescription, option));
        }

    }

    /**
     * <b>createPlaylist</b><br>
     * reads the info and call the controller to add a playlist to the
     * application.<br>
     */
    public void createPlaylist() {
        System.out.println("\n-Playlist creation-");
        System.out.print("Enter the playlist's name : ");
        String playlistName = reader.nextLine();
        System.out.print("Enter the user's nickname : ");
        String userNickname = reader.nextLine();
        System.out.println(objectController.addPlaylistToConsumer(playlistName, userNickname));
    }

    /**
     * <b>editToPlaylist</b><br>
     * reads the info and call the controller to change some data of a playlist.<br>
     */
    public void editPlaylist() {
        System.out.println("\n-Playlist edition-");
        System.out.print("Enter the playlist's name : ");
        String playlistName = reader.nextLine();
        System.out.print("Enter the user's nickname : ");
        String userNickname = reader.nextLine();
        int option;
        do{
            do {
                System.out.println("Select the action to do : \n1. Change playlist's name\n2. Add audio\n3. Remove audio\n 0.back");
                option = reader.nextInt();
                reader.nextLine();
                if (option < 0 && option > 3) {
                    System.out.println("Invalid option");
                }
            } while (option < 0 && option > 3);
            if (option == 1) {
                System.out.print("Enter the new playlist's name : ");
                String newPlaylistName = reader.nextLine();
                System.out.println(objectController.editPlaylist(userNickname, playlistName, newPlaylistName));
            } else if (option == 2) {
                System.out.print("Enter the audio's name : ");
                String audioName = reader.nextLine();
                System.out.println(objectController.addAudioToPlaylist(audioName, playlistName, userNickname));
            } else if (option == 3) {
                System.out.print("Enter the audio's name : ");
                String audioName = reader.nextLine();
                System.out.println(objectController.removeAudioFromPlaylist(playlistName, userNickname, audioName));
            }
        }while(option != 0);
        

    }

    /**
     * <b>sharePlaylist</b><br>
     * reads the info and call the controller to share a playlist with another
     * user.<br>
     */
    public void sharePlaylist() {
        System.out.println("\n-Playlist sharing-");
        System.out.print("Enter the playlist's name : ");
        String playlistName = reader.nextLine();
        System.out.print("Enter the user's nickname : ");
        String userNickname = reader.nextLine();
        System.out.println(objectController.sharePlaylist(userNickname, playlistName));
    }

    /**
     * <b>playAudio</b><br>
     * reads the info and call the controller to simulate the play an audio.<br>
     */
    public void playAudio() {
        System.out.println("\n-Audio playing-");
        System.out.print("Enter the audio's name : ");
        String audioName = reader.nextLine();
        System.out.print("Enter the user's nickname : ");
        String userNickname = reader.nextLine();
        System.out.println(objectController.playAudios(userNickname, audioName));
    }

    /**
     * <b>buyAudio</b><br>
     * reads the info and call the controller to an audio.<br>
     */
    public void buyAudio() {
        System.out.println("\n-Song buying-");
        System.out.print("Enter the song's name : ");
        String audioName = reader.nextLine();
        System.out.print("Enter the user's nickname : ");
        String userNickname = reader.nextLine();
        System.out.println(objectController.buySong(userNickname, audioName));
    }

    /**
     * <b>showTotalPlayback</b><br>
     * reads the info and call the controller to show the total playback of all
     * audios according to it's type.<br>
     */
    public void showTotalPlayback() {
        System.out.println("\n-Total playback-");
        int option;
        do {
            System.out.println("Select the type of audio to show : \n1. Song\n2. Podcast");
            option = reader.nextInt();
            reader.nextLine();
            if (option < 1 && option > 2) {
                System.out.println("Invalid option");
            }
        } while (option < 1 && option > 2);
        if (option == 1) {
            System.out.println(objectController.showTotalPlaybackSongs());
        } else {
            System.out.println(objectController.showTotalPlaybackPodcasts());
        }
    }

    /**
     * <b>showMostHearedGenre</b><br>
     * reads the info and call the controller to show the most heared genre of all
     * the platform and for a single user.<br>
     */
    public void showMostHearedGenre() {
        System.out.println("\n-Most heared genre-");
        int option;
        do{
            do {
                System.out.println("Select the option: \n1. All the platform\n2. A specific user\n 0.back");
                option = reader.nextInt();
                reader.nextLine();
                if (option < 0 && option > 2) {
                    System.out.println("Invalid option");
                }
            } while (option < 0 && option > 2);
            if (option == 1) {
                System.out.println(objectController.mostListenedGenre());
            } else if (option == 2) {
                System.out.print("Enter the user's nickname : ");
                String userNickname = reader.nextLine();
                System.out.println(objectController.mostListenedGenre(userNickname));
            }
        }while (option != 0);
       

    }

    /**
     * <b>showMostHearedCategory</b><br>
     * reads the info and call the controller to show the most heared category of
     * all the platform and for a single user.<br>
     */
    public void showMostHearedCategory() {
        System.out.println("\n-Most heared category-");
        int option;
        do{
            do {
                System.out.println("Select the option: \n1. All the platform\n2. A specific user\n 0.back");
                option = reader.nextInt();
                reader.nextLine();
                if (option < 0 && option > 2) {
                    System.out.println("Invalid option");
                }
            } while (option < 0 && option > 2);
            if (option == 1) {
                System.out.println(objectController.mostListenedCategory());
            } else if (option == 2) {
                System.out.print("Enter the user's nickname : ");
                String userNickname = reader.nextLine();
                System.out.println(objectController.mostListenedCategory(userNickname));
            }
        }while(option != 0);
        
    }

    /**
     * <b>showTop5Producers</b><br>
     * calls the controller to show the top 5 producers of all the platform.<br>
     */
    public void showTop5Producers() {
        System.out.println("\n-Top 5-");
        System.out.println(objectController.top5());
    }

    /**
     * <b>showTop10Audios</b><br>
     * calls the controller to show the top 10 audios of all the platform.<br>
     */
    public void showTop10Audios() {
        System.out.println("\n-Top 10-");
        System.out.println(objectController.top10());
    }

    /**
     * <b>showTotalSales</b><br>
     * Reads the info and calls the controller to show the total sales of all the
     * platform.<br>
     */
    public void showTotalSales() {
        System.out.println("\n-Total sales-");
        int option;
        do {
            do {
                System.out.println(
                        "Select the genre to show : \n1.Rock\n2. Pop\n3. Trap\n4. House\n0.Go back to the main menu");
                option = reader.nextInt();
                reader.nextLine();
                if (option < 0 && option > 4) {
                    System.out.println("Invalid option");
                }
            } while (option < 0 && option > 4);
            String genre="";
            switch (option) {
                
                case 1:
                    genre ="ROCK";
                    break;
                case 2:
                    genre ="POP";
                    break;
                case 3:
                    genre = "TRAP";
                    break;
                case 4:
                    genre ="HOUSE";
                    break;
                default:
                    System.out.println("Returning to the main menu");
                    break;
            }
            if (option != 0) {
                System.out.println(objectController.reportByGenre(genre));
            }
        } while (option != 0);

    }

    /**
     * <b>showMostSaledSong</b><br>
     * calls the controller to show the most saled song of all the platform.<br>
     */
    public void showMostSaledSong() {
        System.out.println("\n-Most saled song-");
        System.out.println(objectController.mostSoldSong());
    }

}
