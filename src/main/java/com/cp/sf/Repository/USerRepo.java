package com.cp.sf.Repository;

import com.cp.sf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface USerRepo extends JpaRepository<User,String> {
    User findByUsername(String username);


    @Query("select mailid,mobileno from User group by mailid,mobileno having count(*)>1")
    List<Object> searchDuplicatesinEmailAndPassword();

    @Query("select id,username,mailid,mobileno,active,address from User")
    List<Object> getallUsersexceptpassword();



}
