package com.cp.sf.Repository;

import com.cp.sf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface USerRepo extends JpaRepository<User,Long> {
}
