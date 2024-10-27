import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArtistTest {
    private Artist artist;

    @BeforeEach
    public void setUp() {
        // Initialize an Artist instance with a capacity of 3 songs for testing
        artist = new Artist("Test Artist", 3);
    }

    @Test
    public void testArtistName() {
        // Check if the artist's name is correctly set
        assertEquals("Test Artist", artist.getName(), "Artist name should match");
    }

    @Test
    public void testAddSongWithinCapacity() {
        // Add a song within the capacity and verify it is added
        Songs song1 = new Songs("Song 1", "3:00", artist, "Album 1");
        artist.addSong(song1);

        assertEquals(song1, artist.getSongs()[0], "The first song should be 'Song 1'");
        assertEquals(3, artist.getSongs().length, "Song count should be 1 after adding a song");
    }

    @Test
    public void testAddSongExceedingCapacity(){
    // Add songs up to the capacity
    Songs song1 = new Songs("Song 1", "3:00", artist, "Album 1");
    Songs song2 = new Songs("Song 2", "4:00", artist, "Album 2");
    Songs song3 = new Songs("Song 3", "5:00", artist, "Album 3");
    
    artist.addSong(song1);
    artist.addSong(song2);
    artist.addSong(song3);

    // Attempt to add a fourth song, which should exceed the capacity
    Songs song4 = new Songs("Song 4", "4:30", artist, "Album 4");
    artist.addSong(song4); // This should not be added

    // Check that only the first 3 songs were added
    assertEquals(song1, artist.getSongs()[0], "First song should be 'Song 1'");
    assertEquals(song2, artist.getSongs()[1], "Second song should be 'Song 2'");
    assertEquals(song3, artist.getSongs()[2], "Third song should be 'Song 3'");

    // Instead of accessing index 3, verify that `song4` was not added by checking `songCount`
    assertEquals(3, artist.getSongs().length, "No more songs should be added beyond capacity");
}

}
