package com.marvel.Marvelteca_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marvel.Marvelteca_rest.services.MarvelService;

@RestController
@RequestMapping("/api")
public class controlador {
    
    @Autowired
    private MarvelService marvelService;

    @GetMapping("/marvel/{characterId}")
    public String getApiData() {
        String apiUrl = "marvel/characterId";
        return marvelService.getDatacharacterId(apiUrl);
    }

    @GetMapping("/marvel") //se borra espacio de prueba
    public String getComics() {
        String apiUrl = "characters";
        return marvelService.getDataFromApi(apiUrl);
    }
}
