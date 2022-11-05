package com.lidorttol.pruebamercadona.data.local

import com.lidorttol.pruebamercadona.data.local.dao.*
import javax.inject.Inject
import javax.inject.Singleton

interface LocalDatasource {

}

@Singleton
class LocalDatasourceImpl @Inject constructor(
    private val filmDao: FilmDao,
    private val locationDao: LocationDao,
    private val personDao: PersonDao,
    private val specieDao: SpecieDao,
    private val vehicleDao: VehicleDao,
) : LocalDatasource {

}