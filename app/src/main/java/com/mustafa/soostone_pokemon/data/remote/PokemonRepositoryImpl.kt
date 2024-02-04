package com.mustafa.soostone_pokemon.data.remote

import com.mustafa.soostone_pokemon.data.remote.dto.Pokemon
import com.mustafa.soostone_pokemon.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val api: PokemonApi
) : PokemonRepository {
    override suspend fun getPokemonList(): List<Pokemon> {
        return api.getPokemonList()
    }
}