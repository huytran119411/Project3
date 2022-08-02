package service;

import java.util.ArrayList;

public interface IService<E> {
        ArrayList<E> findAll();

        E findById(int id);

        void add(E e);

        void update(E e);

        void delete(int id);

        ArrayList<E> findByName(String name);
    }
