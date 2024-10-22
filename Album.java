import java.util.ArrayList;

public class Album {
    private String albumTitle;
    private String releaseDate; // Use a String for simplicity, or LocalDate if needed.
    private Artist artist; // The artist who created the album.
    private ArrayList<Songs> songList; // List of songs in the album.

    // Constructor to initialize the album with title, date, and artist.
    public Album(String albumTitle, String releaseDate, Artist artist) {
        this.albumTitle = albumTitle;
        this.releaseDate = releaseDate;
        this.artist = artist;
        this.songList = new ArrayList<>(); // Initialize an empty list of songs.
    }

    // Add a song to the album.
    public void addSong(Songs song) {
        songList.add(song);
    }

    // Get the list of songs in the album.
    public ArrayList<Songs> getSongList() {
        return songList;
    }

    // Get the album title.
    public String getAlbumTitle() {
        return albumTitle;
    }

    // Get the release date.
    public String getReleaseDate() {
        return releaseDate;
    }

    // Get the artist of the album.
    public Artist getArtist() {
        return artist;
    }

    // toString() method to display album details.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Album: ").append(albumTitle)
          .append(" | Release Date: ").append(releaseDate)
          .append(" | Artist: ").append(artist.getName()).append("\n")
          .append("Songs:\n");

        for (Songs song : songList) {
            sb.append(" - ").append(song.getTitle()).append("\n");
        }

        return sb.toString();
    }
}
