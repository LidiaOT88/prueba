package com.lidorttol.pruebamercadona.data.local.dbo.person

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "person")
data class PersonDbo(
    @PrimaryKey
    @SerializedName("id")
    val personId: String,
    val name: String?,
    val gender: String?,
    val age: String?,
    val eyeColor: String?,
    val hairColor: String?,
    val personLocationId: String?,
    val personSpecieId: String?,
    val personFilmId: String?,
) {

    fun isEmpty() =
        name.isNullOrEmpty()
                || gender.isNullOrEmpty()
                || age.isNullOrEmpty()
                || eyeColor.isNullOrEmpty()
                || hairColor.isNullOrEmpty()

}