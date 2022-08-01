package model;

public class Playlist {
    private String playlistName;
    private String songId;
    private String customerId;

    public Playlist(String playlistName, String songId, String customerId) {
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

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlistName='" + playlistName + '\'' +
                ", songId='" + songId + '\'' +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
