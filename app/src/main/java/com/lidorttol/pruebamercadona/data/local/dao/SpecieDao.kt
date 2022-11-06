package com.lidorttol.pruebamercadona.data.local.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface SpecieDao {

    @Query("DELETE FROM specie")
    fun cleanSpecies()

/*    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSpecies(species: List<SpecieDbo>): String

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSpecie(specie: SpecieDbo): String*/

}