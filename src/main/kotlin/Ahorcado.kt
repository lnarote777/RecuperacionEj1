package org.example

class Ahorcado(val consola: IGestorConsola, val maxIntentos: Int = 5) {

    fun jugar() {
        val palabra = palabraOculta()
    }

    fun palabraOculta(): String {
        val palabra = Palabra.obtenerPalabraAleatoria()
        val longitudPalabra = palabra.length
        val letras = palabra.split("")
        val palabraOculta = letras.forEach { it.replace(it, "_") }

        return palabraOculta.toString()
    }
}