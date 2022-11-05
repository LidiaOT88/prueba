package com.lidorttol.pruebamercadona.data.local.dbo.film

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.lidorttol.pruebamercadona.data.local.dbo.vehicle.VehicleDbo

data class FilmWithVehicleDbo(
    @Embedded val film: FilmDbo,
    @Relation(
        parentColumn = "filmId",
        entityColumn = "vehicleId",
        associateBy = Junction(FilmCrossVehicleDbo::class)
    )
    val vehicles: List<VehicleDbo>
)