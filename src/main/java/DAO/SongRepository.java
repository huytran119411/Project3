package DAO;

import model.Customer;
import model.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SongRepository {
    private MyConnection myConnection = new MyConnection();
    private final String INSERT_SONG = "insert into song (song_name, link_song, link_image, singer_id) value (?,?,?,?);";
    private final String FIND_SONG_BY_NAME = "select * from song where song_name like ?;";
    private final String FIND_SONG_BY_ID = "select * from song where id = ?;";
    private final String FIND_ALL_SONG = "select * from song;";

    public void addSong(Song song) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SONG);
            preparedStatement.setString(1, song.getSongName());
            preparedStatement.setString(2, song.getLinkSong());
            preparedStatement.setString(3, song.getLinkImage());
            preparedStatement.setString(4, String.valueOf(song.getSingerId()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Song> findSongByName(String name) {
        ArrayList<Song> songArrayList = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_SONG_BY_NAME);
            String likeName = "%"+name+"%";
            preparedStatement.setString(1, likeName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String songName = resultSet.getString("song_name");
                String linkSong = resultSet.getString("link_song");
                String linkImage = resultSet.getString("link_image");
                int singerId = resultSet.getInt("singer_id");
                Song song = new Song(id, songName, linkSong, linkImage, singerId);
                songArrayList.add(song);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return songArrayList;
    }

    public ArrayList<Song> findAllSong(){
        ArrayList<Song> songArrayList = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SONG);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String songName = resultSet.getString("song_name");
                String linkSong = resultSet.getString("link_song");
                String linkImage = resultSet.getString("link_image");
                int singerId = resultSet.getInt("singer_id");
                Song song = new Song(id, songName, linkSong, linkImage, singerId);
                songArrayList.add(song);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return songArrayList;
    }

    public Song findSongById(int id) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_SONG_BY_ID);
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idSong = resultSet.getInt("id");
                String songName = resultSet.getString("song_name");
                String linkSong = resultSet.getString("link_song");
                String linkImage = resultSet.getString("link_image");
                int singerId = resultSet.getInt("singer_id");
                return new Song(idSong, songName, linkSong, linkImage, singerId);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
