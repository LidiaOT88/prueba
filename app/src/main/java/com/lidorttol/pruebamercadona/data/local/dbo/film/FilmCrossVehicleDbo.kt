package com.lidorttol.pruebamercadona.data.local.dbo.film

import androidx.room.Entity

@Entity(primaryKeys = ["filmId", "vehicleId"])
data class FilmCrossVehicleDbo(
    val filmId: String,
    val vehicleId: String,
)
