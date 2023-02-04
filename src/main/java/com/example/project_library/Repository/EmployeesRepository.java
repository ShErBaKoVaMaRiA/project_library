package com.example.project_library.Repository;

import com.example.project_library.Models.Employees;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeesRepository extends CrudRepository<Employees,Long> {
    Employees findEmployeesByUID(Long UID);
    Employees findByName (String name);
    public List<Employees> findByNameContains(String name);
}
