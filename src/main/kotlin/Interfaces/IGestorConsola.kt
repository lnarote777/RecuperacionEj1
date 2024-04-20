package org.example.Interfaces

interface IGestorConsola {
    fun mostrarMensaje(mesj: String, salto: Boolean = false)
    fun pedirEntero(mensaje: String): Int?
    fun pedirString(mensaje: String): String
    fun enterContinuar()
}