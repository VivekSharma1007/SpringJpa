package com.springpractice.SpringJpa.Dao;

import com.springpractice.SpringJpa.Entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// normally in this interface we do not implement any method all method implementations are given by JPA Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // but we can create our derived methods such as
    // if we want to find some data on the basis of name
    // so in JPA Repo by default we have findById and findAll but not findByName so we just have to declare a method
    // with the given naming convention and spring boot will work by itself on it

    public List<User> findByName(String name);
}
