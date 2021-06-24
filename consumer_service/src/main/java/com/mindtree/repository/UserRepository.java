package com.mindtree.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.model.ConsumerUser;


public interface UserRepository extends JpaRepository<ConsumerUser, Integer>{

}
