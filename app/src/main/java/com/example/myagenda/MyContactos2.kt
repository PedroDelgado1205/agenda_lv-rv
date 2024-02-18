package com.example.myagenda

import ContactosAdapter
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myagenda.clases.Persona
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MyContactos2 : AppCompatActivity() {
    lateinit var rvContactos: RecyclerView // Cambié el tipo de variable
    lateinit var lista: List<Persona> // No inicialices la lista aquí

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_contactos2)

        rvContactos = findViewById(R.id.rvcontactos) // Encuentra el RecyclerView

        val json = intent.getStringExtra("lista") // Mueve la inicialización aquí
        if (!json.isNullOrEmpty()) {
            val gson = Gson()
            lista = gson.fromJson(json, object : TypeToken<List<Persona>>() {}.type)
            cargarLista()
        } else {
            // Manejar el caso en el que el JSON sea nulo o vacío
            // Por ejemplo, mostrar un mensaje de error
        }

        val ibRegresar: ImageButton = findViewById(R.id.ibregresar)
        ibRegresar.setOnClickListener {
            finish()
        }
    }

    fun cargarLista(){
        // Crea un adaptador personalizado para tu RecyclerView
        val adapter = ContactosAdapter(lista)
        // Configura el RecyclerView con un LinearLayoutManager
        rvContactos.layoutManager = LinearLayoutManager(this)
        // Establece el adaptador en el RecyclerView
        rvContactos.adapter = adapter
    }
}
