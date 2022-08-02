package service;

import DAO.SingerRepository;
import model.Singer;
import model.Song;

import java.util.ArrayList;

public class SingerServiceImpl implements IService<Singer>{

    SingerRepository singerRepository = new SingerRepository();
    @Override
    public ArrayList<Singer> findAll() {
        return singerRepository.findAll();
    }

    @Override
    public Singer findById(int id) {
        return singerRepository.findSingerById(id);
    }

    @Override
    public void add(Singer singer) {
    singerRepository.addSinger(singer);
    }

    @Override
    public void update(Singer singer) {
    singerRepository.updateSingerById(singer);
    }

    @Override
    public void delete(int id) {
    singerRepository.deleteSingerById(id);
    }

    @Override
    public ArrayList findByName(String name) {
        return null;
    }

    @Override
    public ArrayList<Singer> findAllById(int id) {
        return null;
    }

    @Override
    public ArrayList<Song> findSongById(int id) {
        return null;
    }
}
