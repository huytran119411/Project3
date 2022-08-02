package DAO;

import model.Playlist;
import model.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaylistRepository {

    private MyConnection myConnection = new MyConnection();
    private final String INSERT_PLAYLIST = "insert into playlist (playlist_name,song_id,customer_id) values (?,?,?);";
    private final String FIND_SONG_BY_CUSTOMER_ID = "select id,song_name,link_song,link_image,singer_id from song join playlist on playlist.song_id = song.id where customer_id = ?;";
    private final String DELETE_SONG_FROM_PLAYLIST = "delete from playlist where song_id =?;";

    public void addPlayList(Playlist playlist) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PLAYLIST);
            preparedStatement.setString(1, playlist.getPlaylistName());
            preparedStatement.setString(2, String.valueOf(playlist.getSongId()));
            preparedStatement.setString(3, String.valueOf(playlist.getCustomerId()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Song> findSongByCustomerId(int id) {
        ArrayList<Song> songArrayList = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_SONG_BY_CUSTOMER_ID);
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idSong = resultSet.getInt("id");
                String songName = resultSet.getString("song_name");
                String linkSong = resultSet.getString("link_song");
                String linkImage = resultSet.getString("link_image");
                int singerId = resultSet.getInt("singer_id");
                Song song =  new Song(idSong, songName, linkSong, linkImage, singerId);
                songArrayList.add(song);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return songArrayList;
    }
    public void deleteSongById(int id) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SONG_FROM_PLAYLIST);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
