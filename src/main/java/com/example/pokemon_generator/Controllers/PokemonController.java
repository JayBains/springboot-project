package com.example.pokemon_generator.Controllers;

import com.example.pokemon_generator.Models.Pokemon;
import com.example.pokemon_generator.Services.PokemonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/")
    public Pokemon getPokemon() {
        Random random = new Random();
        return pokemonService.getPokemonByName(String.valueOf(random.nextInt(150) + 1));
    }

    @GetMapping("/{ID}")
    public Pokemon getPokemonByID(@PathVariable String ID) {
        return pokemonService.getPokemonByName(ID);
    }
}
