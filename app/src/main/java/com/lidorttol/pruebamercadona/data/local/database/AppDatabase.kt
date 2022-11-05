package com.lidorttol.pruebamercadona.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lidorttol.pruebamercadona.data.local.dao.*
import com.lidorttol.pruebamercadona.data.local.dbo.film.*
import com.lidorttol.pruebamercadona.data.local.dbo.location.LocationDbo
import com.lidorttol.pruebamercadona.data.local.dbo.person.PersonDbo
import com.lidorttol.pruebamercadona.data.local.dbo.specie.SpecieDbo
import com.lidorttol.pruebamercadona.data.local.dbo.vehicle.VehicleDbo

@Database(
    entities = [
        FilmDbo::class,
        LocationDbo::class,
        PersonDbo::class,
        SpecieDbo::class,
        VehicleDbo::class,
        FilmCrossLocationDbo::class,
        FilmCrossPersonDbo::class,
        FilmCrossSpecieDbo::class,
        FilmCrossVehicleDbo::class,
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun filmDao(): FilmDao

    abstract fun locationDao(): LocationDao

    abstract fun personDao(): PersonDao

    abstract fun specieDao(): SpecieDao

    abstract fun vehicleDao(): VehicleDao

}