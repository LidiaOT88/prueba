package com.lidorttol.pruebamercadona.data.mapper

import com.lidorttol.pruebamercadona.data.bo.SpecieBo
import com.lidorttol.pruebamercadona.data.local.dbo.specie.SpecieDbo
import com.lidorttol.pruebamercadona.data.remote.dto.SpecieDto

fun SpecieDbo.dboToBo() = SpecieBo(
    specieId,
    name,
    classification,
    eyeColors,
    hairColors,
)

fun SpecieDto.dtoToBo() = SpecieBo(
    id,
    name,
    classification,
    eyeColors,
    hairColors,
)

/*
fun SpecieBo.boToDbo() = SpecieDbo(
    id,
    name,
    classification,
    eyeColors,
    hairColors
)*/
