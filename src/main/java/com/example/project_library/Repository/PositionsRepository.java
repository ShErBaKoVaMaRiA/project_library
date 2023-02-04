package com.example.project_library.Repository;

import com.example.project_library.Models.Positions;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PositionsRepository extends CrudRepository<Positions,Long> {
    Positions findPositionsByUID (Long uid);
    Positions findByName (String name);
    public List<Positions> findByNameContains(String name);
}
