package com.lidorttol.pruebamercadona.data.remote.dto

import com.google.gson.annotations.SerializedName

data class FilmDto (
  val id: String? = null,
  val title: String? = null,

  @SerializedName("original_title") 
  val originalTitle: String? = null,

  @SerializedName("original_title_romanised") 
  val originalTitleRomanised: String? = null,

  val image: String? = null,

  @SerializedName("movie_banner")
  val movieBanner: String? = null,

  val description: String? = null,
  val director: String? = null,
  val producer: String? = null,

  @SerializedName("release_date") 
  val releaseDate: String? = null,

  @SerializedName("running_time") 
  val runningTime: String? = null,

  @SerializedName("rt_score") 
  val rtScore: String? = null,

  val people: List<PersonDto>? = null,
  val species: List<String>? = null,
  val locations: List<String>? = null,
  val vehicles: List<String>? = null,
  val url: String? = null
)