package com.example.appsenasoft

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

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
}