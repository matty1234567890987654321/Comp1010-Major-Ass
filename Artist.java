public class Artist {
    private final String name; // Name of the artist
    private final Songs[] songs; // Array to store songs by the artist
    private int songCount; // Tracks the current number of songs

    // Constructor to initialize the artist's name and song capacity
    public Artist(String name, int maxSongs) {
        this.name = name;
        this.songs = new Songs[maxSongs]; // Initialize the song array
        this.songCount = 0; // Start with no songs
    }

    // Retrieves the artist's name
    public String getName() {
        return name;
    }

    // Adds a song to the artist's song list if there's space available
    public boolean addSong(Songs song) {
        if (songCount < songs.length) {
            songs[songCount++] = song; // Add song and increase count
            return true; // Song added successfully
        } else {
            System.out.println("Song array is full for artist: " + name);
            return false; // Indicate failure to add
        }
    }

    // Retrieves the list of songs by the artist
    public Songs[] getSongs() {
        return songs;
    }

    // Retrieves the current count of songs
    public int getSongCount() {
        return songCount;
    }
}
