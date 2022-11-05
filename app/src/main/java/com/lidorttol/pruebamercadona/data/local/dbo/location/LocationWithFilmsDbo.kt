package com.lidorttol.pruebamercadona.data.local.dbo.location

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.lidorttol.pruebamercadona.data.local.dbo.film.FilmCrossLocationDbo
import com.lidorttol.pruebamercadona.data.local.dbo.film.FilmDbo

data class LocationWithFilmsDbo(
    @Embedded val location: LocationDbo,
    @Relation(
        parentColumn = "locationId",
        entityColumn = "filmId",
        associateBy = Junction(FilmCrossLocationDbo::class)
    )
    val films: List<FilmDbo>
)