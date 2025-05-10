package ru.normno.mywebsite.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.*
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.8f),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Column {
                AsyncImage(
                    model = "https://avatars.githubusercontent.com/u/47896309?v=4",
                    contentDescription = null,
                )
                Text(
                    buildAnnotatedString {
                        withLink(
                            LinkAnnotation.Url(
                                "https://normno.ru/",
                                TextLinkStyles(style = SpanStyle(MaterialTheme.colorScheme.onSurface))
                            )
                        ) {
                            append("NORM")
                        }
                    }
                )
            }
        }
    }
}