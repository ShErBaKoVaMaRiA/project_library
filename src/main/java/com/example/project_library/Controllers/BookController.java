package com.example.project_library.Controllers;

import com.example.project_library.Models.*;
import com.example.project_library.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
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

    @GetMapping("/books/add")
    public String Main(Model model) {
        Iterable<Genres> genres = genresRepository.findAll();
        Iterable<Authors> authors = authorsRepository.findAll();
        model.addAttribute("genres", genres);
        model.addAttribute("authors", authors);
        return "books/books-add";
    }

    @PostMapping("/books/add")
    public String Add(@RequestParam(name="name") String name, @RequestParam(name="year") String year,@RequestParam(name="authors_uid") Long authors, @RequestParam(name="genres_uid") Long genres, Model model) {

        Genres genresfind = genresRepository.findGenresByUID(genres);
        Authors authorsfind = authorsRepository.findAuthorsByUID(authors);
        Books books = new Books(name, year,authorsfind,genresfind);
        booksRepository.save(books);
        return "redirect:/books";
    }
}

