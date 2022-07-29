package model;

public class Song {
    private int id;
    private String SongName;
    private String songLink;
    private String avatar;
    private String description;
    private double price;
    private int singerId;

    public Song() {
    }

    public Song(String songName, String songLink, String avatar, String description, double price, int singerId) {
        SongName = songName;
        this.songLink = songLink;
        this.avatar = avatar;
        this.description = description;
        this.price = price;
        this.singerId = singerId;
    }

    public Song(int id, String songName, String songLink, String avatar, String description, double price, int singerId) {
        this.id = id;
        SongName = songName;
        this.songLink = songLink;
        this.avatar = avatar;
        this.description = description;
        this.price = price;
        this.singerId = singerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return SongName;
    }

    public void setSongName(String songName) {
        SongName = songName;
    }

    public String getsongLink() {
        return songLink;
    }

    public void setsongLink(String songLink) {
        this.songLink = songLink;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }
}
