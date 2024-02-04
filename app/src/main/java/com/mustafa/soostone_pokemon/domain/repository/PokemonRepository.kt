package com.mustafa.soostone_pokemon.domain.repository

import com.mustafa.soostone_pokemon.data.remote.dto.Pokemon

interface PokemonRepository {
    suspend fun getPokemonList(): List<Pokemon>
}