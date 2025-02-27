package com.example.pokemon_generator.Services;

import com.example.pokemon_generator.Models.Pokemon;
import com.example.pokemon_generator.Repositories.PokemonRepository;
import com.example.pokemon_generator.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class PokemonService {

    private static final String POKEAPI_URL = "https://pokeapi.co/api/v2/pokemon/";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PokemonRepository pokemonRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    public Pokemon generatePokemon(String username) {
        // Generates a random Pokémon ID (1-898)
        int randomId = (int) (Math.random() * 898) + 1;

        // Fetches Pokemon data from the PokeAPI
        String url = POKEAPI_URL + randomId;
        ResponseEntity<Map> responseEntity = restTemplate.getForEntity(url, Map.class);
        Map pokemonData = responseEntity.getBody();

        // Extracts Pokemon data
        String pokemonName = (String) pokemonData.get("name");
        String pokemonImageUrl = (String) ((Map<String, Object>) pokemonData.get("sprites")).get("front_default");

        // Stores in the database
        userRepository.insertUser(username);
        int userId = userRepository.getUserIdByUsername(username);
        pokemonRepository.insertGeneratedPokemon(userId, pokemonName, pokemonImageUrl);

        // Returns the Pokemon object
        return new Pokemon(pokemonName, pokemonImageUrl);
    }
}



// Commented out original code in case we need to revert
//package com.example.pokemon_generator.Services;
//
//import com.example.pokemon_generator.Models.Pokemon;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Map;
//
//@Service
//public class PokemonService {
//
//    RestTemplate restTemplate = new RestTemplate();
//
//    public Pokemon getPokemonByName(String name) {
//        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
//
//        // Get the full response
//        ResponseEntity<Map> responseEntity = restTemplate.getForEntity(url, Map.class);
//        Map pokemonData = responseEntity.getBody();
//
//        // Extract only what we need
//        Pokemon simplePokemon = new Pokemon();
//        simplePokemon.setName((String) pokemonData.get("name"));
//
//        // Extract the front_default sprite URL
//        Map<String, Object> sprites = (Map<String, Object>) pokemonData.get("sprites");
//        simplePokemon.setSpriteUrl((String) sprites.get("front_default"));
//
//        return simplePokemon;
//    }
//}