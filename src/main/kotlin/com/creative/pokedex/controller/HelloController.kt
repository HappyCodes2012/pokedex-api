package com.creative.pokedex.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

data class Greeting(val message: String)
@RestController
@RequestMapping("/api")
class HelloController {
    @GetMapping("/hello")
    fun hello(): Greeting = Greeting("Hello world")
}