package com.creative.pokedex.dto

data class PokemonDto(
    val id: Long? = null,
    val name: String,
    val type: String,
    val weaknesses: List<String>,
    val strengths: List<String>,
    val weight: Double,
    val height: Double,
    val size: String,
    val evolutions: List<Long> = emptyList()
)