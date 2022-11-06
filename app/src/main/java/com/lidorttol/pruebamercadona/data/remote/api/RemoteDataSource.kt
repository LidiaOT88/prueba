package com.lidorttol.pruebamercadona.data.remote.api

import com.lidorttol.pruebamercadona.data.bo.*

interface RemoteDataSource {

    suspend fun getFilms(): List<FilmBo>

    suspend fun getFilmById(id: String): FilmBo

    suspend fun getLocationById(id: String): LocationBo

    suspend fun getPersonById(id: String): PersonBo

    suspend fun getSpecieById(id: String): SpecieBo

    suspend fun getVehicleById(id: String): VehicleBo

    suspend fun getLocations(): List<LocationBo>

    suspend fun getPeople(): List<PersonBo>

    suspend fun getSpecies(): List<SpecieBo>

    suspend fun getVehicles(): List<VehicleBo>

}