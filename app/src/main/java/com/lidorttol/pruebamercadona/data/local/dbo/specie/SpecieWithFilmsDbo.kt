package com.lidorttol.pruebamercadona.data.local.dbo.specie

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.lidorttol.pruebamercadona.data.local.dbo.film.FilmCrossSpecieDbo
import com.lidorttol.pruebamercadona.data.local.dbo.film.FilmDbo

data class SpecieWithFilmsDbo(
    @Embedded val specie: SpecieDbo,
    @Relation(
        parentColumn = "specieId",
        entityColumn = "filmId",
        associateBy = Junction(FilmCrossSpecieDbo::class)
    )
    val films: List<FilmDbo>
)