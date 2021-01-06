package fr.greta.java.config;

import fr.greta.java.film.persistence.FilmEntity;
import fr.greta.java.film.persistence.dao.FilmEntityDao;
import fr.greta.java.film.persistence.dao.impl.DaoFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class SpringTdVideothequeApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringTdVideothequeApplication.class, args);

		FilmEntityDao filmEntityDao = DaoFactory.createFilmEntityDao();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		FilmEntity film1 = new FilmEntity();
		film1.setTitle("Interstellar");
		film1.setAuthor("James Camerron");
		film1.setDateSortie(LocalDate.parse("29/03/2016", formatter));
		filmEntityDao.create(film1);

		FilmEntity film2 = new FilmEntity();
		film2.setTitle("Retour vers le futur");
		film2.setAuthor("Benoit Stancks");
		film2.setDateSortie(LocalDate.parse("13/04/2005", formatter));
		filmEntityDao.create(film2);

		FilmEntity film3 = new FilmEntity();
		film3.setTitle("Ligne verte");
		film3.setAuthor("Henry Dellor");
		film3.setDateSortie(LocalDate.parse("03/11/2003", formatter));
		filmEntityDao.create(film3);

		FilmEntity film4 = new FilmEntity();
		film4.setTitle("Tenet");
		film4.setAuthor("James Camerron");
		film4.setDateSortie(LocalDate.parse("21/12/2020", formatter));
		filmEntityDao.create(film4);

		FilmEntity film5 = new FilmEntity();
		film5.setTitle("Les visiteurs");
		film5.setAuthor("Alain Terzian");
		film5.setDateSortie(LocalDate.parse("17/06/2002", formatter));
		filmEntityDao.create(film5);

		FilmEntity film6 = new FilmEntity();
		film6.setTitle("Thor");
		film6.setAuthor("Marvel Studio");
		film6.setDateSortie(LocalDate.parse("13/08/2014", formatter));
		filmEntityDao.create(film6);

		FilmEntity film7 = new FilmEntity();
		film7.setTitle("Captain america");
		film7.setAuthor("Marvel Studio");
		film7.setDateSortie(LocalDate.parse("23/10/2013", formatter));
		filmEntityDao.create(film7);
	}

}
