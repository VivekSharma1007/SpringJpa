package com.springpractice.SpringJpa.Dao;

import com.springpractice.SpringJpa.Entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
