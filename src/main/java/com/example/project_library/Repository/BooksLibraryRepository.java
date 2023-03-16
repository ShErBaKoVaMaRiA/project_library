package com.example.project_library.Repository;

import com.example.project_library.Models.BooksLibrary;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface BooksLibraryRepository extends CrudRepository<BooksLibrary,Long> {
//    BooksLibrary findByName (String name);
//    public List<BooksLibrary> findByNameContains(String name);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `books` where uid = :uid",nativeQuery = true)
    int deleteBooks(@Param("uid")Long uid);
}
