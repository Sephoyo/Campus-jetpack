package fr.esgi.campus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.esgi.campus.ui.theme.CampusTheme
import android.util.Log
import androidx.compose.ui.unit.dp
import fr.esgi.campus.data.Event.Event
import fr.esgi.campus.ui.theme.EventCard

private const val TAG = "Campus"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Étape 1 :Initializer type mismatch: expected 'Int', actual 'String'
        // Étape 2 : erreur d'exécution (runtime) l'app s'installe puis crashe au lancement
        // Logcat : java.lang.NumberFormatException: For input string: "douze" (MainActivity.kt:20)

        val capacity = "douze".toIntOrNull() ?: 0
        Log.d(TAG, "Places : $capacity")
        enableEdgeToEdge()
        setContent {
            CampusTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val event = Event(1, "3x3 Basket", "Sport", "Calais", 150)
                    EventCard(
                        event = event,
                        onClick = { Log.d(TAG, "Clic sur ${event.title}") },
                        modifier = Modifier.padding(innerPadding).padding(16.dp)
                    )
                }
            }
        }
    }
}

