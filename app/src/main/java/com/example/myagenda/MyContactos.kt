package com.example.myagenda

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ListView
import com.example.myagenda.clases.Persona
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MyContactos : AppCompatActivity() {
    lateinit var lvContactos: ListView
    lateinit var lista: List<Persona> // No inicialices la lista aquí

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_contactos)

        lvContactos = findViewById(R.id.lvcontactos)

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
        lvContactos = findViewById(R.id.lvcontactos)
        ibRegresar.setOnClickListener {
            finish()
        }
    }

    fun cargarLista(){
        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lista)
        lvContactos.adapter = adapter
    }
}
