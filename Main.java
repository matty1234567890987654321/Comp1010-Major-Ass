import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String FILE_NAME = "songs.txt"; // File to read/write songs data

    public static void main(String[] args) {
        // Create Artist instances with a maximum number of songs for each artist
        Artist johnLennon = new Artist("John Lennon", 10);
        Artist queen = new Artist("Queen", 10);
        Artist eagles = new Artist("Eagles", 10);
        Artist kanye = new Artist("Kanye", 10);

        // Create a list of songs and add Songs instances to the list
        ArrayList<Songs> songList = new ArrayList<>(); // Change from Song to Songs

        // Load songs from file
        loadSongsFromFile(songList, johnLennon, queen, eagles, kanye);

        // Initialize the library with the song list
        Library library = new Library(songList);

        // Start the library prompt for user interaction
        library.start();

        // Save songs back to file (for demonstration purposes)
        saveSongsToFile(songList);
    }

    // Method to load songs from a file
    private static void loadSongsFromFile(List<Songs> songList, Artist... artists) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // Assuming CSV format
                if (parts.length == 4) {
                    String title = parts[0];
                    String duration = parts[1];
                    String artistName = parts[2];
                    String album = parts[3];

                    // Find the artist by name
                    Artist artist = null;
                    for (Artist a : artists) {
                        if (a.getName().equalsIgnoreCase(artistName)) {
                            artist = a;
                            break;
                        }
                    }

                    if (artist != null) {
                        songList.add(new Songs(title, duration, artist, album));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    // Method to save songs to a file
    private static void saveSongsToFile(List<Songs> songList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Songs song : songList) {
                writer.write(song.getTitle() + "," +
                             song.getDuration() + "," +
                             song.getArtist().getName() + "," +
                             song.getAlbum());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
