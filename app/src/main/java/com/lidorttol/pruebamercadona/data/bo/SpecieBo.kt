package com.lidorttol.pruebamercadona.data.bo

data class SpecieBo (
    val id: String,
    val name: String? = null,
    val classification: String? = null,
    val eyeColors: String? = null,
    val hairColors: String? = null,
    val people: List<PersonBo>? = null,
    val films: List<FilmBo>? = null,
) {

    fun isValid() =
        !(name.isNullOrEmpty()
                || classification.isNullOrEmpty()
                || eyeColors.isNullOrEmpty()
                || hairColors.isNullOrEmpty())

}