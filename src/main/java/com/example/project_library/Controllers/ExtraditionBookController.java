package com.example.project_library.Controllers;

import com.example.project_library.Models.*;
import com.example.project_library.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
@PreAuthorize("hasAnyAuthority('LIBRARIAN')")
public class ExtraditionBookController {
    @Autowired
    public ExtraditionBooksRepository extraditionBooksRepository;
    @Autowired
    public BooksRepository booksRepository;
    @Autowired
    public LibraryCardsRepository libraryCardsRepository;
    @Autowired
    public EmployeesRepository employeesRepository;


    @GetMapping("/extradition_books")
    public String index(Model model) {
        Iterable<ExtraditionBooks> extraditionBooks = extraditionBooksRepository.findAll();
        Iterable<Books> books = booksRepository.findAll();
        Iterable<LibraryCards> libraryCards = libraryCardsRepository.findAll();
        Iterable<Employees> employees = employeesRepository.findAll();
        model.addAttribute("extradition_books", extraditionBooks);
        model.addAttribute("books", books);
        model.addAttribute("library_cards", libraryCards);
        model.addAttribute("employees", employees);
        return "extradition_books/index";
    }

    @GetMapping("/extradition_books/add")
    public String Main(Model model) {
        Iterable<Books> books = booksRepository.findAll();
        Iterable<LibraryCards> libraryCards = libraryCardsRepository.findAll();
        Iterable<Employees> employees = employeesRepository.findAll();
        model.addAttribute("books", books);
        model.addAttribute("library_cards", libraryCards);
        model.addAttribute("employees", employees);
        return "extradition_books/add";
    }

    @PostMapping("/extradition_books/add")
    public String Add(@RequestParam(name="dateextradition") Date dateextradition, @RequestParam(name="datereturn") Date datereturn, @RequestParam(name="books_uid") Long books, @RequestParam(name="library_cards_uid") Long library_cards, @RequestParam(name="employees_uid") Long employees, Model model) {

        Books booksfind = booksRepository.findBooksByUID(books);
        LibraryCards cardsfind = libraryCardsRepository.findLibraryCardsByUID(library_cards);
        Employees employeesfind = employeesRepository.findEmployeesByUID(employees);
        ExtraditionBooks extraditionBooks = new ExtraditionBooks(dateextradition,datereturn,booksfind,cardsfind,employeesfind);
        extraditionBooksRepository.save(extraditionBooks);
        return "redirect:/extradition_books";
    }
}

