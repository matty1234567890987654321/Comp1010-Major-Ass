
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Songs> allSongs;
    private Scanner scanner;

    // Constructor that accepts the song list from Main
    public Library(ArrayList<Songs> allSongs) {
        this.allSongs = allSongs;
        this.scanner = new Scanner(System.in);
    }

    // Initial prompt to ask if the user wants to search by artist
    public void start() {
        System.out.print("\nWould you like to search by artist? (yes/no): ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            userSearch();
        } 
        else if (choice.equalsIgnoreCase("no")) {
            displayAllSongs();
        } 
        else {
            System.out.println("\nInvalid input. Please answer with 'yes' or 'no'.");
            start(); // Re-prompt the user if the input is invalid
        }
    }

    // Method to display all songs in the library if the user doesn't want to search by artist
    private void displayAllSongs() {
        System.out.println("\nAll Songs in the Library:");
        for (int i = 0; i < allSongs.size(); i++) {
            System.out.println(i + ": " + allSongs.get(i).toString());
        }

        // Prompt user to select a song with validation
        selectSong(allSongs);
    }

    // Method to handle user search and selection
    public void userSearch() {
        System.out.print("\nEnter the name of the artist: ");
        String artistName = scanner.nextLine();

        // Search for the artist
        ArrayList<Songs> artistSongs = searchByArtist(artistName);

        if (artistSongs.isEmpty()) {
            System.out.println("\nArtist not found. Please try again.\n");
            userSearch(); // Recursive call if no artist is found
        } 
        else {
            // Artist found, move to the next step
            handleYesNoPrompt(artistSongs);
        }
    }

    // Handles the yes/no prompt for viewing all songs or selecting an album
    private void handleYesNoPrompt(ArrayList<Songs> artistSongs) {
        System.out.print("\nWould you like to view all songs by the artist? (yes/no): ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            displaySongs(artistSongs);
        } 
        else if (choice.equalsIgnoreCase("no")) {
            displayAlbums(artistSongs);
        } 
        else {
            System.out.println("\nInvalid input. Please answer with 'yes' or 'no'.\n");
            handleYesNoPrompt(artistSongs); // Re-prompt the user with the same question
        }
    }

    // Search method for finding songs by an artist
    private ArrayList<Songs> searchByArtist(String artistName) {
        ArrayList<Songs> artistSongs = new ArrayList<>();
        for (Songs song : allSongs) {
            if (song.getArtist().getName().equalsIgnoreCase(artistName)) {
                artistSongs.add(song);
            }
        }
        return artistSongs;
    }

    // Display all albums by the artist and automatically retry if the album is not found
    private void displayAlbums(ArrayList<Songs> artistSongs) {
        ArrayList<String> albums = new ArrayList<>();

        // Collect unique album names
        for (Songs song : artistSongs) {
            if (!albums.contains(song.getAlbum())) {
                albums.add(song.getAlbum());
            }
        }

        // Display albums
        System.out.println("\nAlbums:");
        for (int i = 0; i < albums.size(); i++) {
            System.out.println(i + ": " + albums.get(i));
        }

        // Prompt user to select an album
        selectAlbum(albums, artistSongs);
    }

    // Album selection method with manual validation for input
    private void selectAlbum(ArrayList<String> albums, ArrayList<Songs> artistSongs) {
        System.out.print("\nEnter the album number to view its songs: ");
        String input = scanner.nextLine();

        // Validate that the input is a valid integer
        if (isInteger(input)) {
            int albumIndex = Integer.parseInt(input);

            if (albumIndex >= 0 && albumIndex < albums.size()) {
                String selectedAlbum = albums.get(albumIndex);
                ArrayList<Songs> albumSongs = new ArrayList<>();
                for (Songs song : artistSongs) {
                    if (song.getAlbum().equals(selectedAlbum)) {
                        albumSongs.add(song);
                    }
                }
                displaySongs(albumSongs);
            } 
            else {
                System.out.println("\nInvalid selection. Please enter a valid album number.\n");
                selectAlbum(albums, artistSongs); // Automatically prompt to reselect an album
            }
        } 
        else {
            System.out.println("\nInvalid input. Please enter a number.\n");
            selectAlbum(albums, artistSongs); // Automatically prompt to reselect an album
        }
    }

    // Helper method to check if a string is a valid integer
    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Display all songs in a list (for either artist or album selection)
    private void displaySongs(ArrayList<Songs> songsList) {
        System.out.println("\nSongs:");
        for (int i = 0; i < songsList.size(); i++) {
            System.out.println(i + ": " + songsList.get(i).toString());
        }

        // Prompt user to select a song with validation
        selectSong(songsList);
    }

    // Song selection method with manual validation for input
    private void selectSong(ArrayList<Songs> songsList) {
        System.out.print("\nEnter the song number to play: ");
        String input = scanner.nextLine();

        // Validate that the input is a valid integer
        if (isInteger(input)) {
            int songIndex = Integer.parseInt(input);

            if (songIndex >= 0 && songIndex < songsList.size()) {
                System.out.println("\nYou selected: " + songsList.get(songIndex).toString());
                playQueue(songIndex, songsList);
            } 
            else {
                System.out.println("\nInvalid selection. Please enter a valid song number.\n");
                selectSong(songsList); // Automatically prompt to reselect a song
            }
        } 
        else {
            System.out.println("\nInvalid input. Please enter a number.\n");
            selectSong(songsList); // Automatically prompt to reselect a song
        }
    }

    // The same playQueue method, adapted to work with any song list
    private void playQueue(int currentIndex, ArrayList<Songs> songList) {
        boolean playing = true;
        while (playing) {
            System.out.println("\nNow playing: " + songList.get(currentIndex).getTitle());
            System.out.println("[Previous <] [Next >] [Shuffle ?] [Quit q]");

            String input = scanner.nextLine();

            switch (input) {
                case "<":
                    currentIndex = (currentIndex - 1 + songList.size()) % songList.size();
                    break;
                case ">":
                    currentIndex = (currentIndex + 1) % songList.size();
                    break;
                case "?":
                    currentIndex = (int) (Math.random() * songList.size());
                    break;
                case "q":
                    playing = false;
                    System.out.println("\nExiting the queue.");
                    break;
                default:
                    System.out.println("\nInvalid input. Please choose one of the following: [Previous <] [Next >] [Shuffle ?] [Quit q]");
            }
        }
    }
}
