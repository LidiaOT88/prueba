package com.lidorttol.pruebamercadona.data.mapper

import com.lidorttol.pruebamercadona.data.bo.PersonBo
import com.lidorttol.pruebamercadona.data.bo.SpecieBo
import com.lidorttol.pruebamercadona.data.bo.VehicleBo
import com.lidorttol.pruebamercadona.data.getEntityId
import com.lidorttol.pruebamercadona.data.local.dbo.vehicle.VehicleDbo
import com.lidorttol.pruebamercadona.data.remote.dto.VehicleDto

fun VehicleDbo.dboToBo() = VehicleBo(
    vehicleId,
    name,
    description,
    vehicleClass,
    length,
    PersonBo(vehiclePersonId ?: "")
)

fun VehicleDto.dtoToBo() = VehicleBo(
    id,
    name,
    description,
    vehicleClass,
    length,
    pilot = PersonBo(pilot.getEntityId()),
)

/*
fun VehicleBo.boToDbo() = VehicleDbo(
    id,
    name,
    description,
    vehicleClass,
    length,
    pilot
)*/
