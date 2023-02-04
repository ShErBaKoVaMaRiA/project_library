package com.example.project_library.Repository;

import com.example.project_library.Models.ExtraditionBooks;
import org.springframework.data.repository.CrudRepository;

public interface ExtraditionBooksRepository extends CrudRepository<ExtraditionBooks,Long> {
//    ExtraditionBooks findByDateextradition (String name);
//    public List<ExtraditionBooks> findByNameContains(String name);
}
