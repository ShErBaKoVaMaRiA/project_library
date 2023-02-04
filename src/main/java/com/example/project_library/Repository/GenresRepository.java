package com.example.project_library.Repository;

import com.example.project_library.Models.Genres;
import com.example.project_library.Models.Readers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GenresRepository extends CrudRepository<Genres,Long> {
    public Genres findGenresByUID (Long uid);
    Genres findByName (String name);
    public List<Genres> findByNameContains(String name);
}
