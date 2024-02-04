package com.mustafa.soostone_pokemon.presentation.pokemon_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mustafa.soostone_pokemon.data.remote.dto.Pokemon
import com.mustafa.soostone_pokemon.presentation.common.PokemonCard

@Composable
fun PokemonListScreen(
    state: PokemonListState,
    navigateToDetail: (Pokemon) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        when (state) {
            is PokemonListState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            is PokemonListState.Error -> {

            }

            is PokemonListState.Success -> {
                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    itemsIndexed(state.pokemonList) { index, item ->
                        PokemonCard(pokemon = item, onClick = navigateToDetail)
                    }
                }
            }
        }

    }
}