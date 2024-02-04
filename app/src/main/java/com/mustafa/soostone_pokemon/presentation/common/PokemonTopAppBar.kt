package com.mustafa.soostone_pokemon.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonTopAppBar(
    title: String,
    actionIcon: ImageVector? = null,
    navigateUp: () -> Unit? = {},
) {
    TopAppBar(modifier = Modifier.statusBarsPadding(),
        windowInsets = WindowInsets(left = 16.dp),
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
        title = {
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = title,
                color = MaterialTheme.colorScheme.onPrimary
            )

        },
        navigationIcon = {
            actionIcon?.let {
                Icon(
                    modifier = Modifier.clickable { navigateUp() },
                    imageVector = actionIcon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }

        })
}