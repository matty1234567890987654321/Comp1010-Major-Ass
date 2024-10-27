import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create Artist instances with a maximum number of songs for each artist
        Artist johnLennon = new Artist("John Lennon", 10);
        Artist queen = new Artist("Queen", 10);
        Artist eagles = new Artist("Eagles", 10);
        Artist kanye = new Artist("Kanye", 10);

        // Create a list of songs and add Songs instances to the list
        ArrayList<Songs> songList = new ArrayList<>();
        songList.add(new Songs("Imagine", "3:04", johnLennon, "Imagine"));
        songList.add(new Songs("Niggas in Paris", "3:04", kanye, "Fein"));
        songList.add(new Songs("Niggas", "3:04", kanye, "Feiner"));
        songList.add(new Songs("Bohemian Rhapsody", "5:55", queen, "A Night at the Opera"));
        songList.add(new Songs("Hotel California", "6:30", eagles, "Hotel California"));

        // Initialize the library with the song list
        Library library = new Library(songList);
        
        // Start the library prompt for user interaction
        library.start();
    }
}
