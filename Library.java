import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

// Class representing the music library
public class Library {
    private final ArrayList<Songs> librarySongs; // List of all songs in the library
    private final Scanner scanner; // Scanner for user input

    // Constructor that initializes the song list and scanner
    public Library(ArrayList<Songs> librarySongs) {
        this.librarySongs = librarySongs;
        this.scanner = new Scanner(System.in);
    }

    // Main method to start the library interaction
    public void start() {
        System.out.print("\nWould you like to search by artist? (yes/no): ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            userSearch();
        } else if (choice.equalsIgnoreCase("no")) {
            displayAllSongs();
        } else {
            System.out.println("\nInvalid input. Please answer with 'yes' or 'no'.");
            start(); // Re-prompt the user if the input is invalid
        }
    }

    // Displays all songs in the library if the user doesn't want to search by artist
    public void displayAllSongs() {
        System.out.println("\nAll Songs in the Library:");
        for (int i = 0; i < librarySongs.size(); i++) {
            System.out.println(i + ": " + librarySongs.get(i).toString());
        }
        selectSong(librarySongs); // Prompt user to select a song
    }

    // Prompts user to enter an artist name and searches for their songs
    public void userSearch() {
        System.out.print("\nEnter the name of the artist: ");
        String artistName = scanner.nextLine();

        // Search for songs by the specified artist
        ArrayList<Songs> filteredSongs = searchByArtist(artistName);

        if (filteredSongs.isEmpty()) {
            System.out.println("\nArtist not found. Please try again.\n");
            userSearch(); // Recursive call if no artist is found
        } else {
            handleYesNoPrompt(filteredSongs); // Prompt user to view songs or albums
        }
    }

    // Prompts user to view all songs or albums by the artist
    private void handleYesNoPrompt(ArrayList<Songs> filteredSongs) {
        System.out.print("\nWould you like to view all songs by the artist? (yes/no): ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            displaySongs(filteredSongs);
        } else if (choice.equalsIgnoreCase("no")) {
            displayAlbums(filteredSongs);
        } else {
            System.out.println("\nInvalid input. Please answer with 'yes' or 'no'.\n");
            handleYesNoPrompt(filteredSongs); // Re-prompt the user
        }
    }

    // Searches for songs by a specific artist
    public ArrayList<Songs> searchByArtist(String artistName) {
        ArrayList<Songs> filteredSongs = new ArrayList<>();
        for (Songs song : librarySongs) {
            if (song.getArtist().getName().equalsIgnoreCase(artistName)) {
                filteredSongs.add(song);
            }
        }
        return filteredSongs;
    }

    // Displays all unique albums by the artist and prompts user to select an album
    private void displayAlbums(ArrayList<Songs> filteredSongs) {
        ArrayList<String> albums = new ArrayList<>();
        for (Songs song : filteredSongs) {
            if (!albums.contains(song.getAlbum())) {
                albums.add(song.getAlbum());
            }
        }

        System.out.println("\nAlbums:");
        for (int i = 0; i < albums.size(); i++) {
            System.out.println(i + ": " + albums.get(i));
        }
        selectAlbum(albums, filteredSongs);
    }

    // Prompts user to select an album and displays its songs
    private void selectAlbum(ArrayList<String> albums, ArrayList<Songs> filteredSongs) {
        System.out.print("\nEnter the album number to view its songs: ");
        String input = scanner.nextLine();

        if (isInteger(input)) {
            int albumIndex = Integer.parseInt(input);

            if (albumIndex >= 0 && albumIndex < albums.size()) {
                String selectedAlbum = albums.get(albumIndex);
                ArrayList<Songs> albumSongs = new ArrayList<>();
                for (Songs song : filteredSongs) {
                    if (song.getAlbum().equals(selectedAlbum)) {
                        albumSongs.add(song);
                    }
                }
                displaySongs(albumSongs);
            } else {
                System.out.println("\nInvalid selection. Please enter a valid album number.\n");
                selectAlbum(albums, filteredSongs);
            }
        } else {
            System.out.println("\nInvalid input. Please enter a number.\n");
            selectAlbum(albums, filteredSongs);
        }
    }

    // Checks if a string is a valid integer
    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Displays a list of songs and prompts the user to select one to play
    private void displaySongs(ArrayList<Songs> songsList) {
        System.out.println("\nSongs:");
        for (int i = 0; i < songsList.size(); i++) {
            System.out.println(i + ": " + songsList.get(i).toString());
        }
        selectSong(songsList);
    }

    // Prompts user to select a song to play
    private void selectSong(ArrayList<Songs> songsList) {
        System.out.print("\nEnter the song number to play: ");
        String input = scanner.nextLine();

        if (isInteger(input)) {
            int songIndex = Integer.parseInt(input);

            if (songIndex >= 0 && songIndex < songsList.size()) {
                System.out.println("\nYou selected: " + songsList.get(songIndex).toString());
                PlayQueue playQueue = new PlayQueue(songsList); // Create PlayQueue instance
                playQueue.startPlaying(songIndex); // Start playing the selected song
            } else {
                System.out.println("\nInvalid selection. Please enter a valid song number.\n");
                selectSong(songsList);
            }
        } else {
            System.out.println("\nInvalid input. Please enter a number.\n");
            selectSong(songsList);
        }
    }

    // Save the library to a file
    public void saveLibrary(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Songs song : librarySongs) {
                writer.write(song.toString()); // Assuming Songs has a suitable toString method
                writer.newLine();
            }
            System.out.println("\nLibrary saved to " + filename);
        } catch (IOException e) {
            System.out.println("\nAn error occurred while saving the library: " + e.getMessage());
        }
    }

    // Load the library from a file
    public void loadLibrary(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            librarySongs.clear(); // Clear the current library before loading
            while ((line = reader.readLine()) != null) {
                // Assuming you have a method to create a Songs object from a string
                librarySongs.add(Songs.fromString(line)); // Call fromString directly
            }
            System.out.println("\nLibrary loaded from " + filename);
        } catch (IOException e) {
            System.out.println("\nAn error occurred while loading the library: " + e.getMessage());
        }
    }
}

// Class to manage song playback
class PlayQueue {
    private final ArrayList<Songs> songList; // List of songs in the queue

    // Constructor that accepts the song list
    public PlayQueue(ArrayList<Songs> songList) {
        this.songList = songList;
    }

    // Starts playing the song at the specified index
    public void startPlaying(int songIndex) {
        Songs songToPlay = songList.get(songIndex);
        System.out.println("\nNow playing: " + songToPlay);
    }
}
