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

    private RestTemplate restTemplate;

    public ApiServiceGetKommuneImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    String kommuneUrl = "https://api.dataforsyningen.dk/kommuner";

    @Autowired
    KommuneRepository kommuneRepository;

    private void saveKommuner(List<Kommune> kommuner){
        kommuner.forEach(kom -> kommuneRepository.save(kom));
    }

    @Override
    public List<Kommune> getKommuner() {

        //pak response fra api ud
        ResponseEntity<List<Kommune>> kommuneResponse =
                restTemplate.exchange(kommuneUrl,
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Kommune>>() {
                        });
        List<Kommune> kommuner = kommuneResponse.getBody();
        saveKommuner(kommuner);
        return kommuner;
    }

}
