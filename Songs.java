public class Songs {
    private String title;
    private String duration;
    private Artist artist;
    private String album;

    public Songs(String title, String duration, Artist artist, String album) {
        this.title = title;
        this.duration = duration;
        this.artist = artist;
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album != null ? album : "Single";
    }

    public String toString() {
        return "Song: " + title + " | Duration: " + duration + " | Artist: " + artist.toString() + " | Album: " + getAlbum();
    }
}
