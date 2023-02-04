package com.example.project_library.Repository;

import com.example.project_library.Models.Readers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReadersRepository extends CrudRepository<Readers,Long> {
    public Readers findReadersByUID (Long uid);
    public List<Readers> findBySurname (String surname);
    public List<Readers> findBySurnameContains(String surname);

    @Query(value="SELECT * FROM readers WHERE surname =?1",nativeQuery=true)
    List<Readers> selectReaders(String surname);
}
