package model;

public class Song {
    private int id;
    private String songName;
    private String linkSong;
    private String linkImage;
    private int singerId;

    public Song(int id, String songName, String linkSong, String linkImage, int singerId) {
        this.id = id;
        this.songName = songName;
        this.linkSong = linkSong;
        this.linkImage = linkImage;
        this.singerId = singerId;
    }

    public Song(String songName, String linkSong, String linkImage, int singerId) {
        this.songName = songName;
        this.linkSong = linkSong;
        this.linkImage = linkImage;
        this.singerId = singerId;
    }

    public Song() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getLinkSong() {
        return linkSong;
    }

    public void setLinkSong(String linkSong) {
        this.linkSong = linkSong;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", songName='" + songName + '\'' +
                ", linkSong='" + linkSong + '\'' +
                ", linkImage='" + linkImage + '\'' +
                ", singerId=" + singerId +
                '}';
    }
}
