package com.lidorttol.pruebamercadona.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.lidorttol.pruebamercadona.data.local.dbo.person.PersonDbo

@Dao
interface PersonDao {

    @Query("DELETE FROM person")
    fun cleanPeople()

    @Query("SELECT * FROM person WHERE personId=:id")
    fun getPersonById(id: String) : PersonDbo

/*    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPeople(people: List<PersonDbo>): String

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPerson(person: PersonDbo): String*/

}