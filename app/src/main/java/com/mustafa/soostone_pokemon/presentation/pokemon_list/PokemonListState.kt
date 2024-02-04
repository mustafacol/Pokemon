package com.mustafa.soostone_pokemon.presentation.pokemon_list

import com.mustafa.soostone_pokemon.data.remote.dto.Pokemon

sealed class PokemonListState {
    object Loading : PokemonListState()
    data class Success(val pokemonList: List<Pokemon>) : PokemonListState()
    data class Error(val errorMessage: String) : PokemonListState()
}
