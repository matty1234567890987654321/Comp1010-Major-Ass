public class Album {
    private String albumTitle; // Title of the album
    private Artist artist; // Artist of the album
    private Songs[] songsArray;  // Array to store the songs in the album
    private int songCount = 0; // Tracks the current number of songs in the album

    // Constructor to initialize the album with title, artist, and maximum song capacity.
    public Album(String albumTitle, Artist artist, int maxSongs) {
        this.albumTitle = albumTitle;
        this.artist = artist;
        this.songsArray = new Songs[maxSongs]; // Initialize song array with given capacity
    }

    // Adds a song to the album if there is space available.
    public void addSong(Songs song) {
        if (songCount < songsArray.length) {
            songsArray[songCount++] = song; // Add song and increase count
        } else {
            System.out.println("Song array is full!"); // Notify if array is at capacity
        }
    }

    // Retrieves the album title.
    public String getAlbumTitle() {
        return albumTitle;
    }

    // Retrieves the artist of the album.
    public Artist getArtist() {
        return artist;
    }

    // Retrieves the list of songs in the album.
    public Songs[] getSongsArray() {
        return songsArray;
    }
}
