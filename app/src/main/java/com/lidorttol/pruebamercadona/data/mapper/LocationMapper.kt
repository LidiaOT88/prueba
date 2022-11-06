package com.lidorttol.pruebamercadona.data.mapper

import com.lidorttol.pruebamercadona.data.bo.LocationBo
import com.lidorttol.pruebamercadona.data.bo.PersonBo
import com.lidorttol.pruebamercadona.data.getEntityId
import com.lidorttol.pruebamercadona.data.local.dbo.location.LocationDbo
import com.lidorttol.pruebamercadona.data.local.dbo.location.LocationWithPersonDbo
import com.lidorttol.pruebamercadona.data.remote.dto.LocationDto

fun LocationWithPersonDbo.dboToBo() = LocationBo(
    location.locationId,
    location.name,
    location.climate,
    location.terrain,
    location.surfaceWater,
    residents.map { it.dboToBo() }
)

fun LocationDbo.dboToBo() = LocationBo(
    locationId,
    name,
    climate,
    terrain,
    surfaceWater,
)

fun LocationDto.dtoToBo() = LocationBo(
    id,
    name,
    climate,
    terrain,
    surfaceWater,
    residents = residents.map { PersonBo(it.getEntityId()) }
)

/*
fun LocationBo.boToDbo(filmId: String) = LocationDbo(
    id,
    name,
    climate,
    terrain,
    surfaceWater,
    filmId
)
*/
