package com.example.jpaonetomanyresttemplate.repository;

import com.example.jpaonetomanyresttemplate.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {

}