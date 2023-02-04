package com.example.project_library.Controllers;

import com.example.project_library.Models.LibraryCards;
import com.example.project_library.Models.Readers;
import com.example.project_library.Repository.LibraryCardsRepository;
import com.example.project_library.Repository.ReadersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Console;
import java.sql.Date;

@Controller
@PreAuthorize("hasAnyAuthority('LIBRARIAN')")
public class LibraryCardController {
    @Autowired
    public LibraryCardsRepository libraryCardsRepository;
    @Autowired
    public ReadersRepository readersRepository;

    @GetMapping("/library_cards")
    public String index(Model model) {
        Iterable<LibraryCards> libraryCards = libraryCardsRepository.findAll();
        Iterable<Readers> readers = readersRepository.findAll();
        model.addAttribute("library_cards", libraryCards);
        model.addAttribute("readers", readers);
        return "library_cards/cards-index";
    }

    @GetMapping("/library_cards/add")
    public String Main(Model model) {
        Iterable<Readers> readers = readersRepository.findAll();
        model.addAttribute("readers", readers);
        return "library_cards/cards-add";
    }

    @PostMapping("/library_cards/add")
    public String Add(@RequestParam(name="Date_Open") Date date_open, @RequestParam(name="Date_Close") Date date_close, @RequestParam(name="readers_uid") Long readers, Model model) {

        Readers readersfind = readersRepository.findReadersByUID(readers);
        LibraryCards cards = new LibraryCards(date_open, date_close,readersfind);
        libraryCardsRepository.save(cards);
        return "redirect:/library_cards";
    }
}

