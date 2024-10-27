import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlbumTest {

    private Album album;
    private Artist artist;
    private Songs song1;
    private Songs song2;
    private Songs song3;

    @BeforeEach
    public void setUp() {
        artist = new Artist("Test Artist", 5);
        album = new Album("Test Album", artist);
        song1 = new Songs("Song 1", "3:30", artist, "Test Album");
        song2 = new Songs("Song 2", "4:15", artist, "Test Album");
        song3 = new Songs("Song 3", "2:50", artist, "Test Album");
    }

    @Test
    public void testAddSong() {
        album.addSong(song1);
        album.addSong(song2);

        assertEquals(2, album.getSongCount());
        assertEquals(song1, album.getSongsArray()[0]);
        assertEquals(song2, album.getSongsArray()[1]);
    }

    @Test
    public void testRemoveSong() {
        album.addSong(song1);
        album.addSong(song2);
        album.addSong(song3);
        
        album.removeSong("Song 2");

        assertEquals(2, album.getSongCount());
        assertEquals(song1, album.getSongsArray()[0]);
        assertEquals(song3, album.getSongsArray()[1]);
        assertNull(album.getSongsArray()[2]);
    }

    @Test
    public void testNextSong() {
        album.addSong(song1);
        album.addSong(song2);
        album.addSong(song3);

        assertEquals(song1, album.nextSong());
        assertEquals(song2, album.nextSong());
        assertEquals(song3, album.nextSong());
        assertEquals(song1, album.nextSong()); // Wraps around to the start
    }

    @Test
    public void testPreviousSong() {
        album.addSong(song1);
        album.addSong(song2);
        album.addSong(song3);

        album.nextSong(); // Go to first song
        album.nextSong(); // Go to second song

        assertEquals(song1, album.previousSong()); // Go back to first song
        assertEquals(song3, album.previousSong()); // Wraps around to the last song
    }

    @Test
    public void testShuffleSongs() {
        album.addSong(song1);
        album.addSong(song2);
        album.addSong(song3);

        Songs[] originalOrder = album.getSongsArray().clone();
        album.shuffleSongs();

        // Shuffle may or may not keep the same order, so we check that at least one song has moved
        boolean isShuffled = false;
        for (int i = 0; i < album.getSongCount(); i++) {
            if (originalOrder[i] != album.getSongsArray()[i]) {
                isShuffled = true;
                break;
            }
        }
        assertTrue(isShuffled, "Songs should be shuffled to a different order");
    }

    @Test
    public void testGetAlbumTitle() {
        assertEquals("Test Album", album.getAlbumTitle());
    }

    @Test
    public void testGetArtist() {
        assertEquals(artist, album.getArtist());
    }

    @Test
    public void testGetCurrentSong() {
        album.addSong(song1);
        album.addSong(song2);

        album.nextSong(); // Set current song to song1
        assertEquals(song1, album.getCurrentSong());

        album.nextSong(); // Set current song to song2
        assertEquals(song2, album.getCurrentSong());
    }
}



