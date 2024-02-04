package com.mustafa.soostone_pokemon.data.remote

import com.mustafa.soostone_pokemon.data.remote.dto.Pokemon
import retrofit2.http.GET

interface PokemonApi {
    @GET("pokemon.json")
    suspend fun getPokemonList(): List<Pokemon>

}