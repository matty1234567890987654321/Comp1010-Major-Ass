import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SongsTest {

    @Test
    public void testSongCreation() {
        Artist artist = new Artist("John Lennon", 10);
        Songs song = new Songs("Imagine", "3:04", artist, "Imagine");

        assertEquals("Imagine", song.getTitle());
        assertEquals("3:04", song.getDuration());
        assertEquals(artist, song.getArtist());
        assertEquals("Imagine", song.getAlbum());
    }

    @Test
    public void testGetTitle() {
        Artist artist = new Artist("John Lennon", 10);
        Songs song = new Songs("Imagine", "3:04", artist, "Imagine");

        assertEquals("Imagine", song.getTitle());
    }

    @Test
    public void testGetDuration() {
        Artist artist = new Artist("John Lennon", 10);
        Songs song = new Songs("Imagine", "3:04", artist, "Imagine");

        assertEquals("3:04", song.getDuration());
    }

    @Test
    public void testGetArtist() {
        Artist artist = new Artist("John Lennon", 10);
        Songs song = new Songs("Imagine", "3:04", artist, "Imagine");

        assertEquals(artist, song.getArtist());
    }

    @Test
    public void testGetAlbum() {
        Artist artist = new Artist("John Lennon", 10);
        Songs song = new Songs("Imagine", "3:04", artist, "Imagine");

        assertEquals("Imagine", song.getAlbum());
    }

    @Test
    public void testGetAlbumSingle() {
        Artist artist = new Artist("John Lennon", 10);
        Songs song = new Songs("Imagine", "3:04", artist, null);

        assertEquals("Single", song.getAlbum());
    }

    @Test
    public void testToString() {
        Artist artist = new Artist("John Lennon", 10);
        Songs song = new Songs("Imagine", "3:04", artist, "Imagine");

        String expected = "Song: Imagine | Duration: 3:04 | Artist: John Lennon | Album: Imagine";
        assertEquals(expected, song.toString());
    }

    @Test
    public void testToStringSingle() {
        Artist artist = new Artist("John Lennon", 10);
        Songs song = new Songs("Imagine", "3:04", artist, null);

        String expected = "Song: Imagine | Duration: 3:04 | Artist: John Lennon | Album: Single";
        assertEquals(expected, song.toString());
    }
}
