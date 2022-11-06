package com.lidorttol.pruebamercadona.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SpecieDto (
    val id: String,
    val name: String,
    val classification: String,

    @SerializedName("eye_colors")
    val eyeColors: String,

    @SerializedName("hair_colors")
    val hairColors: String,

    val people: List<String>,
    val films: List<String>,
    val url: String,
)