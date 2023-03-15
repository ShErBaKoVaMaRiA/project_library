package com.example.project_library.Controllers;

import com.example.project_library.Models.Readers;
import com.example.project_library.Repository.ReadersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/readers")
@PreAuthorize("hasAnyAuthority('LIBRARIAN')")
public class ReaderController {
    @Autowired
    ReadersRepository readersRepository;
    @GetMapping("/")
        public String index(Model model){
            Iterable<Readers> readersIterable = readersRepository.findAll();
            model.addAttribute("readers_list", readersIterable);
            return "readers/index";}

    @PostMapping("/add")
    public String AddReader(@Valid Readers readers, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "readers/add";
        }
        readersRepository.save(readers);
        return "redirect:/readers/";
    }
    @GetMapping("/add")
    public String AddView(Readers readers){
        return "readers/add";
    }

    @GetMapping("/detail/{id}")
    public String detailReader(
            @PathVariable Long id,
            Model model
    ){
        Readers reader_obj = readersRepository.findById(id).orElseThrow();
        model.addAttribute("one_reader", reader_obj);
        return "readers/info";
    }

    @PostMapping ("/detail/{id}/del")
    public String  delReader(@PathVariable Long id)
    {
        Readers reader_obj = readersRepository.findById(id).orElseThrow();
        readersRepository.delete(reader_obj);
        return "redirect:/readers/";
    }
    @GetMapping("/filter/")
    public String filter(
            @RequestParam(name="surname") String surname,
            Model model){
        List<Readers> readersList = readersRepository.findBySurname(surname);
        model.addAttribute("readers_list", readersList);
        return"readers/index";
    }
    @GetMapping("/filtercontains/")
    public String filterContains(
            @RequestParam(name="surname") String surname,
            Model model){
        List<Readers> readersList = readersRepository.findBySurnameContains(surname);
        model.addAttribute("readers_list", readersList);
        return"readers/index";
    }

    @GetMapping ("/detail/{id}/upd")
    public String  updateView(@PathVariable Long id,Model model)
    {
        model.addAttribute("readers",readersRepository.findById(id).orElseThrow());
        return "readers/update";
    }

    @PostMapping ("/detail/{id}/upd")
    public String updateD(@PathVariable Long id, @Valid Readers readers, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "readers/update";
        }
        readersRepository.updateAuthors(readers.getSurname(),readers.getName(),readers.getMiddlename(),readers.getDatebirthday(),readers.getPassport(),readers.getTelefon(), id);
        return "redirect:/readers/detail/"+id;
    }
}
