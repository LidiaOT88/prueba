package com.lidorttol.pruebamercadona.data.remote.api

import com.lidorttol.pruebamercadona.data.bo.*
import com.lidorttol.pruebamercadona.data.mapper.dtoToBo
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : RemoteDataSource {

    override suspend fun getFilms(): List<FilmBo> {
        return apiService.getFilms().map { it.dtoToBo() }
    }

    override suspend fun getFilmById(id: String): FilmBo {
        return apiService.getFilm(id).dtoToBo()
    }

    override suspend fun getLocationById(id: String): LocationBo {
        return apiService.getLocation(id).dtoToBo()
    }

    override suspend fun getPersonById(id: String): PersonBo {
        return apiService.getPerson(id).dtoToBo()
    }

    override suspend fun getSpecieById(id: String): SpecieBo {
        return apiService.getSpecie(id).dtoToBo()
    }

    override suspend fun getVehicleById(id: String): VehicleBo {
        return apiService.getVehicle(id).dtoToBo()
    }

    override suspend fun getLocations(): List<LocationBo> {
        return apiService.getLocations().map { it.dtoToBo() }
    }

    override suspend fun getPeople(): List<PersonBo> {
        return apiService.getPerson().map { it.dtoToBo() }
    }

    override suspend fun getSpecies(): List<SpecieBo> {
        return apiService.getSpecies().map { it.dtoToBo() }
    }

    override suspend fun getVehicles(): List<VehicleBo> {
        return apiService.getVehicles().map { it.dtoToBo() }
    }

}