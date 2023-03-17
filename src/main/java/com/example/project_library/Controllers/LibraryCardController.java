package com.example.project_library.Controllers;

import com.example.project_library.Models.*;
import com.example.project_library.Repository.LibraryCardsRepository;
import com.example.project_library.Repository.ReadersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
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
    public String Main(Model model,LibraryCards libraryCards) {
        Iterable<Readers> readers = readersRepository.findAll();
        model.addAttribute("readers", readers);
        return "library_cards/cards-add";
    }
    @PostMapping("/library_cards/add")
    public String Add(@Valid LibraryCards libraryCards, BindingResult bindingResult,  Long readers_uid, Model model) {
        if (bindingResult.hasErrors()) {
            Iterable<Readers> readers = readersRepository.findAll();
            model.addAttribute("readers", readers);
            return "library_cards/cards-add";
        }
        Readers readersfind = readersRepository.findReadersByUID(readers_uid);
        LibraryCards cards = new LibraryCards(libraryCards.getDate_open(), libraryCards.getDate_close(),readersfind);
        libraryCardsRepository.save(cards);
        return "redirect:/library_cards";
    }
}

