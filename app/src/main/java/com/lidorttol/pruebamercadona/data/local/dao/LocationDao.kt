package com.lidorttol.pruebamercadona.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lidorttol.pruebamercadona.data.local.dbo.film.FilmWithLocationDbo
import com.lidorttol.pruebamercadona.data.local.dbo.location.LocationDbo

@Dao
interface LocationDao {

    @Query("DELETE FROM location")
    fun cleanLocations()

    @Query("SELECT * FROM location WHERE locationFilmId=:filmId")
    fun getLocations(filmId: String): List<LocationDbo>

    /*@Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLocations(locations: List<LocationDbo>): String

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLocation(location: LocationDbo): String*/

}