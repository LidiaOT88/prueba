package com.lidorttol.pruebamercadona.data.local.dbo.vehicle

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.lidorttol.pruebamercadona.data.local.dbo.film.FilmCrossVehicleDbo
import com.lidorttol.pruebamercadona.data.local.dbo.film.FilmDbo

data class VehicleWithFilmsDbo(
    @Embedded val vehicle: VehicleDbo,
    @Relation(
        parentColumn = "vehicleId",
        entityColumn = "filmId",
        associateBy = Junction(FilmCrossVehicleDbo::class)
    )
    val films: List<FilmDbo>
)