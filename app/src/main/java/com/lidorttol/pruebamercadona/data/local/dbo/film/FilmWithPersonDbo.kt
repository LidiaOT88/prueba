package com.lidorttol.pruebamercadona.data.local.dbo.film

import androidx.room.Embedded
import androidx.room.Relation
import com.lidorttol.pruebamercadona.data.local.dbo.person.PersonDbo

data class FilmWithPersonDbo(
    @Embedded val film: FilmDbo,
    @Relation(
          parentColumn = "filmId",
          entityColumn = "personFilmId"
    )
    val people: List<PersonDbo>
)