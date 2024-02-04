package com.mustafa.soostone_pokemon.domain.use_case

import com.mustafa.soostone_pokemon.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    operator fun invoke() {

    }
}