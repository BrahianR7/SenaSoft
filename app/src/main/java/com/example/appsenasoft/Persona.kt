package com.example.appsenasoft

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "t_persona")
class Persona (val nombre:String,
               val documento:String,
               val tipo:String,
               @PrimaryKey(autoGenerate = true)
               var idPersona: Int = 0
) : Serializable