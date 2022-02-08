package com.user.management.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.user.management.usermanagement.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
