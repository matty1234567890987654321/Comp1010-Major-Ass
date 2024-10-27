import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private Artist johnLennon;
    private Artist queen;
    private Artist eagles;
    private Artist kanye;
    private Songs imagine;
    private Songs bohemianRhapsody;
    private Songs hotelCalifornia;
    private Songs niggasInParis;
    private Album imagineAlbum;
    private Album nightAtTheOpera;
    private Album hotelCaliforniaAlbum;
    private Library library;

    @BeforeEach
    public void setUp() {
        johnLennon = new Artist("John Lennon", 10);
        queen = new Artist("Queen", 10);
        eagles = new Artist("Eagles", 10);
        kanye = new Artist("Kanye", 10);

        imagine = new Songs("Imagine", "3:04", johnLennon, "Imagine");
        bohemianRhapsody = new Songs("Bohemian Rhapsody", "5:55", queen, "A Night at the Opera");
        hotelCalifornia = new Songs("Hotel California", "6:30", eagles, "Hotel California");
        niggasInParis = new Songs("Niggas in Paris", "3:04", kanye, "Fein");

        imagineAlbum = new Album("Imagine", johnLennon);
        nightAtTheOpera = new Album("A Night at the Opera", queen);
        hotelCaliforniaAlbum = new Album("Hotel California", eagles);

        imagineAlbum.addSong(imagine);
        nightAtTheOpera.addSong(bohemianRhapsody);
        hotelCaliforniaAlbum.addSong(hotelCalifornia);

        ArrayList<Songs> songList = new ArrayList<>(Arrays.asList(imagine, bohemianRhapsody, hotelCalifornia, niggasInParis));
        library = new Library(songList);
    }

    @Test
    public void testAddSongToAlbum() {
        assertEquals(1, imagineAlbum.getSongCount());
        imagineAlbum.addSong(new Songs("Jealous Guy", "4:14", johnLennon, "Imagine"));
        assertEquals(2, imagineAlbum.getSongCount());
    }

    @Test
    public void testRemoveSongFromAlbum() {
        assertEquals(1, imagineAlbum.getSongCount());
        imagineAlbum.removeSong("Imagine");
        assertEquals(0, imagineAlbum.getSongCount());
    }

    @Test
    public void testNextSongInAlbum() {
        imagineAlbum.addSong(new Songs("Jealous Guy", "4:14", johnLennon, "Imagine"));
        assertEquals("Imagine", imagineAlbum.nextSong().getTitle());
        assertEquals("Jealous Guy", imagineAlbum.nextSong().getTitle());
    }

    @Test
    public void testPreviousSongInAlbum() {
        imagineAlbum.addSong(new Songs("Jealous Guy", "4:14", johnLennon, "Imagine"));
        imagineAlbum.nextSong(); // Move to the first song
        imagineAlbum.nextSong(); // Move to the second song
        assertEquals("Imagine", imagineAlbum.previousSong().getTitle());
    }

    @Test
    public void testShuffleSongsInAlbum() {
        imagineAlbum.addSong(new Songs("Jealous Guy", "4:14", johnLennon, "Imagine"));
        imagineAlbum.shuffleSongs();
        assertNotNull(imagineAlbum.nextSong());
    }

    @Test
    public void testLibrarySearchByArtist() {
        ArrayList<Songs> result = library.searchByArtist("John Lennon");
        assertEquals(1, result.size());
        assertEquals("Imagine", result.get(0).getTitle());
    }

    @Test
    public void testLibraryDisplayAllSongs() {
        assertDoesNotThrow(() -> library.displayAllSongs());
    }

    @Test
    public void testLibraryUserSearch() {
        assertDoesNotThrow(() -> library.userSearch());
    }

    @Test
    public void testArtistAddSong() {
        // Verify the initial state of johnLennon's songs
        Songs[] johnLennonSongs = johnLennon.getSongs();
        int initialSongCount = 0;
        for (Songs song : johnLennonSongs) {
            if (song != null) {
                initialSongCount++;
            }
        }
        assertEquals(0, initialSongCount);

        // Add a song to johnLennon's songs and verify
        johnLennon.addSong(imagine);
        johnLennonSongs = johnLennon.getSongs();
        int updatedSongCount = 0;
        for (Songs song : johnLennonSongs) {
            if (song != null) {
                updatedSongCount++;
            }
        }
        assertEquals(1, updatedSongCount);
    }

    @Test
    public void testGetCurrentSong() {
        assertNull(imagineAlbum.getCurrentSong());
        imagineAlbum.addSong(imagine);
        imagineAlbum.nextSong(); // Move to the first song to set the current song
        assertEquals(imagine, imagineAlbum.getCurrentSong());
    }
}
