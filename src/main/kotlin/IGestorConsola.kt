package org.example

interface IGestorConsola {
    fun mostrarMensaje(mesj: String, salto: Boolean = false)
    fun pedirEntero(mensaje: String): Int?
}