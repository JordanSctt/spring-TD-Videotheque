package fr.greta.java.film.domain;

import fr.greta.java.film.persistence.dao.impl.DaoFactory;
import fr.greta.java.film.persistence.dao.impl.FilmEntityDaoImpl;


import java.util.List;

public class FilmService {

    FilmWrapper filmWrapper = new FilmWrapper();
    FilmEntityDaoImpl daoImplRepository = new FilmEntityDaoImpl(DaoFactory.getEntityFactory().createEntityManager());

    public List<Film> findAll() {
        List<Film> filmsList = filmWrapper.fromEntities(daoImplRepository.findAll());
        return filmsList;
    }

    public Film update(Film film) {
        return filmWrapper.fromEntity(daoImplRepository.update(filmWrapper.toEntity(film)));
    }

    public Film create(Film film) {
        return filmWrapper.fromEntity(daoImplRepository.create(filmWrapper.toEntity(film)));
    }

    public void delete(Film film) {
        daoImplRepository.delete(filmWrapper.toEntity(film));
    }

}
