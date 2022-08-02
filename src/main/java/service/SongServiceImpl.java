package service;

import DAO.SongRepository;
import model.Song;

import java.util.ArrayList;

public class SongServiceImpl implements IService<Song> {
    public final SongRepository songRepository = new SongRepository();
    @Override
    public ArrayList<Song> findAll() {
        return songRepository.findAllSong();
    }

    @Override
    public Song findById(int id) {
        return songRepository.findSongById(id);
    }

    @Override
    public void add(Song song) {
        songRepository.addSong(song);
    }

    @Override
    public void update(Song song) {

    }

    @Override
    public void delete(int id) {

    }


    @Override
    public ArrayList<Song> findByName(String name) {
        return songRepository.findSongByName(name);
    }
}
