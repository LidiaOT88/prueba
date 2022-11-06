package com.lidorttol.pruebamercadona.data.local.dbo.film

import androidx.room.Embedded
import androidx.room.Relation
import com.lidorttol.pruebamercadona.data.local.dbo.location.LocationDbo

data class FilmWithLocationDbo(
    @Embedded val film: FilmDbo,
    @Relation(
          parentColumn = "filmId",
          entityColumn = "locationFilmId"
    )
    val locations: List<LocationDbo>
)