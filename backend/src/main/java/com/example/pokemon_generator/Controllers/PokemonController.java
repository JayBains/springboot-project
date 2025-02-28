package com.example.pokemon_generator.Controllers;

import com.example.pokemon_generator.Models.Pokemon;
import com.example.pokemon_generator.Services.PokemonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Random;

@CrossOrigin(origins = "http://localhost:5173")
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

    // Endpoint to get all users and their generated Pokémon
    @GetMapping("/all")
    public List<Map<String, Object>> getUsersWithPokemon() {
        return pokemonService.getUsersWithPokemon();
    }

    @DeleteMapping("/delete")
    public String deletePokemon(@RequestParam String username) {
        pokemonService.deletePokemonByUser(username);
        return "All Pokémon records deleted for user: " + username;
    }

    @DeleteMapping("/delete/specific")
    public String deleteSpecificPokemon(@RequestParam String username, @RequestParam String pokemonName) {
        pokemonService.deleteSpecificPokemon(username, pokemonName);
        return "Deleted " + pokemonName + " for user: " + username;
    }


}
