package com.example.myagenda

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myagenda.clases.Persona
import com.example.myagenda.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var lista: MutableList<Persona>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lista = mutableListOf()

        binding.btnagregar.setOnClickListener {
            Toast.makeText(this, "agregar", Toast.LENGTH_SHORT).show()
            var nombre = binding.etnombre.text.toString()
            var telefono = binding.ettelefono.text.toString()
            var email = binding.etemail.text.toString()
            if (nombre.isEmpty() || nombre.isBlank()){
                Snackbar.make(binding.etnombre, "tiene que ingresar el nombre", Snackbar.LENGTH_SHORT).show()
            }else{
                lista.add(Persona(lista.size+1, nombre, telefono, email))
                Snackbar.make(binding.etnombre, "Elemanto guardado ${lista.size}", Snackbar.LENGTH_SHORT).show()
                //ListView
                binding.btnmostrar.setOnClickListener {
                    val intent = Intent(this, MyContactos::class.java)
                    val gson = Gson()
                    val json = gson.toJson(lista)
                    intent.putExtra("lista", json)
                    startActivity(intent)
                }
                //Recycle View
                binding.btnmostrar2.setOnClickListener {
                    val intent = Intent(this, MyContactos2::class.java)
                    val gson = Gson()
                    val json = gson.toJson(lista)
                    intent.putExtra("lista", json)
                    startActivity(intent)
                }
            }
        }
    }


}