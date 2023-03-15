package com.example.project_library.Repository;

import com.example.project_library.Models.Readers;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

public interface ReadersRepository extends CrudRepository<Readers,Long> {
    public Readers findReadersByUID (Long uid);
    public List<Readers> findBySurname (String surname);
    public List<Readers> findBySurnameContains(String surname);

    @Query(value="SELECT * FROM readers WHERE surname =?1",nativeQuery=true)
    List<Readers> selectReaders(String surname);

    @Transactional
    @Modifying
    @Query(value="UPDATE readers SET surname=?1,name=?2,middleName=?3,datebirthday=?4,passport=?5,telefon=?6 WHERE uid=?7",nativeQuery=true)
    void updateAuthors(String surname, String name, String middlename, Date datebirthday,String passport,String telefon, Long uid);
}
