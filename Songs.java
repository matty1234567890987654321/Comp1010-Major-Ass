public class Songs {
    private String title;
    private double duration;
    private boolean isSingle;
    private String album;  // Optional, if it belongs to an album.

    // Constructor to initialize a song object.
    public Songs(String title, double duration, boolean isSingle, String album) {
        this.title = title;
        this.duration = duration;
        this.isSingle = isSingle;
        this.album = album;
    }

    // Getters to access private attributes.
    public String getTitle() {
        return title;
    }

    public double getDuration() {
        return duration;
    }

    public boolean isSingle() {
        return isSingle;
    }

    public String getAlbum() {
        return album;
    }

    // toString() method to display the song information.
    @Override
    public String toString() {
        return "Song: " + title + " (" + duration + " mins) " +
               (isSingle ? "[Single]" : "[Album: " + album + "]");
    }
}