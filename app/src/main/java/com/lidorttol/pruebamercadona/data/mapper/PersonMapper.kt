package com.lidorttol.pruebamercadona.data.mapper

import com.lidorttol.pruebamercadona.data.bo.FilmBo
import com.lidorttol.pruebamercadona.data.bo.PersonBo
import com.lidorttol.pruebamercadona.data.bo.SpecieBo
import com.lidorttol.pruebamercadona.data.getEntityId
import com.lidorttol.pruebamercadona.data.local.dbo.person.PersonDbo
import com.lidorttol.pruebamercadona.data.remote.dto.PersonDto

fun PersonDbo.dboToBo() = PersonBo(
    personId,
    name,
    gender,
    age,
    eyeColor,
    hairColor,
)

fun PersonDto.dtoToBo() = PersonBo(
    id,
    name,
    gender,
    age,
    eyeColor,
    hairColor,
    specie = SpecieBo(specie.getEntityId())
)

/*
fun PersonBo.boToDbo(filmId: String) = PersonDbo(
    id,
    name,
    gender,
    age,
    eyeColor,
    hairColor,
    locationId,
    specieId
)

*/
