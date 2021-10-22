package com.example.appsenasoft

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PersonasDao {
    @Query("SELECT * FROM t_persona")
    fun getAll(): LiveData<List<Persona>>

    @Query("SELECT * FROM t_persona WHERE idPersona = :id")
    fun get(id :Int): LiveData<Persona>

    @Insert
    fun insertAll(vararg personas: Persona)

    @Update
    fun update(persona: Persona)

    @Delete
    fun delete(persona: Persona)
}