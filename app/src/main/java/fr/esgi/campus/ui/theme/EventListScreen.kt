package fr.esgi.campus.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import fr.esgi.campus.R
import fr.esgi.campus.data.Event.Event
import fr.esgi.campus.data.Event.sampleEvents

// La liste de MainActivity, sortie dans un composable pour pouvoir la prévisualiser.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventListScreen(
    events: List<Event>,
    onEventClick: (Event) -> Unit,
    onBook: (Event) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = { Text(stringResource(R.string.app_name)) })
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(events, key = { it.id }) { event ->
                EventCard(
                    event = event,
                    onClick = { onEventClick(event) },
                    onBook = { onBook(event) }
                )
            }
        }
    }
}

@PreviewLightDark
@PreviewFontScale
@PreviewScreenSizes
@Composable
fun EventListScreenPreview() {
    CampusTheme {
        EventListScreen(events = sampleEvents, onEventClick = {}, onBook = {})
    }
}
