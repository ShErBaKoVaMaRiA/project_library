package com.example.project_library.Controllers;

import com.example.project_library.Models.Divisions;
import com.example.project_library.Repository.DivisionsRepository;
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
@RequestMapping("/divisions")

public class DivisionController {
    @Autowired
    DivisionsRepository divisionsRepository;
    @GetMapping("/")
        public String index(Model model){
            Iterable<Divisions> divisionsIterable = divisionsRepository.findAll();
            model.addAttribute("division_list", divisionsIterable);
            return "divisions/index";}

    @PostMapping("/add")
    public String AddDivision(@Valid Divisions divisions, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "divisions/add";
        }
        divisionsRepository.save(divisions);
        return "redirect:/divisions/";
    }
    @GetMapping("/add")
    public String AddView(Divisions divisions){
        return "divisions/add";
    }
    @GetMapping("/detail/{id}")
    public String detailDivision(
            @PathVariable Long id,
            Model model
    ){
        Divisions division_obj = divisionsRepository.findById(id).orElseThrow();
        model.addAttribute("one_division", division_obj);
        return "divisions/info";
    }

    @PostMapping ("/detail/{id}/del")
    public String  delDivision(@PathVariable Long id)
    {
        Divisions division_obj = divisionsRepository.findById(id).orElseThrow();
        divisionsRepository.delete(division_obj);
        return "redirect:/divisions/";
    }
    @GetMapping ("/detail/{id}/upd")
    public String  updateView(@PathVariable Long id,Model model)
    {
        model.addAttribute("one_division",divisionsRepository.findById(id).orElseThrow());
        return "divisions/update";
    }

    @PostMapping ("/detail/{id}/upd")
    public String updateD(@PathVariable Long id, @Valid Divisions divisions, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "divisions/update";
        }
        Divisions division_obj = divisionsRepository.findById(id).orElseThrow();
        divisionsRepository.delete(division_obj);
        divisionsRepository.save(divisions);
        return "redirect:/divisions/detail/"+divisions.getUID();
    }
}
