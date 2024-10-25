import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Library {
    private ArrayList<Songs> allSongs;
    private Scanner scanner;

    // Constructor that accepts the song list from Main
    public Library(ArrayList<Songs> allSongs) {
        this.allSongs = allSongs;
        this.scanner = new Scanner(System.in);
    }

    public void userSongSelection() {
        // Display all songs with an index number
        System.out.println("Please select a song by number:");
        for (int i = 0; i < allSongs.size(); i++) {
            System.out.println(i + ": " + allSongs.get(i).getTitle());
        }

        // Get user input
        System.out.print("Enter the song number: ");
        int songIndex = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (songIndex >= 0 && songIndex < allSongs.size()) {
            // Print the selected song details only once
            System.out.println("You selected: " + allSongs.get(songIndex).toString());
            System.out.println("Song Play/Queue: [Previous <] [Next >] [Shuffle ?]");
            playQueue(songIndex); // Pass the selected song index to playQueue
        } else {
            System.out.println("Invalid selection. Please try again.");
        }
    }

    private void playQueue(int currentIndex) {
        boolean playing = true;
        Random random = new Random();

        while (playing) {
            // Display a simpler message for currently playing songs (no repetition of full details)
            System.out.println("Now playing: " + allSongs.get(currentIndex).getTitle());
            System.out.println("[Previous <] [Next >] [Shuffle ?] [Quit q]");

            // Get user input for queue control
            String input = scanner.nextLine();

            switch (input) {
                case "<": // Previous
                    currentIndex = (currentIndex - 1 + allSongs.size()) % allSongs.size();
                    break;
                case ">": // Next
                    currentIndex = (currentIndex + 1) % allSongs.size();
                    break;
                case "?": // Shuffle
                    int newIndex;
                    do {
                        newIndex = random.nextInt(allSongs.size());
                    } while (newIndex == currentIndex); // Ensure new random song is different
                    currentIndex = newIndex;
                    break;
                case "q": // Quit
                    playing = false;
                    System.out.println("Exiting song queue.");
                    break;
                default:
                    System.out.println("Invalid input, try again.");
                    break;
            }
        }
    }
}
