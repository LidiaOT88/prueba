package com.lidorttol.pruebamercadona.data.local.dbo.film

import androidx.room.Entity

@Entity(primaryKeys = ["filmId", "personId"])
data class FilmCrossPersonDbo(
    val filmId: String,
    val personId: String,
)
