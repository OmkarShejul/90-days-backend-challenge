package com.omkar.jobtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.omkar.jobtracker.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
