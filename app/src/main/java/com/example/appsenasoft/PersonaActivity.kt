package com.example.appsenasoft

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class PersonaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_persona)

        val persona = intent.getSerializableExtra(persona) as Persona

        nombre_persona.text = persona.nombre
        documento_persona.text = persona.documento
        tipo_persona.text = persona.tipo
    }
}