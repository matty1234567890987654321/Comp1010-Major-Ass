import java.util.ArrayList;

public class Artist {
    private String name;
    private String genre;
    private ArrayList<Album> albums;  // An artist may have multiple albums.
    private ArrayList<Songs> singles;  // Store singles released outside of albums.

    // Constructor to initialize the artist object.
    public Artist(String name, String genre) {
        this.name = name;
        this.genre = genre;
        this.albums = new ArrayList<>();
        this.singles = new ArrayList<>();
    }

    // Add a new album to the artist's list of albums.
    public void addAlbum(Album album) {
        albums.add(album);
    }

    // Add a new single to the artist's list of singles.
    public void addSingle(Songs single) {
        singles.add(single);
    }

    // Getters to access private attributes.
    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public ArrayList<Songs> getSingles() {
        return singles;
    }

    // toString() method to display artist information.
    @Override
    public String toString() {
        return "Artist: " + name + " (" + genre + ")";
    }
}