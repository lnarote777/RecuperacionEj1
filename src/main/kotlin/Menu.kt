package org.example

class Menu(
    private val consola: IGestorConsola,
    private val genSeries: GeneradorSeries,
    private val ahorcado: Ahorcado
): IMenu{


    override fun mostrarMenu() {
        consola.mostrarMensaje("1. Generar serie\n2. Jugar al ahorcado\n3.Salir", true)
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
        ahorcado.jugar()
    }

}