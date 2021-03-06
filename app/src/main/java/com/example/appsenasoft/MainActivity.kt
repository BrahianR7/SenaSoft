package com.example.appsenasoft

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import com.google.android.material.navigation.NavigationView

class   MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout
    private lateinit var toogle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listaPersonas = emptyList<Persona>()

        val database = AppDatabase.getDatabase(this)

        database.personas().getAll().observe(this, Observer {
            listaPersonas = it

            val adapter = PersonasAdapter (this, listaPersonas)

            lista.adapter = adapter
        })
        
        lista.setInClickListener { parent, view, position, id ->
            val intent = Intent(this, PersonaActivity::class.java)
            intent.putExtra("id", listaPersonas[position].idPersona)
            startActivity(intent)
        }

            floatingActionButton.setOnClickListener{
                val intent = Intent(this, NuevaPersonaActivity::clase.java)
                startActivity(intent)
        }

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)

        toogle = ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toogle)






        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)



}


    override fun onNavigationItemSelected(item: MenuItem): Boolean {


        when (item.itemId) {
            R.id.nav_home -> Toast.makeText(this, "Registro",Toast.LENGTH_SHORT).show()
            R.id.nav_exit -> Toast.makeText(this, "Salida",Toast.LENGTH_SHORT).show()

        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toogle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toogle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item)){
            return  true
        }
        return super.onOptionsItemSelected(item)
    }

    }
//nav_view.setNavigationItemSelectedListener {
//     when(listOf(it)){
// R.id.nav_home -> {
//    supportFragmentManager.beginTransaction().apply {
//         replace(R.id.fragmentContainerView, HomeFragment())
//           commit()
//         }
//       }
//     }
//   }
// }

// override fun onOptionsItemSelected(item: MenuItem): Boolean {
// if (toogle.onOptionsItemSelected(item)){
//   return true
//}
//  return super.onOptionsItemSelected(item)
//}