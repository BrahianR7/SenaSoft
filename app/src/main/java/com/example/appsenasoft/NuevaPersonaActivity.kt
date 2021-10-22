package com.example.appsenasoft

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NuevaPersonaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_persona)

        var idPersona: Int? = null

        if (intent.hasExtra("persona")){
            val persona = intent.extras?.getSerializable("persona") as Persona

            nombre_et.setText(persona.nombre)
            documento_et.setText(persona.documento)
            tipo_et.setText(persona.tipo)
            idPersona = persona.idPersona
        }

        val database = AppDatabase.getDatabase(this)

        seve_btn.setOnClickListener{
            val nombre = nombre_et.text.toString()
            val documento = documento_et.text.toString()
            val tipo = tipo_et.text.toString()

            val persona = Persona(nombre, documento, tipo, R.drawable.ic_launcher_background)

            if (idPersona != null){
                CoroutineScope(Dispatchers.IO).launch {
                    persona.idPersona = idPersona
                    database.personas().update(persona)

                    this@NuevaPersonaActivity.finish()
                }
            }else{
                CoroutineScope(Dispatchers.IO).launch{
                    database.personas().insertAll(persona)

                    this@NuevaPersonaActivity.finish()
                }
            }
        }
    }
}