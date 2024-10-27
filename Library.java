import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private final ArrayList<Songs> librarySongs; // List of all songs in the library
    private final Scanner scanner; // Scanner for user input
    private static final String FILE_NAME = "songs.txt"; // File to read/write songs data

    public Library(ArrayList<Songs> librarySongs) {
        this.librarySongs = librarySongs;
        this.scanner = new Scanner(System.in);
        loadSongsFromFile(); // Load songs from file when the library is initialized
    }

    public void start() {
        System.out.print("\nWould you like to search by artist? (yes/no): ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            userSearch();
        } else if (choice.equalsIgnoreCase("no")) {
            displayAllSongs();
        } else {
            System.out.println("\nInvalid input. Please answer with 'yes' or 'no'.");
            start();
        }
    }

    public void displayAllSongs() {
        System.out.println("\nAll Songs in the Library:");
        for (int i = 0; i < librarySongs.size(); i++) {
            System.out.println(i + ": " + librarySongs.get(i).toString());
        }
        selectSong(librarySongs);
    }

    public void userSearch() {
        System.out.print("\nEnter the name of the artist: ");
        String artistName = scanner.nextLine();

        ArrayList<Songs> filteredSongs = searchByArtist(artistName);

        if (filteredSongs.isEmpty()) {
            System.out.println("\nArtist not found. Please try again.\n");
            userSearch();
        } else {
            handleYesNoPrompt(filteredSongs);
        }
    }

    private void handleYesNoPrompt(ArrayList<Songs> filteredSongs) {
        System.out.print("\nWould you like to view all songs by the artist? (yes/no): ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            displaySongs(filteredSongs);
        } else if (choice.equalsIgnoreCase("no")) {
            displayAlbums(filteredSongs);
        } else {
            System.out.println("\nInvalid input. Please answer with 'yes' or 'no'.\n");
            handleYesNoPrompt(filteredSongs);
        }
    }

    public ArrayList<Songs> searchByArtist(String artistName) {
        ArrayList<Songs> filteredSongs = new ArrayList<>();
        for (Songs song : librarySongs) {
            if (song.getArtist().getName().equalsIgnoreCase(artistName)) {
                filteredSongs.add(song);
            }
        }
        return filteredSongs;
    }

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

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void displaySongs(ArrayList<Songs> songsList) {
        System.out.println("\nSongs:");
        for (int i = 0; i < songsList.size(); i++) {
            System.out.println(i + ": " + songsList.get(i).toString());
        }
        selectSong(songsList);
    }

    private void selectSong(ArrayList<Songs> songsList) {
        System.out.print("\nEnter the song number to play: ");
        String input = scanner.nextLine();

        if (isInteger(input)) {
            int songIndex = Integer.parseInt(input);

            if (songIndex >= 0 && songIndex < songsList.size()) {
                System.out.println("\nYou selected: " + songsList.get(songIndex).toString());
                playQueue(songIndex, songsList);
            } else {
                System.out.println("\nInvalid selection. Please enter a valid song number.\n");
                selectSong(songsList);
            }
        } else {
            System.out.println("\nInvalid input. Please enter a number.\n");
            selectSong(songsList);
        }
    }

    private void playQueue(int currentIndex, ArrayList<Songs> songList) {
        boolean playing = true;
        while (playing) {
            System.out.println("\nNow playing: " + songList.get(currentIndex).getTitle());
            System.out.println("[Previous <] [Next >] [Shuffle ?] [Quit q]");

            String input = scanner.nextLine();

            switch (input) {
                case "<" -> currentIndex = (currentIndex - 1 + songList.size()) % songList.size();
                case ">" -> currentIndex = (currentIndex + 1) % songList.size();
                case "?" -> currentIndex = (int) (Math.random() * songList.size());
                case "q" -> {
                    playing = false;
                    System.out.println("\nExiting the queue.");
                }
                default -> System.out.println("\nInvalid input. Please choose one of the following: [Previous <] [Next >] [Shuffle ?] [Quit q]");
            }
        }
    }

    // Method to load songs from a file
    private void loadSongsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // Assuming CSV format
                if (parts.length == 4) {
                    String title = parts[0];
                    String duration = parts[1];
                    String artistName = parts[2];
                    String album = parts[3];

                    // Create a new song and add it to the library
                    librarySongs.add(new Songs(title, duration, new Artist(artistName, 10), album));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    // Method to save songs to a file
    public void saveSongsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Songs song : librarySongs) {
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
