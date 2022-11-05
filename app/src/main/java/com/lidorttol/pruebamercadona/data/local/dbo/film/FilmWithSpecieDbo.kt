package com.lidorttol.pruebamercadona.data.local.dbo.film

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.lidorttol.pruebamercadona.data.local.dbo.specie.SpecieDbo

data class FilmWithSpecieDbo(
    @Embedded val film: FilmDbo,
    @Relation(
        parentColumn = "filmId",
        entityColumn = "specieId",
        associateBy = Junction(FilmCrossSpecieDbo::class)
    )
    val species: List<SpecieDbo>
)