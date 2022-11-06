package com.lidorttol.pruebamercadona.data.local.dbo.person

import androidx.room.Embedded
import androidx.room.Relation
import com.lidorttol.pruebamercadona.data.local.dbo.specie.SpecieDbo

data class PersonAndSpecieDbo(
    @Embedded val person: PersonDbo,
    @Relation(
         parentColumn = "personSpecieId",
         entityColumn = "specieId"
    )
    val specie: SpecieDbo
)