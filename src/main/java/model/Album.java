package model;

public class Album {
    private String albumName;
    private int songId;

    public Album(String albumName, int songId) {
        this.albumName = albumName;
        this.songId = songId;
    }

    public Album() {
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumName='" + albumName + '\'' +
                ", songId=" + songId +
                '}';
    }
}
