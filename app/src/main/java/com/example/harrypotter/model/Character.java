package com.example.harrypotter.model;

public class Character {
    public String name;
    public String species;
    public String gender;
    public String house;
    public String dateOfBirth;
    public String patronus;
    public String hogwartsStudent;
    public String actor;
    public String alive;
    public String image;

    public Character(){

    }

    public Character(String name, String species, String gender, String house, String dateOfBirth, String patronus, String hogwartsStudent, String actor, String alive, String image) {
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.house = house;
        this.dateOfBirth = dateOfBirth;
        this.patronus = patronus;
        this.hogwartsStudent = hogwartsStudent;
        this.actor = actor;
        this.alive = alive;
        this.image = image;
    }
}
