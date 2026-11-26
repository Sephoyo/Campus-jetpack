package fr.esgi.campus.data.Event

data class Event(
    val id: Int,
    val title: String,
    val category: String,
    val location: String?,
    val capacity: Int
)

fun Event.displayLocation(): String = location ?: "Lieu à confirmer"