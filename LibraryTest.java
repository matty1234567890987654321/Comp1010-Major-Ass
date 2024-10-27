import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class LibraryTest {

    private Library library;
    private ArrayList<Songs> songList;
    private Artist johnLennon;
    private Artist kanye;
    private Songs song1;
    private Songs song2;
    private Songs song3;

    @BeforeEach
    public void setUp() {
        johnLennon = new Artist("John Lennon", 10);
        kanye = new Artist("Kanye", 10);

        song1 = new Songs("Imagine", "3:04", johnLennon, "Imagine");
        song2 = new Songs("Niggas in Paris", "3:04", kanye, "Fein");
        song3 = new Songs("Niggas", "3:04", kanye, "Feiner");

        songList = new ArrayList<>();
        songList.add(song1);
        songList.add(song2);
        songList.add(song3);

        library = new Library(songList);
    }

    @Test
    public void testSearchByArtist_Found() {
        ArrayList<Songs> results = library.searchByArtist("Kanye");
        assertEquals(2, results.size(), "Should find 2 songs by Kanye");
        assertTrue(results.contains(song2), "Result should contain 'Niggas in Paris'");
        assertTrue(results.contains(song3), "Result should contain 'Niggas'");
    }

    @Test
    public void testSearchByArtist_NotFound() {
        ArrayList<Songs> results = library.searchByArtist("Unknown Artist");
        assertTrue(results.isEmpty(), "Should not find any songs by an unknown artist");
    }

    @Test
    public void testDisplayAllSongs() {
        assertEquals(3, songList.size(), "Library should contain 3 songs in total");
        assertTrue(songList.contains(song1), "Library should contain 'Imagine'");
        assertTrue(songList.contains(song2), "Library should contain 'Niggas in Paris'");
        assertTrue(songList.contains(song3), "Library should contain 'Niggas'");
    }

    @Test
    public void testDisplayAlbums() {
        ArrayList<Songs> kanyeSongs = library.searchByArtist("Kanye");
        ArrayList<String> albums = new ArrayList<>();
        for (Songs song : kanyeSongs) {
            if (!albums.contains(song.getAlbum())) {
                albums.add(song.getAlbum());
            }
        }
        assertEquals(2, albums.size(), "Kanye should have 2 unique albums");
        assertTrue(albums.contains("Fein"), "Albums should contain 'Fein'");
        assertTrue(albums.contains("Feiner"), "Albums should contain 'Feiner'");
    }

    @Test
    public void testSelectSongAndPlayQueue() {
        int currentIndex = 0;
        boolean playing = true;
        while (playing) {
            Songs currentSong = songList.get(currentIndex);
            System.out.println("Now playing: " + currentSong.getTitle());
            currentIndex = (currentIndex + 1) % songList.size();
            if (currentIndex == 0) {
                playing = false;
            }
        }
    }
}
