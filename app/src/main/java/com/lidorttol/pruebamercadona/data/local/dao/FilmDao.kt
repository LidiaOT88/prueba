package com.lidorttol.pruebamercadona.data.local.dao

import androidx.room.*
import com.lidorttol.pruebamercadona.data.local.dbo.film.*
import com.lidorttol.pruebamercadona.data.local.dbo.location.LocationDbo
import com.lidorttol.pruebamercadona.data.local.dbo.person.PersonDbo
import com.lidorttol.pruebamercadona.data.local.dbo.specie.SpecieDbo
import com.lidorttol.pruebamercadona.data.local.dbo.vehicle.VehicleDbo

@Dao
interface FilmDao {

    @Query("DELETE FROM film")
    fun cleanFilms()

    @Query("DELETE FROM film WHERE filmId=:id")
    fun deleteFilmById(id: String)

    @Query("SELECT * FROM film")
    fun getFilms(): List<FilmDbo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFilm(film: FilmDbo)

    @Query("SELECT * FROM film WHERE filmId=:id")
    fun getFilmById(id: String): FilmDbo

    @Query("SELECT * FROM film WHERE filmId=:id")
    fun getFilmByIdWithLocations(id: String): FilmWithLocationDbo

    @Query("SELECT * FROM film WHERE filmId=:id")
    fun getFilmByIdWithPeople(id: String): FilmWithPersonDbo

    @Query("SELECT * FROM film WHERE filmId=:id")
    fun getFilmByIdWithSpecies(id: String): FilmWithSpecieDbo

    @Query("SELECT * FROM film WHERE filmId=:id")
    fun getFilmByIdWithVehicles(id: String): FilmWithVehicleDbo

}