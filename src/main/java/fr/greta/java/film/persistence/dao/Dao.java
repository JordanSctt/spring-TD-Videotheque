package fr.greta.java.film.persistence.dao;

import java.util.List;

public interface Dao<T> {

    T find(int id);
    List<T> findAll();
    T create(T obj);
    T update(T obj);
    void delete(T obj);

}