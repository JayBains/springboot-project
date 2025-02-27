package com.example.pokemon_generator.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PokemonRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertGeneratedPokemon(int userId, String pokemonName, String pokemonImageUrl) {
        String sql = "INSERT INTO generated_cards (user_id, pokemon_name, pokemon_image_url) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, userId, pokemonName, pokemonImageUrl);
    }
}
