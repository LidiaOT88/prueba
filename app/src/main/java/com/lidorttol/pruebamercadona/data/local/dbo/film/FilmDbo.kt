package com.lidorttol.pruebamercadona.data.local.dbo.film

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "film")
data class FilmDbo(
  @PrimaryKey
  @SerializedName("id")
  val filmId: String,
  val title: String,
  val originalTitle: String,
  val originalTitleRomanised: String,
  val image: String,
  val movieBanner: String,
  val description: String,
  val director: String,
  val producer: String,
  val releaseDate: String,
  val runningTime: String,
  val rtScore: String,
)