package com.example.project_library.Controllers;

import com.example.project_library.Models.*;
import com.example.project_library.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.sql.Date;

@Controller
@PreAuthorize("hasAnyAuthority('LIBRARIAN')")
public class BookController {
    @Autowired
    public BooksRepository booksRepository;
    @Autowired
    public GenresRepository genresRepository;
    @Autowired
    public AuthorsRepository authorsRepository;

    @GetMapping("/books")
    public String index(Model model) {
        Iterable<Books> books = booksRepository.findAll();
        Iterable<Authors> authors = authorsRepository.findAll();
        Iterable<Genres> genres = genresRepository.findAll();
        model.addAttribute("books", books);
        model.addAttribute("authors", authors);
        model.addAttribute("genres", genres);
        return "books/books-index";
    }

    @PostMapping("/books/add")
    public String AddAuthor(@Valid Books books, BindingResult bindingResult, Long authors, Long genres, Model model) {
        if (bindingResult.hasErrors()) {
            Iterable<Genres> genre = genresRepository.findAll();
            Iterable<Authors> author = authorsRepository.findAll();
            model.addAttribute("genres", genre);
            model.addAttribute("authors", author);
            return "books/books-add";
        }
        Genres genresfind = genresRepository.findGenresByUID(genres);
        Authors authorsfind = authorsRepository.findAuthorsByUID(authors);
        books = new Books(books.getName(), books.getYear(),authorsfind,genresfind);
        booksRepository.save(books);
        return "redirect:/books/";
    }
    @GetMapping("/books/add")
    public String AddView(Books books, Model model){
        Iterable<Genres> genres = genresRepository.findAll();
        Iterable<Authors> authors = authorsRepository.findAll();
        model.addAttribute("genres", genres);
        model.addAttribute("authors", authors);
        return "books/books-add";
    }
}

