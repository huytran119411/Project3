package model;

public class Playlist {
    private String playlistName;
    private int songId;
    private int customerId;

    public Playlist(String playlistName, int songId, int customerId) {
        this.playlistName = playlistName;
        this.songId = songId;
        this.customerId = customerId;
    }

    public Playlist() {
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
