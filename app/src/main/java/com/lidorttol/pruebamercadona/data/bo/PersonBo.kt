package com.lidorttol.pruebamercadona.data.bo

data class PersonBo (
    val id: String,
    val name: String? = null,
    val gender: String? = null,
    val age: String? = null,
    val eyeColor: String? = null,
    val hairColor: String? = null,
    val films: List<FilmBo>? = null,
    val specie: SpecieBo? = null,
) {

    fun isValid() =
        !(name.isNullOrEmpty()
                || gender.isNullOrEmpty()
                || age.isNullOrEmpty()
                || eyeColor.isNullOrEmpty()
                || hairColor.isNullOrEmpty())

}