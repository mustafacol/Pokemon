package com.mustafa.soostone_pokemon.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mustafa.soostone_pokemon.data.remote.dto.Pokemon
import com.mustafa.soostone_pokemon.presentation.pokemon_detail.PokemonDetailScreen
import com.mustafa.soostone_pokemon.presentation.pokemon_list.PokemonListScreen
import com.mustafa.soostone_pokemon.presentation.pokemon_list.PokemonListViewModel

@Composable
fun SoostonePokemonApp(
) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Route.PokemonListScreen.route) {
        composable(route = Route.PokemonListScreen.route) {
            val viewModel: PokemonListViewModel = hiltViewModel()
            val state by viewModel.state.collectAsStateWithLifecycle()
            PokemonListScreen(
                state = state,
                navigateToDetail = { pokemon ->
                    navigateToDetails(navController, pokemon)
                })
        }

        composable(route = Route.PokemonDetailScreen.route) {
            navController.previousBackStackEntry?.savedStateHandle?.get<Pokemon?>("pokemon")
                ?.let { pokemon ->
                    PokemonDetailScreen(
                        pokemon = pokemon,
                        navigateUp = { navController.navigateUp() })
                }


        }
    }
}

private fun navigateToDetails(navController: NavController, pokemon: Pokemon) {
    navController.currentBackStackEntry?.savedStateHandle?.set("pokemon", pokemon)
    navController.navigate(
        route = Route.PokemonDetailScreen.route
    )

}