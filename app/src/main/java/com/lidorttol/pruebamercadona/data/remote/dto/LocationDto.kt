package com.lidorttol.pruebamercadona.data.remote.dto

import com.google.gson.annotations.SerializedName

data class LocationDto (
    val id: String,
    val name: String,
    val climate: String,
    val terrain: String,

    @SerializedName("surface_water")
    val surfaceWater: String,

    val residents: List<String>,
    val films: List<String>,
)