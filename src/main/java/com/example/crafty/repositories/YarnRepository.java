package com.example.crafty.repositories;

import com.example.crafty.entities.yarn.Yarn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface YarnRepository extends JpaRepository<Yarn, UUID> {
}
