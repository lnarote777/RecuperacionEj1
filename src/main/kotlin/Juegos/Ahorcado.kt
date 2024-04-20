package org.example.Juegos

import org.example.Gestores.GestorConsola
import org.example.Interfaces.IGestorConsola

class Ahorcado (private val consola: IGestorConsola, private var maxIntentos: Int = 5){

    private val palabra = Palabra.obtenerPalabraAleatoria()
    private val longitudPalabra = palabra.length
    private var palabraOculta = ocultarPalabra()

    fun jugar() {

        while (maxIntentos != 0 && palabraOculta != palabra) {
            consola.mostrarMensaje("Palabra: $palabraOculta", true)

            val letra = consola.pedirString("Intenta con una letra:")

            if (letra in palabra) {
                consola.mostrarMensaje("Correcto!", true)
                mostrarLetra(letra)
            } else {
                consola.mostrarMensaje("Incorrecto! Intentos restantes: ${--maxIntentos}", true)
            }

        }

        if (maxIntentos == 0) {
            consola.mostrarMensaje("Te has quedado sin intentos. La palabra era '$palabra'",true)
        }else{
            consola.mostrarMensaje("Felicidades! Adivinaste la palabra '$palabra'", true)
        }

        consola.enterContinuar()

    }

    private fun ocultarPalabra(): String{
        var palabraOculta = ""
        repeat(longitudPalabra){
            palabraOculta += "_"
        }
        return palabraOculta
    }

    private fun mostrarLetra(letra: String,){
        val nuevaPalabraOculta = StringBuilder(palabraOculta)
        for (i in palabra.indices){
            if (palabra[i] == letra[0]){
                nuevaPalabraOculta[i] = letra[0]
            }
        }
        palabraOculta = nuevaPalabraOculta.toString()

    }

}