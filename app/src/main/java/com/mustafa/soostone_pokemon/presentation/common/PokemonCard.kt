package com.mustafa.soostone_pokemon.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mustafa.soostone_pokemon.data.remote.dto.Pokemon
import com.mustafa.soostone_pokemon.ui.theme.SoostonePokemonTheme

@Composable
fun PokemonCard(
    pokemon: Pokemon,
    onClick: (Pokemon) -> Unit
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable { onClick(pokemon) }) {
        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 4.dp)) {
            AsyncImage(
                modifier = Modifier.size(100.dp),
                model = pokemon.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Column {
                Text(text = pokemon.name, style = MaterialTheme.typography.titleMedium)
                Text(
                    text = pokemon.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview
@Composable
fun PokemonCardPreview() {
    SoostonePokemonTheme {
        PokemonCard(
            Pokemon(
                "Lorem ipsum di amet",
                25,
                "https://i.pinimg.com/736x/dc/ab/b7/dcabb7fbb2f763d680d20a3d228cc6f9.jpg",
                "Pikachu"
            )
        ) {

        }
    }

}