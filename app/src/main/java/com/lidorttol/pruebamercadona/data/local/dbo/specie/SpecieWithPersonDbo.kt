package com.lidorttol.pruebamercadona.data.local.dbo.specie

import androidx.room.Embedded
import androidx.room.Relation
import com.lidorttol.pruebamercadona.data.local.dbo.person.PersonDbo

data class SpecieWithPersonDbo(
    @Embedded val specie: SpecieDbo,
    @Relation(
        parentColumn = "specieId",
        entityColumn = "personId",
    )
    val people: List<PersonDbo>
)