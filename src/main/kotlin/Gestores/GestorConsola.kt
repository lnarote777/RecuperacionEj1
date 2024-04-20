package org.example.Gestores

import org.example.Interfaces.IGestorConsola

class GestorConsola: IGestorConsola {
    override fun mostrarMensaje(mesj: String, salto: Boolean) {
        if (salto) println(mesj) else print(mesj)
    }

    override fun pedirEntero(mensaje: String): Int? {
        mostrarMensaje(mensaje)
        val opcion = readln().toIntOrNull()
        return opcion
    }

    override fun pedirString(mensaje: String): String {
        mostrarMensaje(mensaje, true)
        return readln()
    }

    /**
     * Espera a que el usuario presione <ENTER> para continuar.
     */
    override fun enterContinuar() {
        mostrarMensaje(">> Dale <ENTER> para continuar...")
        readln()
    }



}