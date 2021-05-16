package com.recomecar.projeto.recomecar.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recomecar.projeto.recomecar.projeto.model.User;

public interface UserRepository extends JpaRepository<User, String>{

}
