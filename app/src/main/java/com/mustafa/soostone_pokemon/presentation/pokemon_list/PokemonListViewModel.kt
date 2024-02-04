package com.mustafa.soostone_pokemon.presentation.pokemon_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafa.soostone_pokemon.domain.use_case.GetPokemonListUseCase
import com.mustafa.soostone_pokemon.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {

    private val _pokemonListState = MutableStateFlow<PokemonListState>(PokemonListState.Loading)
    val state = _pokemonListState.asStateFlow()

    init {
        getPokemonList()
    }

    private fun getPokemonList() {
        viewModelScope.launch {
            _pokemonListState.update { PokemonListState.Loading }
            when (val resource = getPokemonListUseCase()) {
                is Resource.Success -> {
                    resource.data?.let { safeData ->
                        _pokemonListState.update {
                            PokemonListState.Success(safeData)
                        }
                    }
                }

                is Resource.Error -> {
                    _pokemonListState.update {
                        PokemonListState.Error(resource.message ?: "Something went wrong.")
                    }
                }
            }
        }
    }

}