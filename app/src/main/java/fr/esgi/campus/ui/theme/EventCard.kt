package fr.esgi.campus.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.esgi.campus.data.Event.Event
import fr.esgi.campus.data.Event.displayLocation

@Composable
fun EventCard(
    event: Event,
    onClick: () -> Unit,
    onBook: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(onClick = onClick, modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            // Étape 1 : titre et catégorie sur une ligne
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = event.title,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = event.category,
                    style = MaterialTheme.typography.labelLarge
                )
            }

            // Étape 2 : le lieu en dessous, ou « Lieu à confirmer » s'il est null
            Text(
                text = event.displayLocation(),
                style = MaterialTheme.typography.bodyMedium
            )

            // Étape 3 : actions alignées à droite (« Voir » et « Réserver »)
            Row(
                modifier = Modifier.align(Alignment.End),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(onClick = onClick) {
                    Text("Voir")
                }
                Button(
                    onClick = onBook,
                    enabled = event.capacity > 0 // Grisé si capacity == 0
                ) {
                    Text("Réserver")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventCardTitreLongPreview() {
    CampusTheme {
        EventCard(
            event = Event(
                id = 1,
                title = "Conférence sur l'avenir du développement mobile Android avec Jetpack Compose",
                category = "Pro",
                location = "Amphithéâtre A",
                capacity = 150
            ),
            onClick = {},
            onBook = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EventCardSansLieuPreview() {
    CampusTheme {
        EventCard(
            event = Event(
                id = 5,
                title = "Répétition de batterie",
                category = "Perso",
                location = null,
                capacity = 2
            ),
            onClick = {},
            onBook = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EventCardCompletPreview() {
    CampusTheme {
        EventCard(
            event = Event(
                id = 2,
                title = "Concert de fin d'année",
                category = "Culture",
                location = "Grande Salle",
                capacity = 0
            ),
            onClick = {},
            onBook = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}