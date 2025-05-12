package com.creative.pokedex.service

import com.creative.pokedex.dto.PokemonDto
import com.creative.pokedex.model.Pokemon
import com.creative.pokedex.repository.PokemonRepository
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class PokemonService(private val repo: PokemonRepository) {
    fun listAll(limit: Int?, offset: Int?): List<Pokemon> {
        val all = repo.findAll()
        val from = offset ?: 0
        val to = (from + (limit ?: all.size)).coerceAtMost(all.size)
        return if (from < to) all.subList(from, to) else emptyList()
    }

    fun getById(id: Long): Pokemon? = repo.findById(id).orElse(null)

    fun create(p: Pokemon): Pokemon = repo.save(p)
}