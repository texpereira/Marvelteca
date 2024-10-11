package com.marvel.Marvelteca_rest.object;

import java.util.List;

import lombok.Data;

@Data
public class EventList {
    private Integer available;
    private Integer returned;
    private String collectionURI;
    private List<EventSummary> items;
}
