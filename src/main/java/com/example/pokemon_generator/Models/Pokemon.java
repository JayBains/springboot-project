package com.example.pokemon_generator.Models;

public class Pokemon {
    private String name;


    public Pokemon(String name){
        this.name = name;
    }

    public Pokemon(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Pokemon {name = `" + name + "`}";
    }
}
