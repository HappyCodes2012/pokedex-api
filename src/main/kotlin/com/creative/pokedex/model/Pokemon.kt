package com.creative.pokedex.model

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "pokemon")
data class Pokemon(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, unique = true)
    val name: String,

    @Column(nullable = false)
    val type: String,

    @ElementCollection
    @CollectionTable(name = "pokemon_weaknesses", joinColumns = [JoinColumn("pokemon_id")])
    @Column(name = "weakness")
    val weaknesses: List<String> = emptyList(),

    @ElementCollection
    @CollectionTable(name = "pokemon_strengths", joinColumns = [JoinColumn("pokemon_id")])
    @Column(name = "strength")
    val strengths: List<String> = emptyList(),

    @Column(nullable = false, precision = 5, scale = 2)
    val weight: BigDecimal,

    @Column(nullable = false, precision = 4, scale = 2)
    val height: BigDecimal,

    @Column(nullable = false)
    val size: String,

    @ManyToMany
    @JoinTable(
        name = "pokemon_evolutions",
        joinColumns = [JoinColumn("pokemon_id")],
        inverseJoinColumns = [JoinColumn("evolution_id")]
    )
    val evolutions: List<Pokemon> = emptyList()
)