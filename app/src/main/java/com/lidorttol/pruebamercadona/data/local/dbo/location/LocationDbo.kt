package com.lidorttol.pruebamercadona.data.local.dbo.location

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "location")
data class LocationDbo(
    @PrimaryKey
    @SerializedName("id")
    val locationId: String,
    val name: String,
    val climate: String,
    val terrain: String,
    val surfaceWater: String,
)