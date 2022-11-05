package com.lidorttol.pruebamercadona.data.local.dbo.film

import androidx.room.Entity

@Entity(primaryKeys = ["filmId", "locationId"])
data class FilmCrossLocationDbo(
    val filmId: String,
    val locationId: String,
)