package com.lidorttol.pruebamercadona.data.local.dbo.film

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.lidorttol.pruebamercadona.data.local.dbo.location.LocationDbo

data class FilmWithLocationDbo(
    @Embedded val film: FilmDbo,
    @Relation(
        parentColumn = "filmId",
        entityColumn = "locationId",
        associateBy = Junction(FilmCrossLocationDbo::class)
    )
    val locations: List<LocationDbo>
)