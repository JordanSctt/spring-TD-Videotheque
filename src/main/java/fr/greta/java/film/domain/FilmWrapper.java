package fr.greta.java.film.domain;


import fr.greta.java.film.persistence.FilmEntity;

import java.util.ArrayList;
import java.util.List;

public class FilmWrapper {


    public List<Film> fromEntities(List<FilmEntity> entities) {
        List<Film> models = new ArrayList<>();
        for (FilmEntity entity : entities) {
            models.add(fromEntity(entity));
        }
        return models;
    }

    public Film fromEntity(FilmEntity entity) {
        Film model = new Film();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setAuthor(entity.getAuthor());
        model.setDateSortie(entity.getDateSortie());
        return model;
    }

    public FilmEntity toEntity(Film model) {
        FilmEntity entity = new FilmEntity();
        entity.setId(model.getId());
        entity.setTitle(model.getTitle());
        entity.setAuthor(model.getAuthor());
        entity.setDateSortie(model.getDateSortie());
        return entity;
    }
}
