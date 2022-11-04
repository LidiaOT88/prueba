package com.lidorttol.pruebamercadona.data.remote.dto

import com.google.gson.annotations.SerializedName

data class VehicleDto (
    val id: String,
    val name: String,
    val description: String,

    @SerializedName("vehicle_class")
    val vehicleClass: String,

    val length: String,
    val pilot: PersonDto,
    val films: List<FilmDto>,
    val url: String
)