package DAO;

import model.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SongRepository {
    private MyConnection myConnection = new MyConnection();
    private final String INSERT_SONG = "insert into song(SongName,songLink,avatar,description,price,singerId) values(?,?,?,?,?,?)";
    private final String SELECT_ALL_SONG = "select * from song";
    private final String DELETE_SONG_BY_ID = "delete from song where id = ?";
    private final String SELECT_SONG_BY_ID = "select * from song where id = ?";
    private final String UPDATE_SONG_BY_ID = "update song set songName = ?, songLink = ?, avatar = ? , description = ? , price = ? , singerId = ?";

    public void addSong(Song song) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_SONG);
            statement.setString(1, song.getSongName());
            statement.setString(2, song.getsongLink());
            statement.setString(3, song.getAvatar());
            statement.setString(4, song.getDescription());
            statement.setDouble(5, song.getPrice());
            statement.setInt(6, song.getSingerId());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Song> findAll() {
        ArrayList<Song> songs = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SONG);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String songName = resultSet.getString("name");
                String songLink = resultSet.getString("songLink");
                String avatar = resultSet.getString("avatar");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                int singleId = resultSet.getInt("singleId");
                Song song = new Song(id, songName, songLink, avatar, description, price, singleId);
                songs.add(song);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return songs;
    }

    public Song findSongById(int id) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_SONG_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String songName = resultSet.getString("name");
                String songLink = resultSet.getString("songLink");
                String avatar = resultSet.getString("avatar");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                int singleId = resultSet.getInt("singleId");
                return new Song(id, songName, songLink, avatar, description, price, singleId);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void deleteById(int id) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_SONG_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateById(Song song) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_SONG_BY_ID);
            statement.setString(1, song.getSongName());
            statement.setString(2, song.getsongLink());
            statement.setString(3, song.getAvatar());
            statement.setString(4, song.getDescription());
            statement.setDouble(5, song.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

