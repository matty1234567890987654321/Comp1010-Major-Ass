public class Songs {
    private String title;
    private String duration;
    private Artist artist;
    private String album;

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
        return album != null ? album : "Single";
    }

    // Overrides toString to return a  description of the song
    public String toString() {
        return "Song: " + title + " | Duration: " + duration + " | Artist: " + artist.toString() + " | Album: " + getAlbum();
    }
}
