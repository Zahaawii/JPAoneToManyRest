package com.example.jpaonetomanyresttemplate.service;


import com.example.jpaonetomanyresttemplate.model.Kommune;
import com.example.jpaonetomanyresttemplate.model.Region;
import com.example.jpaonetomanyresttemplate.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ApiServiceGetRegionerImpl implements ApiServiceGetRegioner{

    private final RestTemplate restTemplate;

    public ApiServiceGetRegionerImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    String regionUrl = "https://api.dataforsyningen.dk/regioner";

    @Autowired
    RegionRepository regionRepository;

    private void saveRegioner(List<Region> regioner) {
        regionRepository.saveAll(regioner);
    }

    @Override
    public List<Region> getRegioner() {
        List<Region> lst = new ArrayList<>();
        ResponseEntity<List<Region>> regionResponse = restTemplate.exchange(regionUrl,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Region>>() {
                });
        List<Region> regioner = regionResponse.getBody();
        saveRegioner(regioner);

        return regioner;
    }

    public List<String> getKommuneByRegion(String id) {
        List<String> newList = new ArrayList<>();

        Optional<Region> region = regionRepository.findById(id);
        if(region.isPresent()) {
            for(Kommune k : region.get().getKommuner()) {
                newList.add(k.getNavn());
            }
        }
        return newList;
    }

}
