package com.example.project_library.Repository;

import com.example.project_library.Models.Authors;
import com.example.project_library.Models.Readers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorsRepository extends CrudRepository<Authors, Long> {
    public Authors findAuthorsByUID (Long uid);
    Authors findByName (String name);
    public List<Authors> findByNameContains(String name);
}
