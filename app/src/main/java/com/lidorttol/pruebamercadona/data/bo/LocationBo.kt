package com.lidorttol.pruebamercadona.data.bo

data class LocationBo (
    val id: String,
    val name: String? = null,
    val climate: String? = null,
    val terrain: String? = null,
    val surfaceWater: String? = null,
    val residents: List<PersonBo>? = null,
    val films: List<FilmBo>? = null,
) {

    fun isValid() =
        !(name.isNullOrEmpty()
                || climate.isNullOrEmpty()
                || terrain.isNullOrEmpty()
                || surfaceWater.isNullOrEmpty())

}