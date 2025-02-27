package com.example.pokemon_generator.Controllers;

import com.example.pokemon_generator.Models.Pokemon;
import com.example.pokemon_generator.Services.PokemonService;
import org.springframework.web.bind.annotation.*;
import java.util.Random;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PostMapping("/generate")
    public Pokemon generatePokemon(@RequestParam String username) {
        return pokemonService.generatePokemon(username);
    }

    @GetMapping("/")
    public Pokemon getPokemon() {
        Random random = new Random();
        return pokemonService.generatePokemon(String.valueOf(random.nextInt(150) + 1));
    }

    @GetMapping("/{ID}")
    public Pokemon getPokemonByID(@PathVariable String ID) {
        return pokemonService.generatePokemon(ID);
    }
}
