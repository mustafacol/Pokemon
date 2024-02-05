package com.mustafa.soostone_pokemon.domain.use_case

import com.mustafa.soostone_pokemon.data.remote.dto.Pokemon
import com.mustafa.soostone_pokemon.domain.repository.PokemonRepository
import com.mustafa.soostone_pokemon.domain.util.Resource
import java.net.UnknownHostException
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(): Resource<List<Pokemon>> {
        return try {
            val response = pokemonRepository.getPokemonList()
            Resource.Success(response)
        } catch (throwable: UnknownHostException) {
            Resource.Error("Please check internet connection.")
        } catch (throwable: Throwable) {
            Resource.Error(throwable.message ?: "Something went wrong")
        }
    }
}