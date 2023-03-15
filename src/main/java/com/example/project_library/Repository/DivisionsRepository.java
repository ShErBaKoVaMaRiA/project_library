package com.example.project_library.Repository;

import com.example.project_library.Models.Divisions;
import com.example.project_library.Models.Positions;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface DivisionsRepository extends CrudRepository<Divisions, Long> {
    Divisions findDivisionsByUID (Long uid);
    Divisions findByName (String name);
    public List<Divisions> findByNameContains(String name);

    @Transactional
    @Modifying
    @Query(value="UPDATE divisions SET name=?1, address=?2 WHERE uid=?3",nativeQuery=true)
    void updateDivisions(String name,String address, Long uid);
}
