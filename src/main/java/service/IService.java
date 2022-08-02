package service;

import model.Song;

import java.util.ArrayList;

public interface IService<E> {
        ArrayList<E> findAll();

        E findById(int id);

        void add(E e);

        void update(E e);

        void delete(int id);

        ArrayList<E> findByName(String name);

        ArrayList<E> findAllById(int id);

        ArrayList<Song> findSongById(int id);

    }
