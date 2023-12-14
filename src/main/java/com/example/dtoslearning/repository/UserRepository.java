package com.example.dtoslearning.repository;

import com.example.dtoslearning.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long> {
}
