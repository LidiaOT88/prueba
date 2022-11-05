package com.lidorttol.pruebamercadona.data.local.dbo.vehicle

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "vehicle")
data class VehicleDbo(
    @PrimaryKey
    @SerializedName("id")
    val vehicleId: String,
    val name: String,
    val description: String,
    val vehicleClass: String,
    val length: String,
    val personId: String,
)