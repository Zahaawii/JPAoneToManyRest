package com.example.jpaonetomanyresttemplate.controller;


import com.example.jpaonetomanyresttemplate.model.Kommune;
import com.example.jpaonetomanyresttemplate.model.Region;
import com.example.jpaonetomanyresttemplate.repository.KommuneRepository;
import com.example.jpaonetomanyresttemplate.repository.RegionRepository;
import com.example.jpaonetomanyresttemplate.service.ApiServiceGetKommuner;
import com.example.jpaonetomanyresttemplate.service.ApiServiceGetRegioner;
import com.example.jpaonetomanyresttemplate.service.ApiServiceGetRegionerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/tool")
public class ToolRestController {

    @Autowired
    ApiServiceGetRegioner apiServiceGetRegioner;
    @Autowired
    RegionRepository repository;
    @Autowired
    ApiServiceGetRegionerImpl regioner;


    @GetMapping("/getregioner")
    public List<Region> getRegioner() {
        List<Region> lstRegioner = apiServiceGetRegioner.getRegioner();
        return lstRegioner;
    }

    @DeleteMapping("/delete/region/{id}")
    public ResponseEntity<?> deleteRegion(@PathVariable String id) {
        Optional<Region> test = repository.findById(id);
        if(test.isPresent()) {
            repository.deleteById(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        }
        return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getkommunebyregion/{id}")
    public List<String> getAllRegion(@PathVariable String id) {
        List<String> lst = regioner.getKommuneByRegion(id);
        return lst;
    }

}
