package com.example.project_library.Controllers;

import com.example.project_library.Models.*;
import com.example.project_library.Repository.DivisionsRepository;
import com.example.project_library.Repository.EmployeesRepository;
import com.example.project_library.Repository.PositionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.Valid;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/employees")
@PreAuthorize("hasAnyAuthority('MANAGER')")
public class EmployeeController {
    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    PositionsRepository positionsRepository;
    @Autowired
    DivisionsRepository divisionsRepository;
    @GetMapping("/")
    public String index(Model model){
        Iterable<Employees> employeesIterable = employeesRepository.findAll();
        model.addAttribute("employees", employeesIterable);
        Iterable<Divisions> divisionsIterable = divisionsRepository.findAll();
        model.addAttribute("divisions", divisionsIterable);
        Iterable<Positions> positionsIterable = positionsRepository.findAll();
        model.addAttribute("positions", positionsIterable);
        return "employees/index";
    }

    @GetMapping("/add")
    public String AddView(Model model,Employees employees){
        Iterable<Positions> positions = positionsRepository.findAll();
        Iterable<Divisions> divisions = divisionsRepository.findAll();
        model.addAttribute("positions", positions);
        model.addAttribute("divisions", divisions);
        return "employees/add";
    }

    @PostMapping("/add")
    public String AddEmployee(@RequestParam String surname,@RequestParam String name,@RequestParam String middlename,@RequestParam Date datebirthday,@RequestParam String passport,@RequestParam String telefon,@RequestParam Long divisions_uid, @RequestParam Long positions_uid) {
        Positions positionsfind = positionsRepository.findPositionsByUID(positions_uid);
        Divisions divisionsfind = divisionsRepository.findDivisionsByUID(divisions_uid);
        Employees employee_one = new Employees(surname, name, middlename, datebirthday, passport, telefon, divisionsfind, positionsfind);
        employeesRepository.save(employee_one);
        return "redirect:/employees/";
    }
}
