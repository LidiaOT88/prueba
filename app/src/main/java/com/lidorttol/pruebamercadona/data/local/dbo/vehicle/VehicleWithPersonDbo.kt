package com.lidorttol.pruebamercadona.data.local.dbo.vehicle

import androidx.room.Embedded
import androidx.room.Relation
import com.lidorttol.pruebamercadona.data.local.dbo.person.PersonDbo

data class VehicleWithPersonDbo(
    @Embedded val vehicle: VehicleDbo,
    @Relation(
         parentColumn = "vehicleId",
         entityColumn = "pilot"
    )
    val pilot: PersonDbo
)