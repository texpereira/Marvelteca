package com.marvel.Marvelteca_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marvel.Marvelteca_rest.services.MarvelService;

@RestController
@RequestMapping("/marvel")
public class controlador {
    
    @Autowired
    private MarvelService marvelService;

    @GetMapping("/index") //se borra espacio de prueba
    public String getIndex() {
        String apiUrl = "characters";
        return marvelService.getDataFromApi(apiUrl);
    }

    @GetMapping("/character/{characterId}")
    public String getApiData(@PathVariable int characterId) {
        String apiUrl = "characters/" + characterId;
        return marvelService.getDatacharacterId(apiUrl);
    }
    
    @GetMapping("/character/{characterId}/comics")
    public String getComicCharacter(@PathVariable int characterId) {
        String apiUrl = "characters/" + characterId + "/comics";
        return marvelService.getDatacharacterId(apiUrl);
    }

    @GetMapping("/comics") //se agrega interface comics
    public String getComics() {
        String apiUrl = "comics";
        return marvelService.getDataFromApi(apiUrl);
    }

    @GetMapping("/comics/{comicId}")
    public String getComicId(@PathVariable int comicId) {
        String apiUrl = "comics/" + comicId;
        String response = marvelService.getDataFromApi(apiUrl);
        if (response.isEmpty() || response.equals("")) {
            return "Not found";
        } else {
            return response;
        }
    }

    @GetMapping("/events") //se agrega interface events
    public String getEvents() {
        String apiUrl = "events";
        return marvelService.getDataFromApi(apiUrl);
    }

    @GetMapping("/series") //se agrega interface series
    public String getSeries() {
        String apiUrl = "series";
        return marvelService.getDataFromApi(apiUrl);
    }

    @GetMapping("/stories") //se agrega interface stories
    public String getStories() {
        String apiUrl = "stories";
        return marvelService.getDataFromApi(apiUrl);
    }

}
