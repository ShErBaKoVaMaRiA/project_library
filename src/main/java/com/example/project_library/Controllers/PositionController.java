package com.example.project_library.Controllers;

import com.example.project_library.Models.Positions;
import com.example.project_library.Repository.PositionsRepository;
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
@RequestMapping("/positions")
@PreAuthorize("hasAnyAuthority('MANAGER')")
public class PositionController {
    @Autowired
    PositionsRepository classRepository;
    @GetMapping("/")
        public String index(Model model){
            Iterable<Positions> positionsIterable = classRepository.findAll();
            model.addAttribute("positions_list", positionsIterable);
            return "positions/index";}

    @PostMapping("/add")
    public String Add(@Valid Positions positions, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "positions/add";
        }
        classRepository.save(positions);
        return "redirect:/positions/";
    }
    @GetMapping("/add")
    public String AddView(Positions positions){
        return "positions/add";
    }

    @GetMapping("/detail/{id}")
    public String detail(
            @PathVariable Long id,
            Model model
    ){
        Positions position_obj = classRepository.findById(id).orElseThrow();
        model.addAttribute("one_position", position_obj);
        return "positions/info";
    }

    @PostMapping ("/detail/{id}/del")
    public String  del(@PathVariable Long id)
    {
        Positions position_obj = classRepository.findById(id).orElseThrow();
        classRepository.delete(position_obj);
        return "redirect:/positions/";
    }
    @GetMapping ("/detail/{id}/upd")
    public String updateView(@PathVariable Long id,Model model)
    {
        model.addAttribute("one_position", classRepository.findById(id).orElseThrow());
        return "positions/update";
    }

    @PostMapping ("/detail/{id}/upd")
    public String updateD(@PathVariable Long id, @Valid Positions positions, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "positions/update";
        }
        Positions position_obj = classRepository.findById(id).orElseThrow();
        classRepository.delete(position_obj);
        classRepository.save(positions);
        return "redirect:/positions/detail/"+positions.getUID();
    }
}
