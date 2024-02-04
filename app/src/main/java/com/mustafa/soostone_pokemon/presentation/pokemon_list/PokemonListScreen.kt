package com.mustafa.soostone_pokemon.presentation.pokemon_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mustafa.soostone_pokemon.data.remote.dto.Pokemon
import com.mustafa.soostone_pokemon.presentation.common.PokemonCard
import com.mustafa.soostone_pokemon.presentation.common.PokemonTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonListScreen(
    state: PokemonListState,
    navigateToDetail: (Pokemon) -> Unit
) {
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            PokemonTopAppBar(title = "Pokemon")
        }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            when (state) {
                is PokemonListState.Loading -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                }

                is PokemonListState.Error -> {

                }

                is PokemonListState.Success -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(
                            items = state.pokemonList,
                            key = { pokemon -> pokemon.id }
                        ) { item ->
                            PokemonCard(pokemon = item, onClick = navigateToDetail)
                        }

                    }
                }
            }

        }
    }

}