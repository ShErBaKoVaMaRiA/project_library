package com.example.project_library.Controllers;

import com.example.project_library.Models.Genres;
import com.example.project_library.Repository.GenresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/genres")

public class GenreController {
    @Autowired
    GenresRepository classRepository;
    @GetMapping("/")
        public String index(Model model){
            Iterable<Genres> genresIterable = classRepository.findAll();
            model.addAttribute("genres_list", genresIterable);
            return "genres/index";}

    @PostMapping("/add")
    public String Add(@Valid Genres genres, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "genres/add";
        }
        classRepository.save(genres);
        return "redirect:/genres/";
    }
    @GetMapping("/add")
    public String AddView(Genres genres){
        return "genres/add";
    }

    @GetMapping("/detail/{id}")
    public String detail(
            @PathVariable Long id,
            Model model
    ){
        Genres genre_obj = classRepository.findById(id).orElseThrow();
        model.addAttribute("one_genre", genre_obj);
        return "genres/info";
    }

    @PostMapping ("/detail/{id}/del")
    public String  del(@PathVariable Long id)
    {
        Genres genre_obj = classRepository.findById(id).orElseThrow();
        classRepository.delete(genre_obj);
        return "redirect:/genres/";
    }
    @GetMapping ("/detail/{id}/upd")
    public String updateView(@PathVariable Long id,Model model)
    {
        model.addAttribute("one_genre", classRepository.findById(id).orElseThrow());
        return "genres/update";
    }

    @PostMapping ("/detail/{id}/upd")
    public String updateD(@PathVariable Long id, @Valid Genres genres, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "genres/update";
        }
        Genres genre_obj = classRepository.findById(id).orElseThrow();
        classRepository.delete(genre_obj);
        classRepository.save(genres);
        return "redirect:/genres/detail/"+genres.getUID();
    }
}
