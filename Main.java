import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Artist instances
        Artist johnLennon = new Artist("John Lennon");
        Artist queen = new Artist("Queen");
        Artist eagles = new Artist("Eagles");
        Artist Kanye = new Artist("Kanye");

        //Song list/instances
        ArrayList<Songs> songList = new ArrayList<>();
        songList.add(new Songs("Imagine", "3:04", johnLennon, "Imagine"));
        songList.add(new Songs("Niggas in Parris", "3:04", Kanye, "Fein"));
        songList.add(new Songs("Niggas", "3:04", Kanye, "Feiner"));
        songList.add(new Songs("Bohemian Rhapsody", "5:55", queen, "A Night at the Opera"));
        songList.add(new Songs("Hotel California", "6:30", eagles, "Hotel California"));

        // Initialize the library with the song list
        Library library = new Library(songList);
        
        // Start the initial prompt to ask if the user wants to search by artist
        library.start();
    }
}
