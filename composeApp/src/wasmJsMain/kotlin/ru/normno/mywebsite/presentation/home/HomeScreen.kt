package ru.normno.mywebsite.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.BrowseGallery
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Sports
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.*
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import mywebsite.composeapp.generated.resources.Res
import mywebsite.composeapp.generated.resources.bezborodov_s_m
import org.jetbrains.compose.resources.imageResource

@Composable
fun HomeScreen() {
    val uriHandler = LocalUriHandler.current
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
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
                Image(
                    bitmap = imageResource(Res.drawable.bezborodov_s_m),
                    contentDescription = null,
                    modifier = Modifier
                        .size(256.dp),
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
                    },
                    color = MaterialTheme.colorScheme.onBackground,
                )
            }
            FlowRow(
                modifier = Modifier
                    .weight(1f),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                SocialItems.entries.forEach { item ->
                    AssistChip(
                        onClick = {
                            uriHandler.openUri(item.url)
                        },
                        label = {
                            Text(
                                text = item.name,
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = null,
                            )
                        }
                    )
                }
            }
        }
    }
}

enum class SocialItems(name: String, val url: String, val icon: ImageVector) {
    YouTube("YouTube", "https://www.youtube.com/@normno", Icons.Default.Videocam),
    Telegram("Telegram", "https://normno.t.me", Icons.AutoMirrored.Filled.Message),
    Strava("Strava", "https://www.strava.com/athletes/66466431", Icons.Default.Sports),
    GitHub("GitHub", "https://github.com/NORMss", Icons.Default.Code),
    Instagram("Instagram", "https://www.instagram.com/norm_no_/", Icons.Default.BrowseGallery),
}