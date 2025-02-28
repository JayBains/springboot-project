package com.example.pokemon_generator.Controllers;

import com.example.pokemon_generator.Models.Pokemon;
import com.example.pokemon_generator.Services.PokemonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/pokemon")
@CrossOrigin(origins = "http://localhost:5173")
public class PokemonController {
    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    // POST: Generate and save Pokemon for a user
    @PostMapping("/generate")
    public Pokemon generatePokemon(@RequestBody Map<String, String> requestBody) {
        String username = requestBody.get("userName");
        return pokemonService.generatePokemon(username);
    }

    // GET: Retrieve all users and their generated Pokemon
    @GetMapping("/all")
    public List<Map<String, Object>> getAllUsersWithPokemon() {
        return pokemonService.getUsersWithPokemon();
    }

    // GET: Generate a random Pokemon (for testing purposes)
    @GetMapping("/")
    public Pokemon getPokemon() {
        Random random = new Random();
        return pokemonService.generatePokemon(String.valueOf(random.nextInt(150) + 1));
    }

    // GET: Retrieve Pokemon by ID (for testing purposes)
    @GetMapping("/{ID}")
    public Pokemon getPokemonByID(@PathVariable String ID) {
        return pokemonService.generatePokemon(ID);
    }

    // DELETE: Remove all Pokemon records for a user
    @DeleteMapping("/delete")
    public String deletePokemon(@RequestParam String username) {
        pokemonService.deletePokemonByUser(username);
        return "All Pokémon records deleted for user: " + username;
    }

    // DELETE: Remove a specific Pokemon for a user
    @DeleteMapping("/delete/specific")
    public String deleteSpecificPokemon(@RequestParam String username, @RequestParam String pokemonName) {
        pokemonService.deleteSpecificPokemon(username, pokemonName);
        return "Deleted " + pokemonName + " for user: " + username;
    }
}
