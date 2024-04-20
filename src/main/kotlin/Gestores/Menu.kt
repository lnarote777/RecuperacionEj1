package org.example.Gestores

import org.example.Interfaces.IGestorConsola
import org.example.Interfaces.IMenu
import org.example.Juegos.Ahorcado
import org.example.Juegos.GeneradorSeries

class Menu(
    private val consola: IGestorConsola,
): IMenu {

    private val genSeries = GeneradorSeries

    override fun mostrarMenu() {
        consola.mostrarMensaje("1. Generar serie", true)
        consola.mostrarMensaje("2. Jugar al ahorcado", true)
        consola.mostrarMensaje("3. Salir", true)
    }

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

    override fun jugarAhorcado() {
        Ahorcado(consola).jugar()
    }

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