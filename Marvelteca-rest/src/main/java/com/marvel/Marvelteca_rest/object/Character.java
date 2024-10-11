package com.marvel.Marvelteca_rest.object;

import java.util.Date;
import java.util.List;

import lombok.Data;
@Data
public class Character {
        private Integer id;
        private String name;
        private String description;
        private Date modified;
        private String resourceURI;
        private List <Url> urls;
        private Image thumbnail;
        private List <ComicList> comics;
        private List <StoryList> stories;
        private List <EventList> events;
        private List <SeriesList> series;
public Character (){}
}
