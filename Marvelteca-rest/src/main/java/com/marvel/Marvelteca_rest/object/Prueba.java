package com.marvel.Marvelteca_rest.object;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Prueba {
    public static void main(String[] args) {
        Character personaje1 = new Character();
        personaje1.setId(1);
        personaje1.setName("Ironman");
        personaje1.setDescription("Vengador");
        personaje1.setUrls(new ArrayList<>());
        personaje1.setModified(new Date());
        personaje1.setResourceURI("Prueba");
        personaje1.setThumbnail(new Image("", "png"));
        System.out.println("personaje1 = " + personaje1);

        Character personaje2 = new Character();
        personaje2.setId(2);
        personaje2.setName("Cap. America");
        personaje2.setDescription("First Vengador");
        personaje2.setUrls(new ArrayList<>());
        personaje2.setModified(new Date());
        personaje2.setResourceURI("Prueba");
        personaje2.setThumbnail(new Image("", "png"));
        System.out.println("personaje2 = " + personaje2);

        Character personaje3 = new Character();
        personaje3.setId(3);
        personaje3.setName("Hulk");
        personaje3.setDescription("El mas fuerte");
        personaje3.setUrls(new ArrayList<>());
        personaje3.setModified(new Date());
        personaje3.setResourceURI("Prueba");
        personaje3.setThumbnail(new Image("", "png"));
        System.out.println("personaje3 = " + personaje3);
        List<Character> personajes = new ArrayList<>();
        personajes.add(personaje1);
        personajes.add(personaje2);
        personajes.add(personaje3);
        System.out.println("personajes[1] = " + personajes.get(1));
        int posicion = 0;
        for (Character personaje : personajes) {
            if (personaje.getName().equals("Hulk")) {
                System.out.println("personaje = " + personaje + "El personaje estaba en la posicion = " + posicion);
            } else {
                posicion ++;
                System.out.println("personaje error = " + personaje.getName());
            }
        }
    }
}

