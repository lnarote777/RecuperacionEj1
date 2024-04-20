package org.example.Juegos

import org.example.Interfaces.IGestorConsola

/**
 * Clase que representa el juego del Ahorcado.
 * @property consola El gestor de la consola utilizado para la interacción.
 * @property maxIntentos El número máximo de intentos permitidos para adivinar la palabra.
 */
class Ahorcado (private val consola: IGestorConsola, private var maxIntentos: Int = 5){

    private val palabra = Palabra.obtenerPalabraAleatoria()
    private val longitudPalabra = palabra.length
    private var palabraOculta = ocultarPalabra()

    /**
     * Inicia el juego del Ahorcado.
     */
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

    /**
     * Oculta la palabra para mostrarla como una serie de guiones bajos.
     * @return La palabra oculta como una cadena de guiones bajos.
     */
    private fun ocultarPalabra(): String{
        var palabraOculta = ""
        repeat(longitudPalabra){
            palabraOculta += "_"
        }
        return palabraOculta
    }

    /**
     * Muestra la letra adivinada en la palabra oculta si corresponde.
     * @param letra La letra a mostrar en la palabra oculta.
     */
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