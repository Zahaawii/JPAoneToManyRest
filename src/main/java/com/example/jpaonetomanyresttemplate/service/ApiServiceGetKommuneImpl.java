package com.example.jpaonetomanyresttemplate.service;


import com.example.jpaonetomanyresttemplate.model.Kommune;
import com.example.jpaonetomanyresttemplate.model.Region;
import com.example.jpaonetomanyresttemplate.repository.KommuneRepository;
import com.example.jpaonetomanyresttemplate.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiServiceGetKommuneImpl implements ApiServiceGetKommuner{

    private final RestTemplate restTemplate;

    public ApiServiceGetKommuneImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    String regionUrl = "https://api.dataforsyningen.dk/kommuner";

    @Autowired
    KommuneRepository kommuneRepository;

    private void saveKommune(List<Kommune> Kommune) {
        kommuneRepository.saveAll(Kommune);
    }

    @Override
    public List<Kommune> getKommuner() {
        List<Kommune> lst = new ArrayList<>();
        ResponseEntity<List<Kommune>> kommuneResponse = restTemplate.exchange(regionUrl,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Kommune>>() {
                });
        List<Kommune> Kommune = kommuneResponse.getBody();
        saveKommune(Kommune);

        return Kommune;
    }

}
