package com.example.project_library.Repository;

import com.example.project_library.Models.Sections;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SectionsRepository extends CrudRepository<Sections,Long> {
    Sections findSectionsByUID(Long UID);
    Sections findByName (String name);
    public List<Sections> findByNameContains(String name);
}
