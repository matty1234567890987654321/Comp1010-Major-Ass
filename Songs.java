public class Songs {
    private String title;       // Title of the song
    private String duration;    // Duration of the song (e.g., "3:45")
    private Artist artist;      // Artist who performed the song
    private String album;       // Album the song belongs to (or null if it's a single)

    // Constructor to initialize a song with title, duration, artist, and album
    public Songs(String title, String duration, Artist artist, String album) {
        this.title = title;
        this.duration = duration;
        this.artist = artist;
        this.album = album;
    }

    // Getter for song title
    public String getTitle() {
        return title;
    }

    // Getter for song duration
    public String getDuration() {
        return duration;
    }

    // Getter for the artist who performed the song
    public Artist getArtist() {
        return artist;
    }

    // Getter for album, returns "Single" if no album name is provided
    public String getAlbum() {
        return album != null && !album.isEmpty() ? album : "Single";
    }

    // Overrides toString to return a description of the song
    @Override
    public String toString() {
        return "Song: " + title + " | Duration: " + duration + " | Artist: " + artist.toString() + " | Album: " + getAlbum();
    }
}