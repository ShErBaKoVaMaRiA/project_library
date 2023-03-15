package com.example.project_library.Controllers;

import com.example.project_library.Models.Authors;
import com.example.project_library.Repository.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/authors")
@PreAuthorize("hasAnyAuthority('LIBRARIAN')")
public class AuthorController {
    @Autowired
    AuthorsRepository authorsRepository;
    @GetMapping("/")
        public String index(Model model){
            Iterable<Authors> authorsIterable = authorsRepository.findAll();
            model.addAttribute("authors_list", authorsIterable);
            return "authors/index";}

    @PostMapping("/add")
    public String AddAuthor(@Valid Authors authors, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "authors/add";
        }
        authorsRepository.save(authors);
        return "redirect:/authors/";
    }
    @GetMapping("/add")
    public String AddView(Authors authors){
        return "authors/add";
    }

    @GetMapping("/detail/{id}")
    public String detailAuthor(
            @PathVariable Long id,
            Model model
    ){
        Authors author_obj = authorsRepository.findById(id).orElseThrow();
        model.addAttribute("one_author", author_obj);
        return "authors/info";
    }

    @PostMapping ("/detail/{id}/del")
    public String  delAuthor(@PathVariable Long id)
    {
        Authors author_obj = authorsRepository.findById(id).orElseThrow();
        authorsRepository.delete(author_obj);
        return "redirect:/authors/";
    }
    @GetMapping ("/detail/{id}/upd")
    public String  updateView(@PathVariable Long id,Model model)
    {
        model.addAttribute("authors",authorsRepository.findById(id).orElseThrow());
        return "authors/update";
    }

    @PostMapping ("/detail/{id}/upd")
    public String updateD(@PathVariable Long id, @Valid Authors authors, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "authors/update";
        }
        Authors author_obj = authorsRepository.findById(id).orElseThrow();
        authorsRepository.delete(author_obj);
        authorsRepository.save(authors);
        return "redirect:/authors/detail/"+authors.getUID();
    }
}
