package com.lidorttol.pruebamercadona.data.local.dbo.film

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.lidorttol.pruebamercadona.data.local.dbo.person.PersonDbo

data class FilmWithPersonDbo(
    @Embedded val film: FilmDbo,
    @Relation(
        parentColumn = "filmId",
        entityColumn = "personId",
        associateBy = Junction(FilmCrossPersonDbo::class)
    )
    val people: List<PersonDbo>
)