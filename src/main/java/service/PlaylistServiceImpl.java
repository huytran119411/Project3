package service;

import DAO.PlaylistRepository;
import model.Playlist;
import model.Song;

import java.util.ArrayList;

public class PlaylistServiceImpl implements IService<Playlist>{

    public final PlaylistRepository playlistRepository = new PlaylistRepository();

    @Override
    public ArrayList<Playlist> findAll() {
        return null;
    }

    @Override
    public Playlist findById(int id) {
        return null;
    }

    @Override
    public void add(Playlist playlist) {
        playlistRepository.addPlayList(playlist);
    }

    @Override
    public void update(Playlist playlist) {

    }

    @Override
    public void delete(int id) {
        playlistRepository.deleteSongById(id);
    }

    @Override
    public ArrayList<Playlist> findByName(String name) {
        return null;
    }

    @Override
    public ArrayList<Playlist> findAllById(int id) {
        return null;
    }

    @Override
    public ArrayList<Song> findSongById(int id) {
        return playlistRepository.findSongByCustomerId(id);
    }

}
