package com.example.project_library.Controllers;

import com.example.project_library.Models.*;
import com.example.project_library.Repository.*;
import com.sun.jdi.Bootstrap;
import jogamp.common.os.elf.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookLibraryController {
    @Autowired
    public BooksLibraryRepository booksLibraryRepository;
    @Autowired
    public BooksRepository booksRepository;

    @Autowired
    public SectionsRepository sectionsRepository;


    @GetMapping("/books_library")
    public String index(Model model) {
        Iterable<BooksLibrary> bookslibrary = booksLibraryRepository.findAll();
        Iterable<Books> books = booksRepository.findAll();
        Iterable<Sections> sections = sectionsRepository.findAll();
        model.addAttribute("bookslibrary", bookslibrary);
        model.addAttribute("books", books);
        model.addAttribute("sections", sections);
        return "books_library/index";
    }

    @GetMapping("/books_library/add")
    public String Main(Model model) {
        Iterable<Books> books = booksRepository.findAll();
        Iterable<Sections> sections = sectionsRepository.findAll();
        model.addAttribute("books", books);
        model.addAttribute("sections", sections);
        return "books_library/add";
    }

    @PostMapping("/books_library/add")
    public String Add(@RequestParam(name="numberrack") int numberrack, @RequestParam(name="numbershelf") int numbershelf,@RequestParam(name="count") int count, @RequestParam(name="books_uid") Long books, @RequestParam(name="sections_uid") Long sections, Model model) {

        Books booksfind = booksRepository.findBooksByUID(books);
        Sections sectionsfind = sectionsRepository.findSectionsByUID(sections);
        BooksLibrary booksLibrary = new BooksLibrary(numberrack,numberrack,count,booksfind,sectionsfind);
        booksLibraryRepository.save(booksLibrary);
        return "redirect:/books_library";
    }
}

