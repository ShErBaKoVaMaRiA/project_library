package com.example.project_library.Repository;

import com.example.project_library.Models.LibraryCards;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;

public interface LibraryCardsRepository extends CrudRepository<LibraryCards,Long> {
    LibraryCards findLibraryCardsByUID(Long UID);
//    public List<LibraryCards> findByNameContains(String name);
}
