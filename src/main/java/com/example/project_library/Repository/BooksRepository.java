package com.example.project_library.Repository;

import com.example.project_library.Models.Books;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BooksRepository extends CrudRepository<Books,Long> {
    Books findBooksByUID (Long UID);
    Books findByName (String name);
    public List<Books> findByNameContains(String name);
}
