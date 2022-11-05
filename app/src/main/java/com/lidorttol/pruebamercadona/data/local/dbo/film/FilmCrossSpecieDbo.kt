package com.lidorttol.pruebamercadona.data.local.dbo.film

import androidx.room.Entity

@Entity(primaryKeys = ["filmId", "specieId"])
data class FilmCrossSpecieDbo(
    val filmId: String,
    val specieId: String,
)
