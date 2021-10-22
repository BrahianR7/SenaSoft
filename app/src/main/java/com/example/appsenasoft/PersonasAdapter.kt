package com.example.appsenasoft

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

class PersonasAdapter(private val mContext: Context, private val listaPersonas: List<Persona>) : ArrayAdapter<Persona> (mContext, 0, listaPersonas) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_persona, parent, false)

        val persona = listaPersonas[position]

        layout.nombre.text = persona.nombre
        layout.documento.text = persona.documento
        layout.tipo.text = persona.tipo

        return layout
    }
}