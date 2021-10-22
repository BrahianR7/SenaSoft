package com.example.appsenasoft

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonaActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    private lateinit var persona: Persona
    private lateinit var personaLiveData: LiveData<Persona>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persona)

        database = AppDatabase.getDatabase(this)

        val idPersona = intent.getIntExtra("id", 0)

        personaLiveData = database.personas().get(idPersona)

        personaLiveData.observe(this, Observer {
            persona = it

            nombre_persona.text = persona.nombre
            documento_persona.text = persona.documento
            tipo_persona.text = persona.tipo
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.persona_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.edit_item->{
                var intent = Intent(this, NuevaPersonaActivity::class.java)
                intent.putExtra("persona", persona)
                startActivity(intent)
            }

            R.id.delete_item->{
                personaLiveData.removeObservers(this)

                CoroutineScope(Dispatchers.IO).launch {
                    database.personas().delete(persona)
                    this@PersonaActivity.finish()
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }
}