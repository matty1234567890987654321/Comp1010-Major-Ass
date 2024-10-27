import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final String FILENAME = "musicLibrary.txt"; // File to save and load songs

    public static void main(String[] args) {
        // Create Artist instances with a maximum number of songs for each artist
        Artist johnLennon = new Artist("John Lennon", 10);
        Artist queen = new Artist("Queen", 10);
        Artist eagles = new Artist("Eagles", 10);
        Artist kanye = new Artist("Kanye", 10);

        // Create a list of songs and add Songs instances to the list
        ArrayList<Song> songList = new ArrayList<>();
        songList.add(new Song("Imagine", "3:04", johnLennon, "Imagine"));
        songList.add(new Song("Niggas in Paris", "3:04", kanye, "Fein"));
        songList.add(new Song("Niggas", "3:04", kanye, "Feiner"));
        songList.add(new Song("Bohemian Rhapsody", "5:55", queen, "A Night at the Opera"));
        songList.add(new Song("Hotel California", "6:30", eagles, "Hotel California"));

        // Initialize the library with the song list
        Library library = new Library(songList);
        
        // Load songs from file if it exists
        library.loadLibrary(FILENAME);
        
        // Start the library prompt for user interaction
        library.start();
        
        // Save songs to file before exiting
        library.saveLibrary(FILENAME);
    }
}
