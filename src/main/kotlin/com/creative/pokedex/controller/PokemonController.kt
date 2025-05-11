package com.creative.pokedex.controller

import com.creative.pokedex.model.Pokemon
import com.creative.pokedex.service.PokemonService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/pokemon")
class PokemonController(private val service: PokemonService) {

    @GetMapping
    fun list(
        @RequestParam(required = false) limit: Int?,
        @RequestParam(required = false) offset: Int?
    ): List<Pokemon> = service.listAll(limit, offset)

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): ResponseEntity<Pokemon> =
        service.getById(id)?.let { ResponseEntity.ok(it) }
            ?: ResponseEntity.notFound().build()

    @PostMapping
    fun create(@RequestBody pokemon: Pokemon): ResponseEntity<Pokemon> {
        val saved = service.create(pokemon)
        return ResponseEntity.ok(saved)
    }
}