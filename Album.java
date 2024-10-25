public class Album {
    private String albumTitle;
    private Artist artist;
    private Songs[] songList;  // Array to store the songs in the album
    private int songCount = 0;

    // Constructor to initialize the album with title and artist
    public Album(String albumTitle, Artist artist, int maxSongs) {
        this.albumTitle = albumTitle;
        this.artist = artist;
        this.songList = new Songs[maxSongs];  // Initialize song array
    }

    // Method to add a song to the album's song array
    public void addSong(Songs song) {
        if (songCount < songList.length) {
            songList[songCount++] = song;
        } else {
            System.out.println("Song array is full!");
        }
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public Artist getArtist() {
        return artist;
    }

    public Songs[] getSongList() {
        return songList;
    }
}
