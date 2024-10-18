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
        private List<Url> urls;
        private Image thumbnail;
        private ComicList comics;
        private StoryList stories;
        private EventList events;
        private SeriesList series;
public Character (){}
}
