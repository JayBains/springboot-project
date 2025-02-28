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

    // Generates a random Pokemon for the user and saves it
    public Pokemon generatePokemon(String username) {
        int randomId = (int) (Math.random() * 150) + 1;
        String url = POKEAPI_URL + randomId;

        // Fetches Pokemon data
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        Map data = response.getBody();

        // Extracts Pokemon data we want
        String pokemonName = (String) data.get("name");
        String pokemonImageUrl = (String) ((Map<String, Object>) data.get("sprites")).get("front_default");

        // Stores user & Pokemon in SQL DB
        userRepository.insertUser(username);
        int userId = userRepository.getUserIdByUsername(username);
        pokemonRepository.insertGeneratedPokemon(userId, pokemonName, pokemonImageUrl);

        return new Pokemon(pokemonName, pokemonImageUrl);
    }

    // Returns all users and their Pokémon
    public List<Map<String, Object>> getUsersWithPokemon() {
        return jdbcTemplate.queryForList(
                "SELECT u.username, p.pokemon_name, p.pokemon_image_url " +
                        "FROM users u " +
                        "JOIN generated_cards p ON u.id = p.user_id"
        );
    }

    // Deletes all Pokemon records for a user
    public void deletePokemonByUser(String username) {
        jdbcTemplate.update(
                "DELETE FROM generated_cards WHERE user_id = (SELECT id FROM users WHERE username = ?)",
                username
        );
    }

    // Deletes a specific Pokemon record for a user
    public void deleteSpecificPokemon(String username, String pokemonName) {
        jdbcTemplate.update(
                "DELETE FROM generated_cards WHERE user_id = (SELECT id FROM users WHERE username = ?) " +
                        "AND pokemon_name = ?",
                username, pokemonName
        );
    }
}
