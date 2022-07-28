package service;

import java.util.ArrayList;

public interface IService<E> {
        ArrayList<E> findAll();

        E findtById(int id);

        void add(E e);

        void update(E e);

        void delete(int id);
    }
