package com.example.User.Service.Project.reository;

import com.example.User.Service.Project.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<user, Long> {
}
