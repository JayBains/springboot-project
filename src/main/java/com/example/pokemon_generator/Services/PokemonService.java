package com.example.pokemon_generator.Services;

import com.example.pokemon_generator.Models.Pokemon;
import com.example.pokemon_generator.Repositories.PokemonRepository;
import com.example.pokemon_generator.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class PokemonService {

    private static final String POKEAPI_URL = "https://pokeapi.co/api/v2/pokemon/";
    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Pokemon generatePokemon(String username) {

        int randomId = (int) (Math.random() * 150) + 1;
        String url = POKEAPI_URL + randomId;

        // Fetches Pokemon data from the PokeAPI
        ResponseEntity<Map> responseEntity = restTemplate.getForEntity(url, Map.class);
        Map pokemonData = responseEntity.getBody();

        // Extracts Pokemon data
        String pokemonName = (String) pokemonData.get("name");
        String pokemonImageUrl = (String) ((Map<String, Object>) pokemonData.get("sprites")).get("front_default");

        userRepository.insertUser(username);
        int userId = userRepository.getUserIdByUsername(username);
        pokemonRepository.insertGeneratedPokemon(userId, pokemonName, pokemonImageUrl);

        return new Pokemon(pokemonName, pokemonImageUrl);
    }

    // Method to get users and their Pokemon
    public List<Map<String, Object>> getUsersWithPokemon() {
        String query = "SELECT u.username, p.pokemon_name, p.pokemon_image_url " +
                "FROM users u " +
                "JOIN generated_cards p ON u.id = p.user_id";

        return jdbcTemplate.queryForList(query);
    }

    public void deletePokemonByUser(String username) {
        String query = "DELETE FROM generated_cards WHERE user_id = (SELECT id FROM users WHERE username = ?)";
        jdbcTemplate.update(query, username);
    }

    public void deleteSpecificPokemon(String username, String pokemonName) {
        String query = "DELETE FROM generated_cards WHERE user_id = (SELECT id FROM users WHERE username = ?) AND pokemon_name = ?";
        jdbcTemplate.update(query, username, pokemonName);
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