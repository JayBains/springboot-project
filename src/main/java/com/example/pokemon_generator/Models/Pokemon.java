package com.example.pokemon_generator.Models;

public class Pokemon {
    private String name;
    private String spriteUrl;

    public Pokemon(String name, String spriteUrl){
        this.name = name;
        this.spriteUrl = spriteUrl;
    }

    public Pokemon(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpriteUrl() {
        return spriteUrl;
    }

    public void setSpriteUrl(String spriteUrl) {
        this.spriteUrl = spriteUrl;
    }
}
