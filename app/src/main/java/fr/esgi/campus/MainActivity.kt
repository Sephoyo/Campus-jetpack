package fr.esgi.campus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.esgi.campus.ui.theme.CampusTheme
import android.util.Log

private const val TAG = "Campus"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Étape 1 :Initializer type mismatch: expected 'Int', actual 'String'
        // Étape 2 : erreur d'exécution (runtime) — l'app s'installe puis crashe au lancement
        // Logcat : java.lang.NumberFormatException: For input string: "douze" (MainActivity.kt:20)

        val capacity = "douze".toIntOrNull() ?: 0
        Log.d(TAG, "Places : $capacity")
        enableEdgeToEdge()
        setContent {
            CampusTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CampusTheme {
        Greeting("Android")
    }
}