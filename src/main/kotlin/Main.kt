package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val consola = GestorConsola()
    val genSeries = GeneradorSeries(consola)
    val ahorcado = Ahorcado(consola)
    val menu = Menu(consola, genSeries, ahorcado)

    while(true){
        consola.mostrarMensaje(" ", true)
        menu.mostrarMenu()
        val opcion = consola.pedirEntero("Elija una opcion: ")
        consola.mostrarMensaje(" ", true)
        if (opcion != null) {
            when (opcion) {
                1 -> menu.generarSerie()
                2 -> menu.jugarAhorcado()
                3 -> break
                else -> consola.mostrarMensaje("Entrada no válida", true)
            }
        }else{
            consola.mostrarMensaje("Error", true)
        }
    }
}