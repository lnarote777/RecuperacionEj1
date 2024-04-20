package org.example

import org.example.Gestores.GestorConsola
import org.example.Gestores.Menu
import org.example.Juegos.GeneradorSeries

fun main() {
    val consola = GestorConsola()
    val menu = Menu(consola)

    menu.menu()
}