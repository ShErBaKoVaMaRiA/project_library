package com.example.project_library.Repository;

import com.example.project_library.Models.Genres;
import com.example.project_library.Models.Readers;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface GenresRepository extends CrudRepository<Genres,Long> {
    public Genres findGenresByUID (Long uid);
    Genres findByName (String name);
    public List<Genres> findByNameContains(String name);
    @Transactional
    @Modifying
    @Query(value="UPDATE genres SET name=?1 WHERE uid=?2",nativeQuery=true)
    void updateGenres(String name, Long uid);
}
