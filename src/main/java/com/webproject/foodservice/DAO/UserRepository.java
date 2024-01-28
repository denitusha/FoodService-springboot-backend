package com.webproject.foodservice.DAO;

import com.webproject.foodservice.entity.Role;
import com.webproject.foodservice.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByEmail(String email);

    User findByRole(Role role);




}
