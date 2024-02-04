package com.mustafa.soostone_pokemon.presentation.navigation

sealed class Route(
    val route: String,
) {
    object PokemonListScreen : Route(route = "pokemonListScreen")
    object PokemonDetailScreen : Route(route = "pokemonDetailScreen")
}
