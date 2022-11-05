package com.lidorttol.pruebamercadona.data.local.dbo.person

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.lidorttol.pruebamercadona.data.local.dbo.film.FilmCrossPersonDbo
import com.lidorttol.pruebamercadona.data.local.dbo.film.FilmDbo

data class PersonWithFilmsDbo(
    @Embedded val person: PersonDbo,
    @Relation(
        parentColumn = "personId",
        entityColumn = "filmId",
        associateBy = Junction(FilmCrossPersonDbo::class)
    )
    val films: List<FilmDbo>
)