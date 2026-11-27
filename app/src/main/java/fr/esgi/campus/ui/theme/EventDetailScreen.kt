package fr.esgi.campus.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import fr.esgi.campus.R
import fr.esgi.campus.data.Event.Event

// Stateless : tout arrive en paramètre, l'écran ne garde aucun état et ne décide rien.
@Composable
fun EventDetailScreen(
    event: Event,
    onBook: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // la Column défile si le texte est long
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.event_banner),
            contentDescription = null, // image décorative : TalkBack l'ignore
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
        )

        Text(
            text = event.title,
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = event.location ?: stringResource(R.string.location_to_confirm),
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = if (event.capacity > 0) {
                pluralStringResource(R.plurals.seats_available, event.capacity, event.capacity)
            } else {
                stringResource(R.string.event_full)
            },
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = event.description.ifBlank { stringResource(R.string.no_description) },
            style = MaterialTheme.typography.bodyMedium
        )

        Button(
            onClick = onBook,
            enabled = event.capacity > 0,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Complet : un mot, pas seulement le bouton grisé (rien ne repose sur la couleur seule)
            Text(
                stringResource(
                    if (event.capacity > 0) R.string.action_book else R.string.event_full
                )
            )
        }
    }
}

private val previewEvent = Event(
    id = 2,
    title = "Conférence IA",
    category = "Tech",
    location = "Lille",
    capacity = 42,
    description = "Une après-midi pour découvrir comment les modèles de langage " +
        "sont entraînés, ce qu'ils savent faire et leurs limites. " +
        "Démonstrations en direct, puis questions-réponses avec les intervenants. " +
        "Ouvert à tous les étudiants, aucune connaissance préalable requise."
)

@PreviewLightDark
@PreviewFontScale
@PreviewScreenSizes
@Composable
fun EventDetailScreenPreview() {
    CampusTheme {
        Surface {
            EventDetailScreen(event = previewEvent, onBook = {})
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventDetailScreenSansLieuPreview() {
    CampusTheme {
        Surface {
            EventDetailScreen(
                event = previewEvent.copy(location = null, capacity = 1, description = ""),
                onBook = {}
            )
        }
    }
}
