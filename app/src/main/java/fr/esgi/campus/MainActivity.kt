package fr.esgi.campus

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import fr.esgi.campus.data.Event.sampleEvents
import fr.esgi.campus.ui.theme.CampusTheme
import fr.esgi.campus.ui.theme.EventListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampusTheme {
                EventListScreen(
                    events = sampleEvents,
                    onEventClick = { event ->
                        Log.d("CampusApp", "Clic sur la carte : ${event.title}")
                    },
                    onBook = { event ->
                        Log.d("CampusApp", "Réservation pour : ${event.title}")
                    }
                )
            }
        }
    }
}