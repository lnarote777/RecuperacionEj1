package org.example.Gestores

import org.example.Interfaces.IGestorConsola
import org.example.Interfaces.IMenu
import org.example.Juegos.Ahorcado
import org.example.Juegos.GeneradorSeries

/**
 * Clase que representa un menú de opciones interactivo.
 * @property consola El gestor de la consola utilizado para la interacción.
 */
class Menu(
    private val consola: IGestorConsola,
): IMenu {

    private val genSeries = GeneradorSeries

    /**
     * Muestra las opciones del menú en la consola.
     */
    override fun mostrarMenu() {
        consola.mostrarMensaje("1. Generar serie", true)
        consola.mostrarMensaje("2. Jugar al ahorcado", true)
        consola.mostrarMensaje("3. Salir", true)
    }

    /**
     * Genera una serie de números aleatorios dentro de un rango específico solicitando entrada al usuario.
     */
    override fun generarSerie() {
        val( min, max ) = genSeries.generarRangoAleatorio()

        do {
            val numero = consola.pedirEntero("Introduzca un numero entre [$min - $max]-> ")
            if (numero != null){
                genSeries.generarSerie(numero, min, max)
            }else{
                consola.mostrarMensaje("Entrada no válida.")
            }

            if (numero !in min..max){
                consola.mostrarMensaje("Numero fuera de rango. Vuelva a introducirlo", true)
            }

        }while (numero !in min..max)

    }

    /**
     * Inicia el juego del ahorcado.
     */
    override fun jugarAhorcado() {
        Ahorcado(consola).jugar()
    }

    /**
     * Muestra el menú y maneja las selecciones del usuario hasta que elige salir.
     */
    override fun menu() {
        while(true){
            consola.mostrarMensaje(" ", true)
            mostrarMenu()

            val opcion = consola.pedirEntero("Elija una opción: ")
            consola.mostrarMensaje(" ", true)

            if (opcion != null) {
                when (opcion) {
                    1 -> generarSerie()
                    2 -> jugarAhorcado()
                    3 -> {
                        consola.mostrarMensaje("Saliendo...")
                        Thread.sleep(1000)
                        break
                    }
                    else -> consola.mostrarMensaje("Entrada no válida", true)
                }
            }else{
                consola.mostrarMensaje("Error", true)
            }
        }
    }

}