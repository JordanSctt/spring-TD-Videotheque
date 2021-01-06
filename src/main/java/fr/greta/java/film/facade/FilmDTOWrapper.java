package fr.greta.java.film.facade;

import fr.greta.java.film.domain.Film;

import java.util.ArrayList;
import java.util.List;

public class FilmDTOWrapper {


    public List<FilmDTO> toDTOS(List<Film> models) {
        List<FilmDTO> dtos = new ArrayList<>();
        for(Film model : models) {
            dtos.add(toDTO(model));
        }
        return dtos;
    }

    public Film fromDTO(FilmDTO dto) {

        Film model = new Film();
        model.setId(dto.getId());
        model.setTitle(dto.getTitle());
        model.setAuthor(dto.getAuthor());
        model.setDateSortie(dto.getDateSortie());
        return model;
    }

    public FilmDTO toDTO(Film model) {

        FilmDTO dto = new FilmDTO();
        dto.setId(model.getId());
        dto.setTitle(model.getTitle());
        dto.setAuthor(model.getAuthor());
        dto.setDateSortie(model.getDateSortie());
        return dto;
    }
}
