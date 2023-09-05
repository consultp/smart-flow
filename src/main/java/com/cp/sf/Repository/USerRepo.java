package com.cp.sf.Repository;

import com.cp.sf.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface USerRepo extends JpaRepository<User, String> {
    User findByUsername(String username);


    @Query("select mailid,mobileno from User group by mailid,mobileno having count(*)>1")
    List<Object> searchDuplicatesinEmailAndPassword();



   //
   /*@Query("select u from User u where"+" u.username like concat('%',:?1,'%'"+"or u.description like concat('%',:query,'%'")
    List<User> findbyUserName(String query);*/

    List<User> findByUsernameOrMailid(String username,String mailid);

}
