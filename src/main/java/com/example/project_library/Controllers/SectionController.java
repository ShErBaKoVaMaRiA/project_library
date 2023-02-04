package com.example.project_library.Controllers;

import com.example.project_library.Models.Sections;
import com.example.project_library.Repository.SectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/sections")

public class SectionController {
    @Autowired
    SectionsRepository classRepository;
    @GetMapping("/")
        public String index(Model model){
            Iterable<Sections> sectionsIterable = classRepository.findAll();
            model.addAttribute("sections_list", sectionsIterable);
            return "sections/index";}

    @PostMapping("/add")
    public String Add(@Valid Sections sections, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "sections/add";
        }
        classRepository.save(sections);
        return "redirect:/sections/";
    }
    @GetMapping("/add")
    public String AddView(Sections sections){
        return "sections/add";
    }

    @GetMapping("/detail/{id}")
    public String detail(
            @PathVariable Long id,
            Model model
    ){
        Sections section_obj = classRepository.findById(id).orElseThrow();
        model.addAttribute("one_section", section_obj);
        return "sections/info";
    }

    @PostMapping ("/detail/{id}/del")
    public String  del(@PathVariable Long id)
    {
        Sections section_obj = classRepository.findById(id).orElseThrow();
        classRepository.delete(section_obj);
        return "redirect:/sections/";
    }
    @GetMapping ("/detail/{id}/upd")
    public String updateView(@PathVariable Long id,Model model)
    {
        model.addAttribute("one_section", classRepository.findById(id).orElseThrow());
        return "sections/update";
    }

    @PostMapping ("/detail/{id}/upd")
    public String updateD(@PathVariable Long id, @Valid Sections sections, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "sections/update";
        }
        Sections section_obj = classRepository.findById(id).orElseThrow();
        classRepository.delete(section_obj);
        classRepository.save(sections);
        return "redirect:/sections/detail/"+sections.getUID();
    }
}
