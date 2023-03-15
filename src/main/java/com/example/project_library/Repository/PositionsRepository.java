package com.example.project_library.Repository;

import com.example.project_library.Models.Positions;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface PositionsRepository extends CrudRepository<Positions,Long> {
    Positions findPositionsByUID (Long uid);
    Positions findByName (String name);
    public List<Positions> findByNameContains(String name);
    @Transactional
    @Modifying
    @Query(value="UPDATE positions SET name=?1, salary=?2 WHERE uid=?3",nativeQuery=true)
    void updatePositions(String name,float salary, Long uid);
}
