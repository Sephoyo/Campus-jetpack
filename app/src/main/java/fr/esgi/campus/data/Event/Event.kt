package fr.esgi.campus.data.Event

data class Event(
    val id: Int,
    val title: String,
    val category: String,
    val location: String?, // Nullable pour gérer l'événement sans lieu
    val capacity: Int,
    val description: String = "" // valeur par défaut : les 5 événements compilent toujours
)

val sampleEvents = listOf(
    Event(1, "3x3 Basket", "Sport", "Calais", 150),
    Event(2, "Conférence IA", "Tech", "Lille", 0), // Événement complet (capacity = 0)
    Event(3, "Soirée Jeux de Société", "Détente", null, 30), // Événement sans lieu
    Event(4, "Atelier CV & LinkedIn", "Carrière", "Dunkerque", 25),
    Event(5, "Tournoi E-Sport", "Gaming", "Boulogne", 64)
)

fun Event.displayLocation(): String = location ?: "Lieu à confirmer"