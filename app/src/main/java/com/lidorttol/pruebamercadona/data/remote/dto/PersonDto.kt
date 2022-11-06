package com.lidorttol.pruebamercadona.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PersonDto (
    val id: String,
    val name: String,
    val gender: String,
    val age: String,

    @SerializedName("eye_color")
    val eyeColor: String,

    @SerializedName("hair_color")
    val hairColor: String,

    val films: List<String>,
    val specie: String,
    val url: String,
)