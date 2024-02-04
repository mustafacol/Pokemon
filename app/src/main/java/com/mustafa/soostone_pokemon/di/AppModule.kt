package com.mustafa.soostone_pokemon.di

import com.mustafa.soostone_pokemon.data.remote.PokemonApi
import com.mustafa.soostone_pokemon.data.remote.PokemonRepositoryImpl
import com.mustafa.soostone_pokemon.domain.repository.PokemonRepository
import com.mustafa.soostone_pokemon.domain.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .build()
    }

    @Provides
    @Singleton
    fun providePokemonApi(client: OkHttpClient): PokemonApi {
        return Retrofit
            .Builder()
            .client(client)
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonApi::class.java)

    }

    @Provides
    @Singleton
    fun providePokemonRepository(
        pokemonApi: PokemonApi
    ): PokemonRepository {
        return PokemonRepositoryImpl(pokemonApi)
    }


}