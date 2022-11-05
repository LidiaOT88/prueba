package com.lidorttol.pruebamercadona.data.local.dbo.location

import androidx.room.Embedded
import androidx.room.Relation
import com.lidorttol.pruebamercadona.data.local.dbo.person.PersonDbo

data class LocationWithPersonDbo(
    @Embedded val location: LocationDbo,
    @Relation(
        parentColumn = "locationId",
        entityColumn = "personId",
    )
    val residents: List<PersonDbo>
)