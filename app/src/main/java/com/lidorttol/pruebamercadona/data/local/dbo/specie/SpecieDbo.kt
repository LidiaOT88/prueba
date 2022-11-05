package com.lidorttol.pruebamercadona.data.local.dbo.specie

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "specie")
data class SpecieDbo(
    @PrimaryKey
    @SerializedName("id")
    val specieId: String,
    val name: String,
    val classification: String,
    val eyeColors: String,
    val hairColors: String,
)