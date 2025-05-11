package ru.normno.mywebsite.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.*
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import mywebsite.composeapp.generated.resources.Res
import mywebsite.composeapp.generated.resources.compose_multiplatform

@Composable
fun HomeScreen() {
    val uriHandler = LocalUriHandler.current
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
                    model = Res.drawable.compose_multiplatform,
                    contentDescription = null,
                    modifier = Modifier
                        .size(256.dp),
                    placeholder = ColorPainter(Color.Red),
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
            AssistChip(
                onClick = {
                    uriHandler.openUri("https://www.youtube.com/@normno")
                },
                label = {
                    Text(
                        text = "YouTube"
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Videocam,
                        contentDescription = null,
                    )
                }
            )
            AssistChip(
                onClick = {
                    uriHandler.openUri("https://normno.t.me")
                },
                label = {
                    Text(
                        text = "YouTube"
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Message,
                        contentDescription = null,
                    )
                }
            )
            AssistChip(
                onClick = {
                    uriHandler.openUri("https://www.youtube.com/@normno")
                },
                label = {
                    Text(
                        text = "YouTube"
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Videocam,
                        contentDescription = null,
                    )
                }
            )

        }
    }
}