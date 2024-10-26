public class Album {
    private String albumTitle; // Title of the album
    private Artist artist; // Artist of the album
    private Songs[] songsArray; // Array to store the songs in the album
    private int songCount = 0; // Tracks the current number of songs in the album
    private int currentSongIndex = 0; // Tracks the current song for navigation

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

    // Removes a song by title, if found in the album.
    public void removeSong(String title) {
        for (int i = 0; i < songCount; i++) {
            if (songsArray[i].getTitle().equals(title)) { // Assuming Songs has a getTitle() method
                for (int j = i; j < songCount - 1; j++) {
                    songsArray[j] = songsArray[j + 1]; // Shift songs left
                }
                songsArray[--songCount] = null; // Clear last spot and decrease count
                System.out.println("Song removed: " + title);
                return;
            }
        }
        System.out.println("Song not found: " + title);
    }

    // Navigates to the next song in the album.
    public Songs nextSong() {
        if (songCount == 0) {
            System.out.println("No songs in album!");
            return null;
        }
        currentSongIndex = (currentSongIndex + 1) % songCount;
        return songsArray[currentSongIndex];
    }

    // Navigates to the previous song in the album.
    public Songs previousSong() {
        if (songCount == 0) {
            System.out.println("No songs in album!");
            return null;
        }
        currentSongIndex = (currentSongIndex - 1 + songCount) % songCount;
        return songsArray[currentSongIndex];
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
