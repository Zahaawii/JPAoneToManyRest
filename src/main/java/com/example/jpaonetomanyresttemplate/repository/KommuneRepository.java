package com.example.jpaonetomanyresttemplate.repository;

import com.example.jpaonetomanyresttemplate.model.Kommune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KommuneRepository extends JpaRepository<Kommune, Integer> {

}
