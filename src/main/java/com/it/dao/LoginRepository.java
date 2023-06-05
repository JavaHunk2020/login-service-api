package com.it.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.dao.entity.Login;

public interface LoginRepository extends JpaRepository<Login, String> {
	
	Optional<Login> findByUsernameAndPassword(String username,String password);
}
