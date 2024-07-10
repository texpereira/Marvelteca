package com.marvel.Marvelteca_rest.object;

import lombok.Data;
import java.util.Date;
import java.util.List;
@Data
public class Personaje {
        private Integer id;
        private String name;
        private String description;
        private Date modified;
        private String resourceURI;
        private List <Url> urls;
        private Image thumbnail;
//        comics (ComicList, opcional)
//        stories (StoryList, opcional)
//        events (EventList, opcional)
//        series (SeriesList, opcional)
public Personaje (){}
}
