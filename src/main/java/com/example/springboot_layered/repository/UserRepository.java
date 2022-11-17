package com.example.springboot_layered.repository;

import com.example.springboot_layered.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByName (String name);
}
