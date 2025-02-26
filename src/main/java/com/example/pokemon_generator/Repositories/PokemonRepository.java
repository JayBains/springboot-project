package com.example.pokemon_generator.Repositories;

import com.example.pokemon_generator.Models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long>{
}
