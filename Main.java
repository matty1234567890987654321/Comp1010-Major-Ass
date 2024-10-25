import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create artist instances
        Artist johnLennon = new Artist("John Lennon");
        Artist queen = new Artist("Queen");
        Artist eagles = new Artist("Eagles");
        Artist ledZeppelin = new Artist("Led Zeppelin");
        Artist bobDylan = new Artist("Bob Dylan");
        Artist michaelJackson = new Artist("Michael Jackson");
        Artist theBeatles = new Artist("The Beatles");
        Artist nirvana = new Artist("Nirvana");
        Artist gunsNRoses = new Artist("Guns N' Roses");
        Artist prince = new Artist("Prince");

        // Create the song list with artist objects
        ArrayList<Songs> songList = new ArrayList<>();
        songList.add(new Songs("Imagine", "3:04", johnLennon, "Imagine"));
        songList.add(new Songs("Bohemian Rhapsody", "5:55", queen, "A Night at the Opera"));
        songList.add(new Songs("Hotel California", "6:30", eagles, "Hotel California"));
        songList.add(new Songs("Stairway to Heaven", "8:02", ledZeppelin, "Led Zeppelin IV"));
        songList.add(new Songs("Like a Rolling Stone", "6:13", bobDylan, "Highway 61 Revisited"));
        songList.add(new Songs("Billie Jean", "4:54", michaelJackson, "Thriller"));
        songList.add(new Songs("Hey Jude", "7:11", theBeatles, null)); // Single with null album
        songList.add(new Songs("Smells Like Teen Spirit", "5:01", nirvana, "Nevermind"));
        songList.add(new Songs("Sweet Child O' Mine", "5:56", gunsNRoses, "Appetite for Destruction"));
        songList.add(new Songs("Purple Rain", "8:41", prince, "Purple Rain"));

        // Pass the song list to the Library
        Library library = new Library(songList);
        library.userSongSelection(); // Start the song selection and queue system
    }
}
