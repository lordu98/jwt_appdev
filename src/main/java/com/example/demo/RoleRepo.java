package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<AppRole, Integer> {

    AppRole findByName (String name);
}
