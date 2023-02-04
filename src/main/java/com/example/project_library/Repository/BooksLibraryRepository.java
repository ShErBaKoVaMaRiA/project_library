package com.example.project_library.Repository;

import com.example.project_library.Models.BooksLibrary;
import org.springframework.data.repository.CrudRepository;

public interface BooksLibraryRepository extends CrudRepository<BooksLibrary,Long> {
//    BooksLibrary findByName (String name);
//    public List<BooksLibrary> findByNameContains(String name);
}
