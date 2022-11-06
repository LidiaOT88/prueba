package com.lidorttol.pruebamercadona.data.bo

data class FilmBo (
  val id: String,
  val title: String? = null,
  val originalTitle: String? = null,
  val originalTitleRomanised: String? = null,
  val image: String? = null,
  val movieBanner: String? = null,
  val description: String? = null,
  val director: String? = null,
  val producer: String? = null,
  val releaseDate: String? = null,
  val runningTime: String? = null,
  val rtScore: String? = null,
  val people: List<PersonBo>? = null,
  val species: List<SpecieBo>? = null,
  val locations: List<LocationBo>? = null,
  val vehicles: List<VehicleBo>? = null,
) {

  fun isValid() =
    !(title.isNullOrEmpty()
          || title.isNullOrEmpty()
          || originalTitle.isNullOrEmpty()
          || originalTitleRomanised.isNullOrEmpty()
          || image.isNullOrEmpty()
          || movieBanner.isNullOrEmpty()
          || description.isNullOrEmpty()
          || director.isNullOrEmpty()
          || producer.isNullOrEmpty()
          || releaseDate.isNullOrEmpty()
          || runningTime.isNullOrEmpty()
          || rtScore.isNullOrEmpty())

}