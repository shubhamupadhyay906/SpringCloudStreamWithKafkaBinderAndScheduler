package com.mindtree.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
