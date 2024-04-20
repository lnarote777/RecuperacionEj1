package org.example.Gestores

import org.example.Interfaces.IGestorConsola

/**
 * Implementación de IGestorConsola que interactúa con la consola.
 */
class GestorConsola: IGestorConsola {

    /**
     * Muestra un mensaje en la consola, opcionalmente con un salto de línea al final.
     * @param mesj El mensaje a mostrar.
     * @param salto Indica si se debe añadir un salto de línea al final del mensaje.
     */
    override fun mostrarMensaje(mesj: String, salto: Boolean) {
        if (salto) println(mesj) else print(mesj)
    }

    /**
     * Solicita al usuario que ingrese un número entero desde la consola.
     * @param mensaje El mensaje que se muestra al solicitar la entrada.
     * @return El número entero ingresado por el usuario, o null si la entrada no es un número entero.
     */
    override fun pedirEntero(mensaje: String): Int? {
        mostrarMensaje(mensaje)
        val opcion = readln().toIntOrNull()
        return opcion
    }

    /**
     * Solicita al usuario que ingrese una cadena de texto desde la consola.
     * @param mensaje El mensaje que se muestra al solicitar la entrada.
     * @return La cadena de texto ingresada por el usuario.
     */
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