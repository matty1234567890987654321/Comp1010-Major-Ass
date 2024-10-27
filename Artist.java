public class Artist {
    private String name; // Name of the artist
    private Songs[] songs; // Array to store songs by the artist
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
    public void addSong(Songs song) {
        if (songCount < songs.length) {
            songs[songCount++] = song; // Add song and increase count
        } else {
            System.out.println("Song array is full for artist: " + name);
        }
    }

    // Retrieves the list of songs by the artist
    public Songs[] getSongs() {
        return songs;
    }

    // Returns the artist's name as a string
    public String toString() {
        return name;
    }
}






