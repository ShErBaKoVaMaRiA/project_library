package com.example.project_library.Repository;

import com.example.project_library.Models.Readers;
import com.example.project_library.Models.Sections;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface SectionsRepository extends CrudRepository<Sections,Long> {
    Sections findSectionsByUID(Long UID);
    Sections findByName (String name);
    public List<Sections> findByNameContains(String name);
    @Transactional
    @Modifying
    @Query(value="UPDATE sections SET name=?1 WHERE uid=?2",nativeQuery=true)
    void updateSections(String name, Long uid);
}
