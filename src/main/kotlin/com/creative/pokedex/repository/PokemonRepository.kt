package com.creative.pokedex.repository

import com.creative.pokedex.model.Pokemon
import org.springframework.data.jpa.repository.JpaRepository

interface PokemonRepository : JpaRepository<Pokemon, Long>