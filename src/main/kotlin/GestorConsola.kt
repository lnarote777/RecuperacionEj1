package org.example

class GestorConsola: IGestorConsola {
    override fun mostrarMensaje(mesj: String, salto: Boolean) {
        if (salto) println(mesj) else print(mesj)
    }

    override fun pedirEntero(mensaje: String): Int? {
        mostrarMensaje(mensaje)
        val opcion = readln().toIntOrNull()
        return opcion
    }

}