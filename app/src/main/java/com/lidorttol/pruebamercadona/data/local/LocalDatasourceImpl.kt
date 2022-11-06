package com.lidorttol.pruebamercadona.data.local

import com.lidorttol.pruebamercadona.data.bo.FilmBo
import com.lidorttol.pruebamercadona.data.local.dao.*
import com.lidorttol.pruebamercadona.data.local.dbo.film.FilmDbo
import com.lidorttol.pruebamercadona.data.local.dbo.location.LocationDbo
import com.lidorttol.pruebamercadona.data.local.dbo.person.PersonDbo
import com.lidorttol.pruebamercadona.data.local.dbo.specie.SpecieDbo
import com.lidorttol.pruebamercadona.data.local.dbo.vehicle.VehicleDbo
import com.lidorttol.pruebamercadona.data.mapper.boToDbo
import com.lidorttol.pruebamercadona.data.mapper.dboToBo
import javax.inject.Inject
import javax.inject.Singleton

interface LocalDatasource {

    suspend fun cleanDataBase()

    suspend fun getFilms(): List<FilmBo>

    suspend fun saveShortFilm(film: FilmBo)

    suspend fun saveShortFilms(films: List<FilmBo>)

    suspend fun getFilmById(filmId: String): FilmBo

    suspend fun deleteFilmById(filmId: String)

}

@Singleton
class LocalDatasourceImpl @Inject constructor(
    private val filmDao: FilmDao,
    private val locationDao: LocationDao,
    private val personDao: PersonDao,
    private val specieDao: SpecieDao,
    private val vehicleDao: VehicleDao,
) : LocalDatasource {

     override suspend fun cleanDataBase() {
         filmDao.cleanFilms()
         locationDao.cleanLocations()
         personDao.cleanPeople()
         specieDao.cleanSpecies()
         vehicleDao.cleanVehicles()
     }

    override suspend fun getFilms(): List<FilmBo> {
        return filmDao.getFilms().map { it.dboToBo() }
    }

    override suspend fun saveShortFilm(film: FilmBo) {
        filmDao.insertFilm(film.boToDbo())
    }

    override suspend fun saveShortFilms(films: List<FilmBo>) {
        films.forEach { saveShortFilm(it) }
    }

    override suspend fun getFilmById(filmId: String): FilmBo {
        val film = filmDao.getFilmById(filmId)
        val filmLocations = filmDao.getFilmByIdWithLocations(filmId)
        val filmWithPeople = filmDao.getFilmByIdWithPeople(filmId)
        val filmWithSpecies = filmDao.getFilmByIdWithSpecies(filmId)
        val filmWithVehicles = filmDao.getFilmByIdWithVehicles(filmId)

        return buildFilmBo(
            film,
            filmLocations.locations,
            filmWithPeople.people,
            filmWithSpecies.species,
            filmWithVehicles.vehicles,
        )
    }

    override suspend fun deleteFilmById(filmId: String) {
        filmDao.deleteFilmById(filmId)
    }

    private fun buildFilmBo(
        film: FilmDbo,
        locations: List<LocationDbo>,
        people: List<PersonDbo>,
        species: List<SpecieDbo>,
        vehicles: List<VehicleDbo>,
    ): FilmBo {
        return FilmBo(
            film.filmId,
            film.title,
            film.originalTitle,
            film.originalTitleRomanised,
            film.image,
            film.movieBanner,
            film.description,
            film.director,
            film.producer,
            film.releaseDate,
            film.runningTime,
            film.rtScore,
            if (people.any { it.isEmpty() }) null else people.map { it.dboToBo() },
            species.map { it.dboToBo() },
            locations.map { it.dboToBo() },
            vehicles.map { it.dboToBo() },
        )
    }

}