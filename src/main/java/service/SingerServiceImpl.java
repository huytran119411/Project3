package service;

import DAO.SingerRepository;
import model.Singer;

import java.util.ArrayList;

public class SingerServiceImpl implements IService<Singer> {
    public final SingerRepository singerRepository = new SingerRepository();

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
}
