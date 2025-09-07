package com.example.jpaonetomanyresttemplate.repository;

import com.example.jpaonetomanyresttemplate.model.Kommune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface KommuneRepository extends JpaRepository<Kommune, String> {

    @Query("SELECT k.navn FROM Kommune k WHERE k.region.kode = :name")
    List<String> findAllKommune(String name);
}
