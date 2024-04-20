package org.example.Juegos

import org.example.Gestores.GestorConsola

object GeneradorSeries {

    private val consola = GestorConsola()

    fun generarRangoAleatorio(): Pair<Int, Int> {

        do {
            val num1 = (1..100).random()
            val num2 = (1..100).random()

            if ((num1 - num2) >= 30){
                return if (num1 < num2) Pair(num1, num2) else Pair(num2, num1)
            }else{
                continue
            }
        }while (true)


    }

    fun generarSerie(numero: Int, min: Int, max: Int){

        val mitad = (min + max)/2

        if (numero >= mitad){
            serieCreciente(numero, max)
        }else{
            serieDecreciente(numero, min)
        }
    }

    fun serieCreciente(numero: Int, max: Int){
        var suma = 0
        var count = 0
        var sumaStr = ""
        for (i in numero..max){
            val str = "($count)"
            count++
            suma += i
            if (sumaStr.isBlank()) sumaStr += " $i " else sumaStr += " + $i"

            consola.mostrarMensaje(sumaStr)
            consola.mostrarMensaje(str, true)
        }
        consola.mostrarMensaje("Suma -> $suma", true)
    }

    fun serieDecreciente(numero: Int, min: Int) {
        var total = 0
        var suma = ""
        var count = 1
        var num = numero
        var numMin = min
        while (num >= numMin) {
            var sum = 0
            var numeros = ""
            for (i in num downTo numMin) {
                sum += i
                numeros += if (i == numMin) "$i" else "$i+"
            }
            total += sum
            suma += "${count++} -> $numeros = $sum\n"
            numMin++
        }
        suma += "Total => $total"
        consola.mostrarMensaje(suma, true)
    }
}