package com.lidorttol.pruebamercadona.data.local.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface VehicleDao {

    @Query("DELETE FROM vehicle")
    fun cleanVehicles()

    /*@Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVehicles(vehicles: List<VehicleDbo>): String

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVehicle(vehicle: VehicleDbo): String*/

}