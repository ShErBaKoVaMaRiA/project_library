package com.example.project_library.Controllers;

import com.example.project_library.Models.*;
import com.example.project_library.Repository.*;
import com.sun.jdi.Bootstrap;
import jogamp.common.os.elf.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@PreAuthorize("hasAnyAuthority('LIBRARIAN')")
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
    public String Main(Model model, BooksLibrary booksLibrary) {
        Iterable<Books> books = booksRepository.findAll();
        Iterable<Sections> sections = sectionsRepository.findAll();
        model.addAttribute("books", books);
        model.addAttribute("sections", sections);
        return "books_library/add";
    }

    @PostMapping("/books_library/add")
    public String Add(@Valid BooksLibrary bookslibrary,BindingResult bindingResult, Long books_uid, Long sections_uid, Model model) {
        if (bindingResult.hasErrors()) {
            Iterable<Books> books = booksRepository.findAll();
            Iterable<Sections> sections = sectionsRepository.findAll();
            model.addAttribute("books", books);
            model.addAttribute("sections", sections);
            return "books_library/add";
        }
        Books booksfind = booksRepository.findBooksByUID(books_uid);
        Sections sectionsfind = sectionsRepository.findSectionsByUID(sections_uid);
        BooksLibrary booksLibrary = new BooksLibrary(bookslibrary.getNumberrack(), bookslibrary.getNumbershelf(), bookslibrary.getCount(), booksfind,sectionsfind);
        booksLibraryRepository.save(booksLibrary);
        return "redirect:/books_library";
    }
}

