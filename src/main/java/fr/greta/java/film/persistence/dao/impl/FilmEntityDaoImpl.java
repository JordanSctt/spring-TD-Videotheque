package fr.greta.java.film.persistence.dao.impl;

import fr.greta.java.film.persistence.FilmEntity;
import fr.greta.java.film.persistence.dao.FilmEntityDao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class FilmEntityDaoImpl implements FilmEntityDao {

    private EntityManager entityManager;

    public FilmEntityDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //-------------------------------------------------
    @Override
    public FilmEntity find(int id) {
        return entityManager.find(FilmEntity.class, id);
    }

    @Override
    public List<FilmEntity> findAll() {
        TypedQuery<FilmEntity> query = entityManager.createQuery(
                "select f from FilmEntity f", FilmEntity.class);
        return query.getResultList();
    }

    @Override
    public FilmEntity create(FilmEntity obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
        return obj;
    }

    @Override
    public FilmEntity update(FilmEntity obj) {
        entityManager.getTransaction().begin();
        entityManager.merge(obj);
        entityManager.getTransaction().commit();
        return obj;
    }

    @Override
    public void delete(FilmEntity obj) {
        entityManager.getTransaction().begin();
        entityManager.remove(obj);
        entityManager.getTransaction().commit();
    }

}
