package fr.greta.java.film.facade;

import fr.greta.java.film.domain.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/film")
public class FilmDTOController {

    FilmDTOWrapper wrapper = new FilmDTOWrapper();
    FilmService service = new FilmService();


    @GetMapping("/list")
    public ModelAndView list() {
        List<FilmDTO> films = wrapper.toDTOS(service.findAll());
        ModelAndView modelAndView = new ModelAndView("film-list");
        modelAndView.addObject("films", films);
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView displayFormEdit(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("film-edit");
        FilmDTO filmDTO = find(id);
        modelAndView.addObject("film", filmDTO);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute("request") FilmDTO request) {
        FilmDTO filmDTO = find(request.getId());
        filmDTO.setTitle(request.getTitle());
        filmDTO.setAuthor(request.getAuthor());
        filmDTO.setDateSortie(request.getDateSortie());
        service.update(wrapper.fromDTO(filmDTO));
        return list();
    }

    @GetMapping("/create")
    public ModelAndView displayFromCreate() {
        ModelAndView modelAndView = new ModelAndView("film-create");
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("request") FilmDTO request){
        FilmDTO filmDTO = new FilmDTO();
        filmDTO.setTitle(request.getTitle());
        filmDTO.setAuthor(request.getAuthor());
        filmDTO.setDateSortie(request.getDateSortie());
        service.create(wrapper.fromDTO(filmDTO));
        return list();
    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam int id) {
        FilmDTO filmDTO = find(id);
        service.delete(wrapper.fromDTO(filmDTO));
        return list();
    }

    private FilmDTO find(int id) {
        List<FilmDTO> films = wrapper.toDTOS(service.findAll());
        for(FilmDTO filmDTO: films) {
            if(filmDTO.getId() == id) {
                return filmDTO;
            }
        }
        return films.get(0);
    }
}
