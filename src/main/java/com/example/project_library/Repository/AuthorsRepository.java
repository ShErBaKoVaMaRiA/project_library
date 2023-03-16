package com.example.project_library.Repository;

import com.example.project_library.Models.Authors;
import com.example.project_library.Models.Readers;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface AuthorsRepository extends CrudRepository<Authors, Long> {
    public Authors findAuthorsByUID (Long uid);
    Authors findByName (String name);
    public List<Authors> findByNameContains(String name);
    @Transactional
    @Modifying
    @Query(value="UPDATE authors SET surname=?1,Name=?2,MiddleName=?3 WHERE uid=?4",nativeQuery=true)
    void updateAuthors(String surname,String name,String middlename, Long uid);
}
