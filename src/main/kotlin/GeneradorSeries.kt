package org.example

class GeneradorSeries (private val consola: IGestorConsola) {
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
        consola.mostrarMensaje("Suma -> $suma")
    }

    fun serieDecreciente(numero: Int, min: Int) {
        var total = 0
        var suma = ""
        var count = 1
        var num = numero
        var numMin = min
        while (num >= min) {
            var sum = 0
            var numeros = ""
            for (i in num downTo min) {
                sum += i
                numeros += if (i == min) "$i" else "$i+"
                numMin--
            }
            total += sum
            suma += "${count++} -> $numeros = $sum\n"
            num--
        }
        suma += "Total => $total"
        consola.mostrarMensaje(suma)
    }
}