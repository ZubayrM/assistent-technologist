package project.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.model.User;
import sun.awt.SunHints;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {



    User findByUsername(String s);

    @Query(value = "select * from User where number = ?1", nativeQuery = true)
    User findByNumber(String number);

    @Query(value = "select * from User where code = ?1", nativeQuery = true)
    User findByCode(String code);

    @Query(value = "select * from User ", nativeQuery = true)
    List<User> findAll();
}
