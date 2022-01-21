package com.ecommerce.ecommercesystem.repository;

import com.ecommerce.ecommercesystem.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepo extends JpaRepository<UserLogin, Integer> {
}
