package fr.greta.java.film.persistence.dao.impl;

import fr.greta.java.film.persistence.dao.FilmEntityDao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoFactory {

    private static FilmEntityDao filmEntityDao;
    private static String PERSISTENCE = "jpa-unit";
    private static EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory(PERSISTENCE);

    public static FilmEntityDao createFilmEntityDao() {
        if(filmEntityDao == null){
            filmEntityDao = new FilmEntityDaoImpl(entityFactory.createEntityManager());
        }
        return filmEntityDao;
    }

    public static EntityManagerFactory getEntityFactory() {
        return entityFactory;
    }
}
