package com.example.jpaonetomanyresttemplate.service;

import com.example.jpaonetomanyresttemplate.model.Kommune;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ApiServiceGetKommuner {
    List<Kommune> getKommuner();
}
