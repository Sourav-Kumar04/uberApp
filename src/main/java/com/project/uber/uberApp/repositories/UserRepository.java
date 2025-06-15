package com.project.uber.uberApp.repositories;

import com.project.uber.uberApp.enitities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //this method handled by Spring data JPA ... that automatically creates such methods and this method is being convert to query by hibernate
    Optional<User> findByEmail(String email);
}
