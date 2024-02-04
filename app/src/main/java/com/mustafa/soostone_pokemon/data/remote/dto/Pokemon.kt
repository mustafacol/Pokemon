package com.mustafa.soostone_pokemon.data.remote.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val description: String,
    val id: Int,
    val imageUrl: String,
    val name: String
) : Parcelable