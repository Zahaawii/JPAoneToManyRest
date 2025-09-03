package com.example.jpaonetomanyresttemplate.service;

import com.example.jpaonetomanyresttemplate.model.Region;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApiServiceGetRegioner {
    List<Region> getRegioner();
}