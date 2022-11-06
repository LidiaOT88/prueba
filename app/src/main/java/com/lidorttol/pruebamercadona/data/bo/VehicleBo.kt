package com.lidorttol.pruebamercadona.data.bo

data class VehicleBo (
    val id: String,
    val name: String? = null,
    val description: String? = null,
    val vehicleClass: String? = null,
    val length: String? = null,
    val pilot: PersonBo? = null,
    val films: List<FilmBo>? = null,
) {

    fun isValid() =
        !(name.isNullOrEmpty()
                || description.isNullOrEmpty()
                || vehicleClass.isNullOrEmpty()
                || length.isNullOrEmpty())

}