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

    @GetMapping("/aaa")
    public String getApiData() {
        String apiUrl = "http://gateway.marvel.com/v1/public/characters";
        String apiKey = "7b0e8624af849eee2948448934d27972"; // Reemplaza esto con tu clave real
        return marvelService.getDataFromApi();
    }

    @GetMapping("/marvel") //se borra espacio de prueba
    public String getComics() {
        return marvelService.getDataFromApi();
    }
}
