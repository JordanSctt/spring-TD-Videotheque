package fr.greta.java.film.facade;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class FilmDTO {

    private Integer id;
    private String title;
    private String author;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateSortie;

    //----------------------------


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(LocalDate dateSortie) {
        this.dateSortie = dateSortie;
    }
}
