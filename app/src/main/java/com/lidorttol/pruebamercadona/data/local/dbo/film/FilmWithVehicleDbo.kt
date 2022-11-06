package com.lidorttol.pruebamercadona.data.local.dbo.film

import androidx.room.Embedded
import androidx.room.Relation
import com.lidorttol.pruebamercadona.data.local.dbo.vehicle.VehicleDbo

data class FilmWithVehicleDbo(
    @Embedded val film: FilmDbo,
    @Relation(
          parentColumn = "filmId",
          entityColumn = "vehicleFilmId"
    )
    val vehicles: List<VehicleDbo>
)