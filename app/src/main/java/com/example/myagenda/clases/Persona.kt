package com.example.myagenda.clases

class Persona(var id: Int,var nombre: String, var telefono: String, var email: String) {
    override fun toString(): String {
        return "${this.id}, ${this.nombre}, ${this.telefono}, ${this.email}"
    }
}